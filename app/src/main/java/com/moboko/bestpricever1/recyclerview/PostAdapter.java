package com.moboko.bestpricever1.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moboko.bestpricever1.R;
import com.moboko.bestpricever1.entity.ItemList;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private Context mContext;
    private List<ItemList> itemLists;
    View baseView;


    public PostAdapter(Context context,List<ItemList> itemList){
        mContext = context;
        itemLists = itemList;

    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        baseView = View.inflate(mContext,R.layout.item_view,null);
        PostViewHolder postViewHolder = new PostViewHolder(baseView,this);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        ItemList item = itemLists.get(position);
        String url =item.getImgUrl();

        holder.tvItemNm.setText(String.valueOf(item.getItemName()));
        holder.tvItemPrice.setText(String.valueOf(item.getItemPrice()));

        Glide.with(baseView).load(url).into(holder.ivItemImg);

    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public void onLikeClicked(int position) {
        ItemList item = itemLists.get(position);
        Toast.makeText(mContext,position + ":" + item.getItemName(),Toast.LENGTH_SHORT).show();
     }
}
