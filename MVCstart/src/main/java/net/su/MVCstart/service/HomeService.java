package net.su.MVCstart.service;

import java.util.List;

import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.ReVO;


public interface HomeService {
	public List<HomeVO> selectList(String sbx, String word, String pgnum);
}