package com.letzgro.thecoffeethunder.dialog;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.model.Drink;

public class DialogBuilderDrink {
    private String title;
    private String message;
    private String primaryButtonTitle;
    private String secondaryButtonTitle;
    private OnClickListener singleButtonListener, smallButtonListener, mediumButtonListener, largeButtonListener;
    private Activity context;
    private TextView priceSingle, priceSmall, priceMedium, priceLarge;
    private boolean showIcon;
    private boolean cancellable;
    private boolean single, small, medium, large;
    private Drink drink;
    AlertDialog dialog;

    public DialogBuilderDrink(Activity context) {
        this.context = context;
    }

    public DialogBuilderDrink setTitle(@StringRes int title) {
        this.title = context.getString(title);
        return this;
    }

    public DialogBuilderDrink setTitle(String title) {
        this.title = title;
        return this;
    }

    public DialogBuilderDrink setDrink(Drink drink) {
        this.drink = drink;
        return this;
    }

    public DialogBuilderDrink setMessage(@StringRes int message) {
        this.message = context.getString(message);
        return this;
    }

    public DialogBuilderDrink setMessage(String message) {
        this.message = message;
        return this;
    }

    public DialogBuilderDrink setShowIcon() {
        showIcon = true;
        return this;
    }

    public DialogBuilderDrink setSingleButton(OnClickListener listener) {
        // primaryButtonTitle = context.getString(title);
        singleButtonListener = listener;
        return this;
    }

    public DialogBuilderDrink setSmallButton(OnClickListener listener) {
        //secondaryButtonTitle = context.getString(title);
        smallButtonListener = listener;
        return this;
    }

    public DialogBuilderDrink setMediumButton(OnClickListener listener) {
        // secondaryButtonTitle = context.getString(title);
        mediumButtonListener = listener;
        return this;
    }

    public DialogBuilderDrink setLargeButton(OnClickListener listener) {
        //  secondaryButtonTitle = context.getString(title);
        largeButtonListener = listener;
        return this;
    }

    public DialogBuilderDrink setCancellable(boolean cancellable) {
        this.cancellable = cancellable;
        return this;
    }

    public AlertDialog create() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.item_size, null);
        RelativeLayout smallLayout = dialogView.findViewById(R.id.small);
        RelativeLayout mediumLayout = dialogView.findViewById(R.id.medium);
        RelativeLayout largeLayout = dialogView.findViewById(R.id.large);
        RelativeLayout singleLayout = dialogView.findViewById(R.id.single);
        priceSingle = dialogView.findViewById(R.id.price_single);
        priceSmall = dialogView.findViewById(R.id.price_s);
        priceMedium = dialogView.findViewById(R.id.price_m);
        priceLarge = dialogView.findViewById(R.id.price_l);

        priceSingle.setText( drink.getSizeList().get(0).getPrice());
        priceSmall.setText( drink.getSizeList().get(1).getPrice());
        priceMedium.setText( drink.getSizeList().get(2).getPrice());
        priceLarge.setText( drink.getSizeList().get(3).getPrice());

        single = drink.getSizeList().get(0).isEnable();
        small = drink.getSizeList().get(1).isEnable();
        medium = drink.getSizeList().get(2).isEnable();
        large = drink.getSizeList().get(3).isEnable();

        smallLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smallButtonListener.onClick(view, dialog);
            }
        });
        mediumLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediumButtonListener.onClick(view, dialog);
            }
        });
        largeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                largeButtonListener.onClick(view, dialog);
            }
        });
        singleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleButtonListener.onClick(view, dialog);
            }
        });


        if (small && medium && large) {
            smallLayout.setVisibility(View.VISIBLE);
            mediumLayout.setVisibility(View.VISIBLE);
            largeLayout.setVisibility(View.VISIBLE);
        } else if (small && medium) {
            smallLayout.setVisibility(View.VISIBLE);
            mediumLayout.setVisibility(View.VISIBLE);
        } else if (small && large) {
            smallLayout.setVisibility(View.VISIBLE);
            largeLayout.setVisibility(View.VISIBLE);
        } else if (medium && large) {
            mediumLayout.setVisibility(View.VISIBLE);
            largeLayout.setVisibility(View.VISIBLE);
        } else if (small) {
            smallLayout.setVisibility(View.VISIBLE);
        } else if (medium) {
            mediumLayout.setVisibility(View.VISIBLE);
        } else if (large) {
            largeLayout.setVisibility(View.VISIBLE);
        } else if (single) {
            singleLayout.setVisibility(View.VISIBLE);
        }


        builder.setView(dialogView);
        dialog = builder.create();

        //dialog.getWindow().setLayout(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        return dialog;
    }

    public interface OnClickListener {
        void onClick(View view, AlertDialog dialog);
    }
}