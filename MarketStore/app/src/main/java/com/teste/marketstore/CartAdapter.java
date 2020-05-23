package com.teste.marketstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartAdapterViewHolder> {

    private String[] productList;

    CartAdapter(String[] productList){
        this.productList = productList;
    }

    @NonNull
    @Override
    public CartAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_cart_product,parent,false);
        return new CartAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapterViewHolder holder, int position) {
        holder.productName.setText(productList[position]);
    }

    @Override
    public int getItemCount() {
        return productList.length;
    }

    class CartAdapterViewHolder extends RecyclerView.ViewHolder{

        private TextView productName;

        public CartAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_inCartName);
        }
    }
}
