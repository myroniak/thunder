package com.letzgro.thecoffeethunder.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.chootdev.recycleclick.RecycleClick;
import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.adapter.RecyclerAdapter;
import com.letzgro.thecoffeethunder.dialog.DialogBuilder;
import com.letzgro.thecoffeethunder.dialog.DialogBuilderDrink;
import com.letzgro.thecoffeethunder.model.Drink;
import com.letzgro.thecoffeethunder.util.PreferencesManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private TextView summary;
    private int k;
    private ArrayList<Drink> drinks;
    private TextView menuItems;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler);
        menuItems = findViewById(R.id.count);
        summary = findViewById(R.id.summary);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerAdapter = new RecyclerAdapter(this);

        mRecyclerView.setAdapter(mRecyclerAdapter);


        RecycleClick.addTo(mRecyclerView).setOnItemClickListener(new RecycleClick.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {

                new DialogBuilderDrink(MainActivity.this)
                        .setDrink(mRecyclerAdapter.getList().get(position))
                        .setSingleButton(new DialogBuilderDrink.OnClickListener() {
                            @Override
                            public void onClick(View view, AlertDialog dialog) {
                                k = k + Integer.valueOf(mRecyclerAdapter.getList().get(position).getSizeList().get(0).getPrice());
                                summary.setText(k + " ₴");
                                dialog.dismiss();
                            }
                        }).setSmallButton(new DialogBuilderDrink.OnClickListener() {
                    @Override
                    public void onClick(View view, AlertDialog dialog) {
                        k = k + Integer.valueOf(mRecyclerAdapter.getList().get(position).getSizeList().get(1).getPrice());
                        summary.setText(k + " ₴");
                        dialog.dismiss();
                    }
                }).setMediumButton(new DialogBuilderDrink.OnClickListener() {
                    @Override
                    public void onClick(View view, AlertDialog dialog) {
                        k = k + Integer.valueOf(mRecyclerAdapter.getList().get(position).getSizeList().get(2).getPrice());
                        summary.setText(k + " ₴");
                        dialog.dismiss();
                    }
                }).setLargeButton(new DialogBuilderDrink.OnClickListener() {
                    @Override
                    public void onClick(View view, AlertDialog dialog) {
                        k = k + Integer.valueOf(mRecyclerAdapter.getList().get(position).getSizeList().get(3).getPrice());
                        summary.setText(k + " ₴");
                        dialog.dismiss();
                    }
                }).create().show();


                drinks.add(mRecyclerAdapter.getList().get(position));
            }
        });

        summary.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                k = 0;
                summary.setText("0 ₴");
                return false;
            }
        });
       /* FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                String value = dataSnapshot.getValue(String.class);
                Log.d("sdfghjkl", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("sdfghjkl", "Failed to read value.", error.toException());
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //and this to handle actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mRecyclerAdapter != null && PreferencesManager.getInstance().getDrinkList() != null) {
            mRecyclerAdapter.updateList(PreferencesManager.getInstance().getDrinkList());
        }
    }
}
