package com.djh.michael.demo;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.codehaus.jackson.map.ObjectMapper;

import com.djh.michael.bean.Province;
import com.djh.michael.dao.ProvinceDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ProvinceAction extends ActionSupport implements RequestAware, ModelDriven<Province>, Preparable {

	private static final long serialVersionUID = 1L;
	ProvinceDAO pdo = new ProvinceDAO();
	private Map<String, Object> request;
	private Integer provinceId;

	private Province province;

	public String list() {
		request.put("provinces", pdo.getAllProvinces());
		return "list";
	}

	
	public String ajax() throws Exception {
		
		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		HttpServletResponse httpResponse = ServletActionContext.getResponse();
		
		String provinceId = httpRequest.getParameter("provinceId");
		
		httpResponse.setCharacterEncoding("utf-8");
		httpResponse.setContentType("text/html; charset=utf-8");
		PrintWriter out = httpResponse.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		String cities = mapper.writeValueAsString(pdo.getCitiesByProvince(Integer.parseInt(provinceId)));
		out.print(cities);
		
		out.flush();
		out.close();
		return NONE;
	}
	
	@Override
	public void setRequest(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.request = map;
	}

	@Override
	public Province getModel() {
		if (provinceId == null) {
			province = new Province();
		} else {
			province = pdo.getProvince(provinceId);
		}
		return province;
	}

	@Override
	public void prepare() throws Exception {
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
}
