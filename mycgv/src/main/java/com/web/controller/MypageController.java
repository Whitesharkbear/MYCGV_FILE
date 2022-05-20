package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.MemberServiceImpl;
import com.web.vo.CgvMemberVO;

@Controller
public class MypageController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	/**
	 * ȸ��Ż�� ��û
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/join_status.do", method=RequestMethod.GET)
	public String join_status(String id, String status) {
		int result = memberService.getStatusUpdate(id, status);
		
		return String.valueOf(result);
	}
	
	
	@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
	public ModelAndView mypage() {
		//test,1234 ��� �������� �׽�Ʈ
		/** test ��� ������ ������ �����ͼ� ������ּ��� **/
		
		ModelAndView mv = new ModelAndView();
		CgvMemberVO vo = (CgvMemberVO)memberService.getContent("hong");
		
		mv.addObject("vo", vo);
		mv.setViewName("/mypage/mypage");		
		
		return mv;
	}
}







