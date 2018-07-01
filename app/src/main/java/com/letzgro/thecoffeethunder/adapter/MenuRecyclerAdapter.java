package com.letzgro.thecoffeethunder.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.activity.MainActivity;
import com.letzgro.thecoffeethunder.model.Drink;
import com.letzgro.thecoffeethunder.util.PreferencesManager;

import java.util.ArrayList;


public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Drink> mListPost = new ArrayList<>();

    public MenuRecyclerAdapter(Context context) {
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, size, price;
        private Button remove;

        private ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            size = view.findViewById(R.id.size);
            price = view.findViewById(R.id.price);
            remove = view.findViewById(R.id.remove);
        }
    }

    @Override
    public MenuRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.name.setText("" + getDrink(position).getName());
        holder.size.setText("" + getDrink(position).getSize());
        holder.price.setText("" + getDrink(position).getPrice());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.drinks.remove(mListPost.get(position));
                mListPost.remove(mListPost.get(position));
                notifyDataSetChanged();

                if (MainActivity.drinks != null && MainActivity.drinks.isEmpty()) {
                    ((Activity) context).finish();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListPost.size();
    }

    private Drink getDrink(int position) {
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

    public void updateList(ArrayList<Drink> list) {
        mListPost.clear();
        mListPost.addAll(list);
        notifyDataSetChanged();
    }
}