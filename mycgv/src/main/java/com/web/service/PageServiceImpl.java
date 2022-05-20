package com.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class PageServiceImpl {
	
	@Autowired
	private NoticeServiceImpl noticeService;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	
	/**
	 * ����¡ ó�� 
	 */
	public Map<String,String> getPageResult(String rpage, String serviceName, ObjectService service) {
		Map<String,String> param = new HashMap<String,String>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 3;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;    //DB���� ������ ��ü ���
		
		if(serviceName.equals("member")) {
			memberService = (MemberServiceImpl)service;
			dbCount = memberService.getListCount();
		}else if(serviceName.equals("board")) {
			boardService = (BoardServiceImpl)service;
			dbCount = boardService.getListCount();
		}else {
			noticeService = (NoticeServiceImpl)service;
			dbCount = noticeService.getListCount();
		}
		
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("dbCount", String.valueOf(dbCount));
		param.put("pageSize", String.valueOf(pageSize));
		param.put("reqPage", String.valueOf(reqPage));
		
				
		return param;
	}
}









