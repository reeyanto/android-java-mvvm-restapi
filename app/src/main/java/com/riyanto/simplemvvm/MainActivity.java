package com.riyanto.simplemvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.riyanto.simplemvvm.model.Product;
import com.riyanto.simplemvvm.viewmodel.ProductViewModel;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProducts().observe(this, products -> {
            if (products != null) {
                for(Product product: products) {
                    Log.d(TAG, "Product Name: "+ product.name());
                }
            }
        });

        productViewModel.getErrorMessage().observe(this, errorMessage -> {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        });
    }
}