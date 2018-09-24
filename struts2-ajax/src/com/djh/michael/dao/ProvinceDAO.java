package com.djh.michael.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.djh.michael.bean.City;
import com.djh.michael.bean.Province;

public class ProvinceDAO {

	private static Map<Integer, Province> provinces = new HashMap<Integer, Province>();
	
	static{
		provinces.put(1, new Province(1, "江西", Arrays.asList(new City(1, "南昌"), new City(2, "九江"), new City(3, "吉安"))));
		provinces.put(2, new Province(2, "广东", Arrays.asList(new City(1, "广州"), new City(2, "深圳"), new City(3, "珠海"))));
		provinces.put(3, new Province(3, "浙江", Arrays.asList(new City(1, "杭州"), new City(2, "宁波"), new City(3, "温州"))));
	}
	
	public List<Province> getAllProvinces(){
		return new ArrayList<>(provinces.values());
	}
	
	public Province getProvince(Integer provinceId){
		return provinces.get(provinceId);
	}
	
	public List<City> getCitiesByProvince(Integer provinceId){
		return  provinces.get(provinceId) != null ?  provinces.get(provinceId).getCities() : null;
	}
}
