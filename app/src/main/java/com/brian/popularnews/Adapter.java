package com.brian.popularnews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.brian.popularnews.Models.Article;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public  class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {

    private  List<Article> articles;
    private  Context context;
   private OnItemClickListener onItemClickListener;


    public Adapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view, onItemClickListener);



    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        final MyViewHolder holder = holders;
        Article model = articles.get(position);

        RequestOptions requestOptions = new RequestOptions();

        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(context)
                .load(model.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Drawable> target, boolean isFirstResource)
                    {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model,
                                                   Target<Drawable> target, DataSource dataSource,
                                                   boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);
        holder.title.setText(model.getTitle());
        holder.publishedAt.setText(model.getPublishAt());
        holder.source.setText(model.getSource().getName());
        holder.desc.setText(model.getDescription());
//        holder.time.setText("\u2022" + Utils.DateToTimeFormat(model.getPublishAt()));
        try {
            holder.time.setText("\u2021" + Utils.DateToTimeFormat(model.getPublishAt()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.author.setText(model.getAuthor());


    }


    @Override
    public int getItemCount() {
        return articles.size();
    }
    public  void  setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void  onItemClick(View view , int position);


    }

    public  class  MyViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView desc, author, source, time, title, publishedAt;
        ImageView imageView;
        ProgressBar progressBar;
        OnItemClickListener onItemClickListener;
        public MyViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
            source = itemView.findViewById(R.id.source);
            author = itemView.findViewById(R.id.author);
            desc = itemView.findViewById(R.id.desc);
            publishedAt = itemView.findViewById(R.id.publishedAt);
            imageView = itemView.findViewById(R.id.img);
            progressBar = itemView.findViewById(R.id.prograss_load);

            this.onItemClickListener = this.onItemClickListener;
        }

        @Override
        public void onClick(View view) {

//            onItemClickListener.onItemClick(view, getAbsoluteAdapterPosition());

        }
    }
}
