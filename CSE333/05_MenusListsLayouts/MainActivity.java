package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView foodList;

    String[] foodItems = {
        "Idli - ₹20",
        "Dosa - ₹30",
        "Poori - ₹30",
        "Veg Meals - ₹60",
        "Samosa - ₹15",
        "Tea - ₹10",
        "Coffee - ₹15"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        foodList = findViewById(R.id.foodList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                foodItems
        );

        foodList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        // if-else instead of switch: resource IDs are not compile-time constants in AGP 8+
        if (id == R.id.home) {
            setContentView(R.layout.activity_main);

            foodList = findViewById(R.id.foodList);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    foodItems
            );

            foodList.setAdapter(adapter);

        } else if (id == R.id.secondlayout) {
            setContentView(R.layout.secondlayout);

            Button backButton = findViewById(R.id.backButton);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.activity_main);

                    foodList = findViewById(R.id.foodList);

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            foodItems
                    );

                    foodList.setAdapter(adapter);
                }
            });

        } else if (id == R.id.exit) {
            finish();
        }

        return true;
    }
}
