package net.su.MVCstart.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.su.MVCstart.dao.HomeDAO;
import net.su.MVCstart.dao.ReDAO;
import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.ReVO;
import net.su.MVCstart.domain.searchVO;
import net.su.MVCstart.service.HomeService;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceimpl implements HomeService {
	
	@Resource
	private HomeDAO homeDAO;
	@Resource
	private ReDAO reDAO;
	
	public List<HomeVO> selectList(String sbx, String word,String pgnum)	// 검색 및 전체 리스트 메소드
	{
		System.out.println("=== svcimpl list ===");
		System.out.println("검색이 돌앗다 서비스 ㄴ리스트트트트");
		searchVO vo = new searchVO();
		int num = Integer.parseInt(pgnum);
		int first = ((num*20)-(20));
		int sec = (num*20);
		vo.setString(sbx);
		vo.setWord(word);
		vo.setFirst(first);
		vo.setSec(sec);
		List<HomeVO> va = null;
		if(word.equals("")){
			System.out.println("null");
			va = homeDAO.selectList(vo);
		}
		else if(sbx.equals("writer")) {
			System.out.println("wirter");
			va = homeDAO.selectList1(vo);
		}
		else if(sbx.equals("title")){
			va = homeDAO.selectList2(vo);
		}
		else if(sbx.equals("contents")) {
			va = homeDAO.selectList3(vo);
		}
		return va;
	}
}