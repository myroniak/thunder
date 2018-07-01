package com.letzgro.thecoffeethunder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.model.Drink;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Drink> mListPost = new ArrayList<>();
    private Context mContext;


    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cupImage;
        private TextView title;

        private ViewHolder(View view) {
            super(view);

            cupImage = view.findViewById(R.id.imageView);
            title = view.findViewById(R.id.title);
        }
    }


    public RecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coffee, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.title.setText(getPost(position).getName());
        Glide.with(mContext).load(R.mipmap.cup).apply(new RequestOptions().override(300, 300)).into(holder.cupImage);
    }

    @Override
    public int getItemCount() {
        return mListPost.size();
    }

    private Drink getPost(int position) {
        return mListPost.get(position);
    }


   /* public void addAll(ArrayList<Drink> list) {
        mListPost.addAll(list);
        notifyDataSetChanged();
    }*/

    public void updateList(ArrayList<Drink> list) {
        mListPost.clear();
        mListPost.addAll(list);
        notifyDataSetChanged();
    }

    public ArrayList<Drink> getList() {
        return mListPost;
    }
}