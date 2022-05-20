package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvBoardVO;

public class CgvBoardDAO implements CgvObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	/**
	 * bsfile
	 */
	@Override
	public String selectFile(String bid) {
		return sqlSession.selectOne(namespace+".bsfile", bid);		
	}
	
	/**
	 * ����¡ ó�� - ��ü row ī��Ʈ
	 */
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace + ".count");
		
	}
	
	
	
	/**
	 * �Խñ� ���� : delete(pk��) 
	 */
	@Override
	public int delete(String bid) {
		return sqlSession.delete(namespace+".delete", bid);	
	}
			
	
	/**
	 * �Խñ� ������Ʈ : update(pk��)
	 */
	@Override
	public int update(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;	
		return sqlSession.update(namespace+".update", vo);
	}
		
	
	/**
	 * ��ȸ�� ������Ʈ : updateHits(pk��)
	 */
	@Override
	public void updateHits(String bid) {
		sqlSession.update(namespace+".update_hits", bid);		
	}
	
	/**
	 * �Խñ� �� ���� : select(pk��)
	 */
	@Override
	public Object select(String bid) {
		return sqlSession.selectOne(namespace+".content", bid);	//CgvBoardVO	
	}
	
	
	/**
	 * �Խñ� ��ü ����Ʈ : select(int startCount, int endCount)
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map param = new HashMap<String,String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list",param);	
	}	
	
	
	/**
	 * �Խñ� ��� : insert
	 */
	@Override
	public int insert(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;
		return sqlSession.insert(namespace+".insert", vo);		
	}
	
}




