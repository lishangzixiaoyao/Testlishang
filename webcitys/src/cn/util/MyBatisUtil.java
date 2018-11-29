package cn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    public  static SqlSessionFactory factory;
    static {
        InputStream is;
        try {
            is= Resources.getResourceAsStream("mybatis-config.xml");
            factory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //1.定义一个字符串变量:mybatis-config.xml
           /* String resoure="mybatis-config.xml";
            //2.调用Resources类的getResourceAsStream()方法引入字符串，将值返回给InputStream类型的输入流is
            InputStream inputStream= Resources.getResourceAsStream(resoure);
            //3.实例化SqlSessionFactoryBuilder对象，并调用它的方法，从流里读取数据到sqlSessionFactory对象里
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            //4.调用sqlSessionFactory的openSession()方法。
            session = sqlSessionFactory.openSession();*/
        //5.调用UserMapper接口的count()方法.将返回值返回给count变量
    }
    public  static SqlSession createSqlSession(){
        return factory.openSession();
    }
    public static void closesSqlSession(SqlSession sqlSession)
    {
        if(null!=sqlSession)
        {
            sqlSession.close();
        }
    }
}
