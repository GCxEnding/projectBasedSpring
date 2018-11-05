package net.su.MVCstart.dao;

 import java.util.List;

import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.searchVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDAO extends SqlSessionDaoSupport{	// DBconnection처럼 작동
	
	public List<HomeVO> selectList(searchVO vo){
		System.out.println("=== dao select list =====");
		return getSqlSession().selectList("mapper.selectList", vo);
	}
	public List<HomeVO> selectList1(searchVO vo){
		System.out.println("=== dao select111 list =====");
		return getSqlSession().selectList("mapper.selectList1", vo);
	}
	public List<HomeVO> selectList2(searchVO vo){
		System.out.println("=== dao select22222 list =====");
		return getSqlSession().selectList("mapper.selectList2", vo);
	}
	public List<HomeVO> selectList3(searchVO vo){
		System.out.println("=== dao select3333 list =====");
		return getSqlSession().selectList("mapper.selectList3", vo);
	}
}