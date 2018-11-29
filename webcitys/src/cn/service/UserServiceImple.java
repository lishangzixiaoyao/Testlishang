package cn.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.mapper.UserMapper;
import cn.util.MyBatisUtil;

public class UserServiceImple implements UserService {
	SqlSession sqlSession =null;
	public List<HashMap<String, Object>> findProvince() {
		// TODO Auto-generated method stub
		sqlSession=MyBatisUtil.createSqlSession();
		return sqlSession.getMapper(UserMapper.class).findProvince();
	}
	public List<HashMap<String, Object>> findCity(Integer pid) {
		// TODO Auto-generated method stub
		sqlSession=MyBatisUtil.createSqlSession();
		return sqlSession.getMapper(UserMapper.class).findCity(pid);
	}
	public List<HashMap<String, Object>> findArea(Integer cityId) {
		// TODO Auto-generated method stub
		sqlSession=MyBatisUtil.createSqlSession();
		return sqlSession.getMapper(UserMapper.class).findArea(cityId);
	}

}
