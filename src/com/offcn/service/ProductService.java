package com.offcn.service;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectProductByName(String productname);
}
