package com.offcn.dao;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductDao {
    List<Product> selectProductByName(String productname);
}
