package com.teste.marketstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.marketstore.databinding.SingleProductItemBinding;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {


    private List<Product> productList;
    private Context ownerContext;

    static int[] selectedIds;

    ProductsAdapter(List<Product> productList, Context ownerContext){
        this.productList = productList;
        this.ownerContext = ownerContext;
        selectedIds = new int[productList.size()];
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product_item,parent,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Product thisProduct = productList.get(position);
        holder.textViewProductName.setText(thisProduct.getProductName());
        holder.textViewShortDescription.setText(thisProduct.getShortDescription());
        holder.checkBoxProductSelected.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ProductsViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewProductName, textViewShortDescription;
        private CheckBox checkBoxProductSelected;

        public ProductsViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.textView_productName);
            textViewShortDescription = itemView.findViewById(R.id.textView_shortDescription);
            checkBoxProductSelected = itemView.findViewById(R.id.checkBox_selectProduct);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections directions = ProductsListFragmentDirections.openProductFragment(productList.get(getAdapterPosition()));
                    Navigation.findNavController(v).navigate(directions);
                }
            });

            checkBoxProductSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        productList.get(getAdapterPosition()).setChecked(true);
                    }else {
                        productList.get(getAdapterPosition()).setChecked(false);
                    }
                }
            });
        }
    }
}
