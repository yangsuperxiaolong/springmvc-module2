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
	/*����1.ʹ��HttpServletRequest����*/
	@RequestMapping("/login.form")
    public String checkLogin(HttpServletRequest req){
		//�����������
		String name=(String) req.getParameter("username");
		String pwd=(String) req.getParameter("password");
		//����������
		req.setAttribute("name", name);
		req.setAttribute("psw", pwd);
		
		//TODO Controller���Խ���һϵ�е����ݴ���
        return "ok";
    }
	
	/*����2.ʹ��RequestParam*/
	@RequestMapping("/login1.form")
	public String checkLogin1(@RequestParam("username")String name,
							  @RequestParam("password")String password,
							  Model model){
		//��������������ģ�ͣ�Ĭ���Ƿ���Request������
		model.addAttribute("name", name);
		model.addAttribute("psw",password);
		
		//TODO Controller���Խ���һϵ�е����ݴ���
        return "ok";
    }
	
	/*����3
	 * ��������Ҫ���ݲ����϶�����
	 * ��Ҫ����һ��User POJO��
	 * Ҫ��User��ı������ʹ��ݵ�key����ȫһ�£���SpringMVC�����ʵ�ֲ�������
	 * */
	@RequestMapping("/login2.form")
	public ModelAndView checkLogin2(User user){
		
		ModelAndView mav = new ModelAndView();
		System.out.println("-----------------");
		mav.setViewName("ok");
		mav.getModel().put("name", user.getUsername());
	    mav.getModel().put("psw", user.getPassword());
		
		//TODO Controller���Խ���һϵ�е����ݴ���
		return mav;
    }
}