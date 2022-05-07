package com.offcn.dao;

import com.offcn.bean.Country;

import java.util.List;

public interface CountryDao {
    List<Country> selectAllCountry();
}
