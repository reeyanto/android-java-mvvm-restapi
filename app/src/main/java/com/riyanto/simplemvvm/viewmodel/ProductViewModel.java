package com.riyanto.simplemvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.riyanto.simplemvvm.model.Product;
import com.riyanto.simplemvvm.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private ProductRepository repository;
    private MutableLiveData<List<Product>> productLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>();

    public ProductViewModel() {
        repository = new ProductRepository();
        loadProducts();
    }

    public void loadProducts() {
        repository.fetchProduct(new ProductRepository.ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                productLiveData.setValue(products);
            }

            @Override
            public void onError(String message) {
                errorMessageLiveData.setValue(message);
            }
        });
    }

    public LiveData<List<Product>> getProducts() {
        return productLiveData;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessageLiveData;
    }
}
