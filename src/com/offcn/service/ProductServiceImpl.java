package com.offcn.service;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.ProductDaoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductDao pd = new ProductDaoImpl();
    @Override
    public List<Product> selectProductByName(String productname) {
        return pd.selectProductByName(productname);
    }
}
