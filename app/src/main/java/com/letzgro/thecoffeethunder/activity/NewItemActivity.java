package com.letzgro.thecoffeethunder.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.model.Drink;
import com.letzgro.thecoffeethunder.model.Size;
import com.letzgro.thecoffeethunder.util.PreferencesManager;

import java.util.ArrayList;
import java.util.UUID;

public class NewItemActivity extends AppCompatActivity {

    private EditText name, singlePrice, smallPrice, mediumPrice, largePrice;
    private CheckBox cbSingle, cbSmall, cbMedium, cbLarge;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        name = findViewById(R.id.name);
        singlePrice = findViewById(R.id.et_single);
        smallPrice = findViewById(R.id.et_small);
        mediumPrice = findViewById(R.id.et_medium);
        largePrice = findViewById(R.id.et_large);
        addButton = findViewById(R.id.button_add);

        cbSingle = findViewById(R.id.cb_single);
        cbSmall = findViewById(R.id.cb_small);
        cbMedium = findViewById(R.id.cb_medium);
        cbLarge = findViewById(R.id.cb_large);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Size> arrayList = new ArrayList<>();
                arrayList.add(new Size(0, cbSingle.isChecked(), singlePrice.getText().toString()));
                arrayList.add(new Size(1, cbSmall.isChecked(), smallPrice.getText().toString()));
                arrayList.add(new Size(2, cbMedium.isChecked(), mediumPrice.getText().toString()));
                arrayList.add(new Size(3, cbLarge.isChecked(), largePrice.getText().toString()));


                ArrayList<Drink> arrayList1 = PreferencesManager.getInstance().getDrinkList();
                if (arrayList1 != null) {
                    arrayList1.add(new Drink(UUID.randomUUID().toString(), name.getText().toString(), arrayList));
                } else {
                    arrayList1 = new ArrayList<>();
                    arrayList1.add(new Drink(UUID.randomUUID().toString(), name.getText().toString(), arrayList));
                }

                PreferencesManager.getInstance().saveDrinkList(arrayList1);
                finish();
            }
        });

    }
}
