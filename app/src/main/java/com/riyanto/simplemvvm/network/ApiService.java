package com.riyanto.simplemvvm.network;

import com.riyanto.simplemvvm.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("products")
    Call<List<Product>> getProducts();
}
