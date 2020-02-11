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

    List<ItemList> itemList;
    PostAdapter postAdapter;

    public RakutenFrag(List<ItemList> itemList) {
        this.itemList = itemList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.rakuten_fragment, container, false);

        RecyclerView rvList = rootView.findViewById(R.id.rakuten_rv);

        rvList.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL,false));
        postAdapter = new PostAdapter(rootView.getContext(), itemList);

        rvList.setAdapter(postAdapter);


        return rootView;
    }

}
