package com.example.restaurantapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.adapter.DishAdapter;
import com.example.restaurantapp.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DishAdapter.OnDishActionListener {

    private RecyclerView dishRecyclerView;
    private DishAdapter dishAdapter;
    private List<Dish> dishList;

    private Button addDishButton;
    private Button sortPriceButton;
    private Button filterPrimeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dishRecyclerView = findViewById(R.id.dishRecyclerView);
        addDishButton = findViewById(R.id.addDishButton);
        sortPriceButton = findViewById(R.id.sortPriceButton);
        filterPrimeButton = findViewById(R.id.filterPrimeButton);

        dishList = new ArrayList<>();
        loadSampleDishes();

        dishAdapter = new DishAdapter(this, dishList, this);
        dishRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dishRecyclerView.setAdapter(dishAdapter);

        addDishButton.setOnClickListener(v -> {
            // TODO: Implement add dish functionality
            Toast.makeText(this, "Add Dish clicked", Toast.LENGTH_SHORT).show();
        });

        sortPriceButton.setOnClickListener(v -> {
            sortDishesByPrice();
        });

        filterPrimeButton.setOnClickListener(v -> {
            filterDishesWithPrimePrice();
        });
    }

    private void loadSampleDishes() {
        dishList.add(new Dish(1, "Caesar Salad", "Appetizer", 5.99, "Fresh romaine lettuce with Caesar dressing", R.drawable.caesar_salad));
        dishList.add(new Dish(2, "Grilled Chicken", "Main Course", 12.49, "Juicy grilled chicken breast with herbs", R.drawable.grilled_chicken));
        dishList.add(new Dish(3, "Chocolate Cake", "Dessert", 6.99, "Rich chocolate layered cake", R.drawable.chocolate_cake));
        dishList.add(new Dish(4, "Tomato Soup", "Appetizer", 4.00, "Creamy tomato soup with basil", R.drawable.tomato_soup));
        dishList.add(new Dish(5, "Steak", "Main Course", 15.00, "Grilled ribeye steak with garlic butter", R.drawable.steak));
    }

    private void sortDishesByPrice() {
        Collections.sort(dishList, Comparator.comparingDouble(Dish::getPrice));
        dishAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Dishes sorted by price ascending", Toast.LENGTH_SHORT).show();
    }

    private void filterDishesWithPrimePrice() {
        List<Dish> filteredList = new ArrayList<>();
        for (Dish dish : dishList) {
            if (isPrime((int) Math.round(dish.getPrice()))) {
                filteredList.add(dish);
            }
        }
        dishAdapter = new DishAdapter(this, filteredList, this);
        dishRecyclerView.setAdapter(dishAdapter);
        Toast.makeText(this, "Filtered dishes with prime number prices", Toast.LENGTH_SHORT).show();
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public void onEdit(int position) {
        // TODO: Implement edit dish functionality
        Toast.makeText(this, "Edit dish at position " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDelete(int position) {
        dishList.remove(position);
        dishAdapter.notifyItemRemoved(position);
        Toast.makeText(this, "Dish deleted", Toast.LENGTH_SHORT).show();
    }
}
