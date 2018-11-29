package cn.mapper;

import java.util.HashMap;
import java.util.List;


public interface UserMapper {

	public List<HashMap<String,Object>> findProvince();
	//查询城市
	public List<HashMap<String,Object>> findCity(Integer pid);
	public List<HashMap<String,Object>>findArea(Integer cityId);
	
}
