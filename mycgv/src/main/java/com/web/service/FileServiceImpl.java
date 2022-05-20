package com.web.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.web.vo.CgvBoardVO;
import com.web.vo.CgvNoticeVO;
import com.web.vo.CgvProductVO;

public class FileServiceImpl {
	/**
	 * ��Ƽ ���� ����
	 */
	public void multiFileSave(CgvProductVO vo, HttpServletRequest request) throws Exception{
		
		if(vo != null) {
			for(int i=0; i<vo.getFiles().length; i++) {
				CommonsMultipartFile pfile = vo.getFiles()[i]; //files �迭�� ����� �ּҹ����� ���Ϲ�ȯ
			
				if(!pfile.getOriginalFilename().equals("")) {
				
					//�������� ��ġ Ȯ��
					String root_path = request.getSession().getServletContext().getRealPath("/");
					root_path += "resources\\upload\\";
					System.out.println(root_path);
					
					//��������
					File file = new File(root_path + vo.getPsfiles().get(i));			
					pfile.transferTo(file);
				}
			}
		}	
	}
	
	/**
	 * ��Ƽ���� üũ
	 */
	public CgvProductVO multiFileCheck(CgvProductVO vo) {		
		
		if(vo != null) {
			for(int i=0; i<vo.getFiles().length; i++) {
				UUID uuid = UUID.randomUUID();		
				CommonsMultipartFile file = vo.getFiles()[i]; //files �迭�� ����� �ּҹ����� ���Ϲ�ȯ
				
				if(!file.getOriginalFilename().equals("")) { //�������� �ϴ� ���	
					vo.getPfiles().add(file.getOriginalFilename());
					vo.getPsfiles().add(uuid + "_" + file.getOriginalFilename());
				}else {
					vo.getPfiles().add("");
					vo.getPsfiles().add("");
				}
				System.out.println(vo.getPfiles().size());
			}
		}
				
				
		return vo;
	}
	
	
	/**
	 * ���� üũ �� bsfile ���� ---> VO ����
	 */
	public CgvBoardVO fileCheck(CgvBoardVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //�������� �ϴ� ���	
				vo.setBfile(vo.getFile1().getOriginalFilename());
				vo.setBsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	
	/**
	 * ���� üũ �� nsfile ���� ---> VO ����
	 */
	public CgvNoticeVO fileCheck(CgvNoticeVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //�������� �ϴ� ���	
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
		
	
	
	/**
	 * ���� ����
	 */
	public void fileSave(CgvBoardVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * ���� ���� - ���� ���� ����
	 */
	public void fileSave(CgvBoardVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
			
			//���� ������ �����ϴ� ��� ����ó��
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
			
	}
	
	/**
	 * ���� ����
	 */
	public void fileSave(CgvNoticeVO vo, HttpServletRequest request) throws Exception{
		if(!vo.getFile1().getOriginalFilename().equals("")) {			
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
		}
		
	}
	
	public void fileSave(CgvNoticeVO vo, HttpServletRequest request, String fname) throws Exception{
		if(!vo.getFile1().getOriginalFilename().equals("")) {			
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
			
			//���� ������ �����ϴ� ��� ����ó��
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
		
	}
}


















