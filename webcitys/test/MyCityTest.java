import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mapper.UserMapper;
import cn.util.MyBatisUtil;


public class MyCityTest {
	@Test
	public void testFindPrince(){
		SqlSession sqlSession=null;
		sqlSession =MyBatisUtil.createSqlSession();
		List<HashMap<String,Object>> list=sqlSession.getMapper(UserMapper.class).findProvince();
		for(HashMap<String,Object> hashMap:list)
		{
			System.out.println(hashMap.keySet());
			for(Object s:hashMap.keySet())
				System.out.println(hashMap.get(s));
		}
	}

}
