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
		provinces.put(1, new Province(1, "����", Arrays.asList(new City(1, "�ϲ�"), new City(2, "�Ž�"), new City(3, "����"))));
		provinces.put(2, new Province(2, "�㶫", Arrays.asList(new City(1, "����"), new City(2, "����"), new City(3, "�麣"))));
		provinces.put(3, new Province(3, "�㽭", Arrays.asList(new City(1, "����"), new City(2, "����"), new City(3, "����"))));
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
