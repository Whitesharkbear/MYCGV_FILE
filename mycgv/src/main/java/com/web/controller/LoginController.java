package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.MemberServiceImpl;
import com.web.vo.CgvMemberVO;

@Controller
public class LoginController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	/**
	 * �α׾ƿ�
	 */
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		String sid = (String)session.getAttribute("sid");
		
		if(sid != null) {	
			session.invalidate();
			mv.addObject("sid",sid);
			mv.addObject("logout_result","succ");
		}		
		mv.setViewName("/index");
		
		return mv;
	}
	
	/**
	 * �α��� ó��
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(CgvMemberVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		int result = memberService.getLoginResult(vo);
		
		if(result == 1) {	
			session.setAttribute("sid",vo.getId());
			mv.addObject("login_result", "succ");
			mv.setViewName("index");
		}else {
			mv.addObject("login_result", "fail");
			mv.setViewName("/login/login");
		}		
		
		return mv;
	}
	
	
	/**
	 * �α��� ȭ��
	 */
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.GET) public String
	 * login() { return "/login/login"; }
	 */
	
	/**
	 * �α��� ȭ��
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView login(String auth_result) {
		ModelAndView mv = new ModelAndView("/login/login");
		mv.addObject("auth_result",auth_result);
		
		return mv;
	}
	

}













