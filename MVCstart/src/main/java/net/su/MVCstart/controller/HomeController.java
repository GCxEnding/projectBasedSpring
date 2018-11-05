package net.su.MVCstart.controller;

import java.util.List;

import javax.annotation.Resource;

import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.ReVO;
import net.su.MVCstart.service.HomeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Resource
	private HomeService homeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private String search_box = null;
	private String word = null;
	
	@RequestMapping(value = "/")	// "/"의 의미는 인터넷 치는 주소와 같은 의미
	//method = RequestMethod.GET는 get방식을 의미함
	public String home(Model model, @ModelAttribute("search_box") String search_box, @ModelAttribute("word") String word, @ModelAttribute("pgnum") String pgnum)throws Exception{// 값을 SELECT하는 메소드
		System.out.println("===========controller list===========");
		List<HomeVO> all = homeService.selectall(search_box, word);
		int pgcount = 0;
		int tot = (int)Math.ceil(all.size());
		System.out.println(tot+": tot 글번호 위한 tot");
		if(pgnum.equals(""))
		{
			 pgnum =  "1";
		}
		pgcount = (int)Math.ceil(all.size()/(double)20);
		List<HomeVO> list = homeService.selectList(search_box, word, pgnum);
		model.addAttribute("list", list);				//list 뿌려주며 나중에 for문에서 반복함
		model.addAttribute("pgcount", pgcount);
		model.addAttribute("pgnum", pgnum);
		model.addAttribute("search_box",search_box);
		model.addAttribute("word",word);
		model.addAttribute("tot",tot);
		return "home";	//home.jsp로 이동하겠다
	}
}