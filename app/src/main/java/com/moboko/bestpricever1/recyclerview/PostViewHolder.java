package com.moboko.bestpricever1.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moboko.bestpricever1.R;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView ivItemImg;
    public TextView tvItemNm,tvItemPrice;
    public PostAdapter mAdapter;

    public PostViewHolder(@NonNull View itemView, PostAdapter postAdapter) {
        super(itemView);

        mAdapter = postAdapter;

        ivItemImg = itemView.findViewById(R.id.iv_item_img);
        tvItemNm = itemView.findViewById(R.id.tv_item_nm);
        tvItemPrice = itemView.findViewById(R.id.tv_item_price);

        ivItemImg.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();

        mAdapter.onLikeClicked(position);



    }
}
