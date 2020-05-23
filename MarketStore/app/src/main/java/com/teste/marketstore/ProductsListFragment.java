package com.teste.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.teste.marketstore.databinding.FragmentProductsListBinding;

import java.util.ArrayList;
import java.util.List;


public class ProductsListFragment extends Fragment {

    public ProductsListFragment() {
        // Required empty public constructor
    }

    private FragmentProductsListBinding binding;
    private List<Product> productList;
    private ProductsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductsListBinding.inflate(inflater,container,false);
        View v = binding.getRoot();

        adapter = new ProductsAdapter(populateProducts(),getContext());

        binding.productsListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.productsListRecyclerView.setHasFixedSize(true);
        binding.productsListRecyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);
        return v;
    }

    private List<Product> populateProducts() {
        productList = new ArrayList<>();
        productList.add(new Product(1,3.50f,"Produto Um","Primeiro Produto muito bom", "Primeiro produto"));
        productList.add(new Product(2,5.30f,"Produto Dois","Segundo Produto muito bom", "Segundo produto"));
        productList.add(new Product(3,10.00f,"Produto Tres","Terceiro Produto muito bom", "Terceiro produto"));
        return productList;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.cart_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.buttonShowCart){

            List<String> strings = new ArrayList<>();

            for (Product p : productList){
                if (p.isChecked()){
                    strings.add(p.getProductName());
                }
            }
            String[] products = new String[strings.size()];
            for (int i = 0; i < products.length; i++){
                products[i] = strings.get(i);
            }

            NavDirections directions = ProductsListFragmentDirections.openCartFragment(products);
            if (getView() != null)
            Navigation.findNavController(getView()).navigate(directions);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }
}
