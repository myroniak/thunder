package com.letzgro.thecoffeethunder.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.activity.MainActivity;

public class DialogBuilder {
    private String title;
    private int totalPrice;
    private Dialog.OnClickListener primaryButtonListener;
    private Dialog.OnClickListener secondaryButtonListener;
    private Activity context;
    private boolean showIcon;
    private boolean cancellable;

    public DialogBuilder(Activity context) {
        this.context = context;
    }

    public DialogBuilder setTitle(@StringRes int title) {
        this.title = context.getString(title);
        return this;
    }

    public DialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DialogBuilder setPrice(int price) {
        this.totalPrice = price;
        return this;
    }

   /* public DialogBuilder setMessage(@StringRes int message) {
        this.message = context.getString(message);
        return this;
    }

    public DialogBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public DialogBuilder setShowIcon() {
        showIcon = true;
        return this;
    }

    public DialogBuilder setPrimaryButton(@StringRes int title, Dialog.OnClickListener listener) {
        primaryButtonTitle = context.getString(title);
        primaryButtonListener = listener;
        return this;
    }

    public DialogBuilder setSecondaryButton(@StringRes int title, Dialog.OnClickListener listener) {
        secondaryButtonTitle = context.getString(title);
        secondaryButtonListener = listener;
        return this;
    }*/

    public DialogBuilder setCancellable(boolean cancellable) {
        this.cancellable = cancellable;
        return this;
    }

    public AlertDialog create() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_calculation, null);
        builder.setView(dialogView);

        final TextView price = dialogView.findViewById(R.id.textView3);
        price.setText("" + totalPrice);

        final TextView surrender = dialogView.findViewById(R.id.surrender);

        EditText editText = dialogView.findViewById(R.id.editText2);
        Button button = dialogView.findViewById(R.id.close);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.finish();
                MainActivity.drinks.clear();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence != null && charSequence.length() != 0) {
                    int r = Integer.valueOf(charSequence.toString()) - totalPrice;
                    surrender.setText("" + r);
                } else if (charSequence != null) {
                    surrender.setText("" + 0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // get your custom views here and configure them based on given settings (field values of this class)

        final AlertDialog dialog = builder.create();
        return dialog;
    }
}