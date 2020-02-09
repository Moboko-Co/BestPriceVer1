package com.moboko.bestpricever1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.moboko.bestpricever1.api.RakutenApi;
import com.moboko.bestpricever1.entity.ItemList;
import com.moboko.bestpricever1.entity.RakutenItem;
import com.moboko.bestpricever1.recyclerview.PostAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RakutenFrag extends Fragment {

    ArrayList<ItemList> itemList;
    PostAdapter postAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fetchAsyncPosts();

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.rakuten_fragment, container, false);


        RecyclerView rvList = rootView.findViewById(R.id.rakuten_rv);

        rvList.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL,false));
        postAdapter = new PostAdapter(rootView.getContext(), itemList);

        rvList.setAdapter(postAdapter);


        return rootView;
    }

    private void fetchAsyncPosts() {
        itemList = new ArrayList<>();
        FetchPostsTask fetchPostsTask = new FetchPostsTask();
        fetchPostsTask.execute(RakutenApi.GET_POST);
    }

    class FetchPostsTask extends AsyncTask<String, Void, RakutenItem>{

        @Override
        protected RakutenItem doInBackground(String... strings) {

            String url = strings[0];

            OkHttpClient client = new OkHttpClient();

            Request builder = new Request.Builder()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(builder).execute();

                Gson gson = new Gson();
                String res = response.body().string();

                RakutenItem rakutenItem =  gson.fromJson(res, RakutenItem.class);

                return rakutenItem;

            } catch (IOException e) {
                Log.d("FetchPostsTask",e.getMessage());
                return null;
            }

        }
        @Override
        protected void onPostExecute(RakutenItem s){
            super.onPostExecute(s);


            for(int i = 0; i < s.getItems().size(); i++){
                RakutenItem.Items items = s.getItems().get(i);
                RakutenItem.Items.Item item = items.getItem();

                ItemList itemList1 = new ItemList(item.getSmallImageUrls().get(0).getImageUrl(),item.getItemName(),item.getItemPrice());

                itemList.add(itemList1);
            }

            postAdapter.notifyDataSetChanged();

            Log.d("FetchPostsTask", String.valueOf(s));
        }
    }

}
