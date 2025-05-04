package com.example.constraintpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnOrder = findViewById(R.id.btnOrder);
        TextView tvPrice = findViewById(R.id.tvPrice);
        TextView tvItems = findViewById(R.id.tvItems);
        RadioGroup radioGroupSize = findViewById(R.id.radioGroupSize);
        CheckBox chkPepperoni = findViewById(R.id.chkPepperoni);
        CheckBox chkMushrooms = findViewById(R.id.chkMushrooms);
        CheckBox chkPineapple = findViewById(R.id.chkPineapple);
        SwitchMaterial switchDelivery = findViewById(R.id.switchDelivery);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalPrice = 0;
                String pizzaSize = "";
                String toppings = "";

                if(radioGroupSize.getCheckedRadioButtonId() == R.id.small){
                    totalPrice = 10;
                    pizzaSize = "Small pizza ";
                } else if (radioGroupSize.getCheckedRadioButtonId() == R.id.medium) {
                    totalPrice = 15;
                    pizzaSize = "Medium pizza ";
                } else if (radioGroupSize.getCheckedRadioButtonId() == R.id.large) {
                    totalPrice = 20;
                    pizzaSize = "Large pizza ";
                }

                if(chkPepperoni.isChecked()){
                    totalPrice += 3;
                    toppings += "pepperoni\n";
                }

                if(chkMushrooms.isChecked()){
                    totalPrice += 3;
                    toppings += "mushrooms\n";
                }

                if(chkPineapple.isChecked()){
                    totalPrice += 5;
                    toppings += "pineapple\n";
                }
                if (switchDelivery.isChecked()) {
                    totalPrice += 5;
                    toppings += "delivery to home address";
                }

                tvPrice.setText("Total Price: $" + totalPrice);
                tvItems.setText("Order Summary:\n" + pizzaSize + "\n" + toppings.toString());
            }
        });
    }
}