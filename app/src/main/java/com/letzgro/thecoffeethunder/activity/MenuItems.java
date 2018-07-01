package com.letzgro.thecoffeethunder.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.adapter.MenuRecyclerAdapter;
import com.letzgro.thecoffeethunder.dialog.DialogBuilder;
import com.letzgro.thecoffeethunder.model.Drink;

public class MenuItems extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MenuRecyclerAdapter mRecyclerAdapter;
    private Button calculation;
    private int priceAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        mRecyclerView = findViewById(R.id.recycler);
        calculation = findViewById(R.id.calculation);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerAdapter = new MenuRecyclerAdapter(this);
        mRecyclerAdapter.updateList(MainActivity.drinks);
        mRecyclerView.setAdapter(mRecyclerAdapter);


        for (Drink drink : MainActivity.drinks) {
            priceAmount += drink.getPrice();
        }

        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                priceAmount = 0;
                for (Drink drink : MainActivity.drinks) {
                    priceAmount += drink.getPrice();
                }


                new DialogBuilder(MenuItems.this)
                        .setPrice(priceAmount)
                        .create().show();

            }
        });


    }
}