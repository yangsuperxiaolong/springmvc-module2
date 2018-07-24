package com.hnust.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	/*方法1.使用HttpServletRequest对象*/
	@RequestMapping("/login.form")
    public String checkLogin(HttpServletRequest req){
		//接收请求参数
		String name=(String) req.getParameter("username");
		String pwd=(String) req.getParameter("password");
		//传出处理结果
		req.setAttribute("name", name);
		req.setAttribute("psw", pwd);
		
		//TODO Controller可以进行一系列的数据处理
        return "ok";
    }
	
	/*方法2.使用RequestParam*/
	@RequestMapping("/login1.form")
	public String checkLogin1(@RequestParam("username")String name,
							  @RequestParam("password")String password,
							  Model model){
		//将参数放入数据模型，默认是放入Request对象中
		model.addAttribute("name", name);
		model.addAttribute("psw",password);
		
		//TODO Controller可以进行一系列的数据处理
        return "ok";
    }
	
	/*方法3
	 * 适用于需要传递参数较多的情况
	 * 需要定义一个User POJO类
	 * 要求User类的变量名和传递的key名完全一致，由SpringMVC框架内实现参数传递
	 * */
	@RequestMapping("/login2.form")
	public ModelAndView checkLogin2(User user){
		
		ModelAndView mav = new ModelAndView();
		System.out.println("-----------------");
		mav.setViewName("ok");
		mav.getModel().put("name", user.getUsername());
	    mav.getModel().put("psw", user.getPassword());
		
		//TODO Controller可以进行一系列的数据处理
		return mav;
    }
}