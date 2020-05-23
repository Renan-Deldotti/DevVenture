package com.teste.marketstore;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.teste.marketstore.databinding.FragmentProductBinding;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    private Product product;
    private FragmentProductBinding binding;

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getArguments() != null)
            product = ProductFragmentArgs.fromBundle(getArguments()).getProduct();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater,container,false);
        View v = binding.getRoot();

        if (product == null){
            return v;
        }

        binding.textViewFragProdProductName.setText(product.getProductName());
        String stringFormatted = String.format(Locale.getDefault(),"%.2f",product.getPrice());
        binding.textViewFragProdProductPrice.setText(stringFormatted);
        binding.textViewFragProdProductDescription.setText(product.getDescription());

        setHasOptionsMenu(false);
        return v;
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        MenuItem item = menu.findItem(R.id.buttonShowCart);
        if(item!=null)
            item.setVisible(false);
    }
}
