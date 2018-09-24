package com.djh.michael.bean;

import java.util.List;

public class Province {

	private Integer provinceId;
	private String provinceName;
	private List<City> cities;

	public Province() {
		// TODO Auto-generated constructor stub
	}

	public Province(Integer provinceId, String provinceName, List<City> cities) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.cities = cities;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
