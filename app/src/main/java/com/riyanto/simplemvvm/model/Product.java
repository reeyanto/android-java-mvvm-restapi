package com.riyanto.simplemvvm.model;

public record Product(int id, String name, String description, double price, String image_url, Category category) {}
