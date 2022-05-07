package com.offcn.dao;

import com.offcn.bean.City;
import com.offcn.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CityDaoImpl implements CityDao{

    @Override
    public List<City> selectCityByCountryId(int countryId) {
        List<City> list = null;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select id,name from city where country_id = ?";
        try {
         list =   qr.query(sql,new BeanListHandler<>(City.class),countryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
