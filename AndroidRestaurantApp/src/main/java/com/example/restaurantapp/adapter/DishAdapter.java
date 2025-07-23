package com.example.restaurantapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.R;
import com.example.restaurantapp.model.Dish;

import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    public interface OnDishActionListener {
        void onEdit(int position);
        void onDelete(int position);
    }

    private Context context;
    private List<Dish> dishList;
    private OnDishActionListener listener;

    public DishAdapter(Context context, List<Dish> dishList, OnDishActionListener listener) {
        this.context = context;
        this.dishList = dishList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false);
        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        Dish dish = dishList.get(position);
        holder.dishName.setText(dish.getName());
        holder.dishType.setText(dish.getType());
        holder.dishPrice.setText(String.format("$%.2f", dish.getPrice()));
        holder.dishDescription.setText(dish.getDescription());
        holder.dishImage.setImageResource(dish.getImageResourceId());

        holder.editButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEdit(position);
            }
        });

        holder.deleteButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDelete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder {
        ImageView dishImage;
        TextView dishName, dishType, dishPrice, dishDescription;
        ImageButton editButton, deleteButton;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            dishImage = itemView.findViewById(R.id.dishImageView);
            dishName = itemView.findViewById(R.id.dishNameTextView);
            dishType = itemView.findViewById(R.id.dishTypeTextView);
            dishPrice = itemView.findViewById(R.id.dishPriceTextView);
            dishDescription = itemView.findViewById(R.id.dishDescriptionTextView);
            editButton = itemView.findViewById(R.id.editDishButton);
            deleteButton = itemView.findViewById(R.id.deleteDishButton);
        }
    }
}
