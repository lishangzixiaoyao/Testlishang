package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.service.UserService;
import cn.service.UserServiceImple;

public class UserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action =request.getParameter("action");
		UserService service=new UserServiceImple();
		if(action.equals("action"))
		{
			List<HashMap<String,Object>>list=service.findProvince();
			request.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(action.endsWith("city"))
		{
			Integer pid=Integer.parseInt(request.getParameter("opid"));
			System.out.println(pid);
			List<HashMap<String,Object>> maps=service.findCity(pid);
			String stu= JSON.toJSONString(maps,
		            SerializerFeature.WriteMapNullValue,
		            SerializerFeature.WriteNullNumberAsZero,
		            SerializerFeature.WriteNullStringAsEmpty);
			response.getWriter().print(stu);
		}else if(action.equals("area"))
		{
			Integer cityId=Integer.parseInt(request.getParameter("cityid"));
			List<HashMap<String,Object>> map=service.findArea(cityId);
			String stu= JSON.toJSONString(map,
		            SerializerFeature.WriteMapNullValue,
		            SerializerFeature.WriteNullNumberAsZero,
		            SerializerFeature.WriteNullStringAsEmpty);
			response.getWriter().print(stu);
		}

	
	}

}
