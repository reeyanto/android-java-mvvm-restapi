package com.riyanto.simplemvvm.repository;

import com.riyanto.simplemvvm.model.Product;
import com.riyanto.simplemvvm.network.ApiService;
import com.riyanto.simplemvvm.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private ApiService apiService;

    public ProductRepository() {
        apiService = RetrofitClient.getRetrofit().create(ApiService.class);
    }

    public void fetchProduct(ProductCallback callback) {
        apiService.getProducts().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Gagal memuat data: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                callback.onError("Terjadi kesalahan jaringan: " + t.getMessage());
            }
        });
    }

    public interface ProductCallback {
        void onSuccess(List<Product> products);
        void onError(String message);
    }
}
