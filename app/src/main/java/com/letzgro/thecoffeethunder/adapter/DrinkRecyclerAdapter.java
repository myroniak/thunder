package com.letzgro.thecoffeethunder.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.model.Drink;
import com.letzgro.thecoffeethunder.util.PreferencesManager;

import java.util.ArrayList;


public class DrinkRecyclerAdapter extends RecyclerView.Adapter<DrinkRecyclerAdapter.ViewHolder> {

    private ArrayList<Drink> mListPost = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private Button edit, remove;
        private LinearLayout single, small, medium, large;
        private TextView singlePrice, smallPrice, mediumPrice, largePrice;

        private ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            single = view.findViewById(R.id.ll_single);
            small = view.findViewById(R.id.ll_small);
            medium = view.findViewById(R.id.ll_medium);
            large = view.findViewById(R.id.ll_large);

            singlePrice = view.findViewById(R.id.single_price);
            smallPrice = view.findViewById(R.id.small_price);
            mediumPrice = view.findViewById(R.id.medium_price);
            largePrice = view.findViewById(R.id.large_price);

            edit = view.findViewById(R.id.edit);
            remove = view.findViewById(R.id.remove);
        }
    }

    @Override
    public DrinkRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drink, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (getPost(position).getSizeList().get(1).isEnable() && getPost(position).getSizeList().get(2).isEnable() && getPost(position).getSizeList().get(3).isEnable()) {
            holder.small.setVisibility(View.VISIBLE);
            holder.smallPrice.setText((getPost(position).getSizeList().get(1).getPrice()));
            holder.medium.setVisibility(View.VISIBLE);
            holder.mediumPrice.setText(getPost(position).getSizeList().get(2).getPrice());
            holder.large.setVisibility(View.VISIBLE);
            holder.largePrice.setText(getPost(position).getSizeList().get(3).getPrice());
        } else if (getPost(position).getSizeList().get(1).isEnable() && getPost(position).getSizeList().get(2).isEnable()) {
            holder.small.setVisibility(View.VISIBLE);
            holder.smallPrice.setText((getPost(position).getSizeList().get(1).getPrice()));
            holder.medium.setVisibility(View.VISIBLE);
            holder.mediumPrice.setText(getPost(position).getSizeList().get(2).getPrice());
        } else if (getPost(position).getSizeList().get(2).isEnable() && getPost(position).getSizeList().get(3).isEnable()) {
            holder.medium.setVisibility(View.VISIBLE);
            holder.mediumPrice.setText(getPost(position).getSizeList().get(2).getPrice());
            holder.large.setVisibility(View.VISIBLE);
            holder.largePrice.setText(getPost(position).getSizeList().get(3).getPrice());
        } else if (getPost(position).getSizeList().get(0).isEnable()) {
            holder.single.setVisibility(View.VISIBLE);
            holder.singlePrice.setText(getPost(position).getSizeList().get(0).getPrice());
        } else if (getPost(position).getSizeList().get(1).isEnable()) {
            holder.small.setVisibility(View.VISIBLE);
            holder.smallPrice.setText((getPost(position).getSizeList().get(1).getPrice()));
        } else if (getPost(position).getSizeList().get(2).isEnable()) {
            holder.medium.setVisibility(View.VISIBLE);
            holder.mediumPrice.setText(getPost(position).getSizeList().get(2).getPrice());
        } else if (getPost(position).getSizeList().get(3).isEnable()) {
            holder.large.setVisibility(View.VISIBLE);
            holder.largePrice.setText(getPost(position).getSizeList().get(3).getPrice());
        }

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListPost.remove(mListPost.get(position));
                PreferencesManager.getInstance().saveDrinkList(getList());
                notifyDataSetChanged();
            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListPost.remove(mListPost.get(position));
                PreferencesManager.getInstance().saveDrinkList(getList());
                notifyDataSetChanged();
            }
        });

        holder.name.setText(getPost(position).getName());
    }

    @Override
    public int getItemCount() {
        return mListPost.size();
    }

    private Drink getPost(int position) {
        return mListPost.get(position);
    }

    public ArrayList<Drink> getList() {
        return mListPost;
    }

    public void addAll(ArrayList<Drink> list) {
        if (list != null)
            mListPost.addAll(list);
        notifyDataSetChanged();
    }

    public void add(Drink drink) {
        mListPost.add(drink);
        notifyDataSetChanged();
    }

    public void clearAll() {
        mListPost.clear();
        notifyDataSetChanged();
    }
}