package com.letzgro.thecoffeethunder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.adapter.DrinkRecyclerAdapter;
import com.letzgro.thecoffeethunder.util.PreferencesManager;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

  //  private static final int REQUEST_NEW_ITEM = 100;
    private Button mNewItem;
    private RecyclerView mRecyclerView;
    private DrinkRecyclerAdapter mDrinkRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mNewItem = findViewById(R.id.add_item);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDrinkRecyclerAdapter = new DrinkRecyclerAdapter();
        mRecyclerView.setAdapter(mDrinkRecyclerAdapter);

        mNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, NewItemActivity.class);
                startActivity(intent);
              /*  new DialogBuilderNewItem(MenuActivity.this)
                        .getData(new DialogBuilderNewItem.OnDataListener() {
                            @Override
                            public void data(Drink drink) {
                                mDrinkRecyclerAdapter.add(drink);

                                Log.d("ghcvj", "gchvj: " + mDrinkRecyclerAdapter.getItemCount());
                                mDrinkRecyclerAdapter.notifyDataSetChanged();

                                // list = mDrinkRecyclerAdapter.getList();

                                PreferencesManager.getInstance().saveDrinkList(mDrinkRecyclerAdapter.getList());
                            }
                        })
                        .create().show();*/
            }
        });


    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQUEST_NEW_ITEM){

        }
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        if (PreferencesManager.getInstance().getDrinkList() != null)
            mDrinkRecyclerAdapter.clearAll();
            mDrinkRecyclerAdapter.addAll(PreferencesManager.getInstance().getDrinkList());
    }
}
