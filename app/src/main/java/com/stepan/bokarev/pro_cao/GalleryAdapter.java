package com.stepan.bokarev.pro_cao;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;


public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ImageModel> data = new ArrayList<>();

    public GalleryAdapter(Context context, List<ImageModel> data) {
        this.context = context;
        this.data = data;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);
        viewHolder = new MyItemHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // ( (MyItemHolder) holder).tv.setText(data.get(position).getName());
        Glide.with(context).load(data.get(position).getUrl())
                .thumbnail(0.5f)
                .override(200, 200)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(((MyItemHolder) holder).mImg);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyItemHolder extends RecyclerView.ViewHolder {
        ImageView mImg;
       // Toolbar bar;
        //TextView tv;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public MyItemHolder(View itemView) {
            super(itemView);
           /* bar = itemView.findViewById(R.id.detail_toolbar);
            bar.setTitle("test");*/
            // tv = (TextView) itemView.findViewById(R.id.tv);
            mImg = (ImageView) itemView.findViewById(R.id.item_img);
        }

    }


}
