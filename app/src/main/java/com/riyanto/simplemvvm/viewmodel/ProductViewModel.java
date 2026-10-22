package com.riyanto.simplemvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.riyanto.simplemvvm.model.Product;
import com.riyanto.simplemvvm.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private ProductRepository repository;

    public ProductViewModel() {
        repository = new ProductRepository();
    }

    public LiveData<List<Product>> getProduct() {
        return repository.getProducts();
    }

    public LiveData<String> getErrorMessage() {
        return repository.getErrorMessage();
    }
}
