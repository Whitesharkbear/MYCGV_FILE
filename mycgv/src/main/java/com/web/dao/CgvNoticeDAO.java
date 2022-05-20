package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvNoticeVO;

public class CgvNoticeDAO implements CgvObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.notice";
	
	
	/**
	 * nsfile 
	 */
	@Override
	public String selectFile(String nid) {
		return sqlSession.selectOne(namespace+".nsfile", nid);
	}
	
	
	/**
	 * ����¡ ó�� - ��ü row ī��Ʈ
	 */
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");		
	}
	
	/**
	 * �������� ����
	 */
	@Override
	public int delete(String nid) {
		return sqlSession.delete(namespace+".delete", nid);		
	}
	
	/**
	 * �������� ������Ʈ
	 */
	@Override
	public int update(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return sqlSession.update(namespace +".update", vo);
	}
	
	/**
	 * �������� ��ȸ�� ������Ʈ
	 */
	@Override
	public void updateHits(String nid) {
		sqlSession.update(namespace+".updateHits", nid);		
	}
	
	/**
	 * �������� �� ����, ������Ʈ��
	 */
	@Override
	public Object select(String nid) {
		return sqlSession.selectOne(namespace+".content", nid); //CgvNoticeVO
		
	}
	
	
	/**
	 * �������� ��ü ����Ʈ - ����¡ó��
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);		
	}
	
	
	/**
	 * �������� ���
	 */
	@Override
	public int insert(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return sqlSession.insert(namespace + ".insert",vo);		
	}
	
}








