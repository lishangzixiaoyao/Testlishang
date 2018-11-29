package cn.service;

import java.util.HashMap;
import java.util.List;

public interface UserService {
	public List<HashMap<String,Object>> findProvince();
	public List<HashMap<String,Object>> findCity(Integer pid);
	public List<HashMap<String,Object>>findArea(Integer cityId);
}
