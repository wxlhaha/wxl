package com.offcn.dao;

import com.offcn.bean.Country;
import com.offcn.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDao {
    @Override
    public List<Country> selectAllCountry() {
    List<Country> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from country";
        try {
           list =  qr.query(sql,new BeanListHandler<>(Country.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
