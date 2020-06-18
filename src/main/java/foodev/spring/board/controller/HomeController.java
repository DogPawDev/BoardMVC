package foodev.spring.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import foodev.spring.board.BoardVO;

/**
 * Handles requests for the application home page.
 */

@CrossOrigin
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	logger.info("게시물 작성 ");

		//System.out.println("dd");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/board/post", method = RequestMethod.POST)
	public @ResponseBody String boardPostInput(@RequestBody BoardVO vo ) {
	//	logger.info("게시물 작성 ");
//		System.out.println(vo.getTest());
		return "hi";
	}
	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> boardListReturn() {
	//	logger.info("게시판 전달");
		BoardVO a= new BoardVO();
		HashMap<String, Object> map = new HashMap<String, Object>();
		a.setDivision("시청하기");
		a.setPost_id(1);
		a.setTitle("제목이다 쉭쉭버거");
		a.setWriter("test");
		a.setDate("2020-06-09");
		a.setUp_count(1);
		a.setLookup_count(1);
		map.put("boardList",a);
		map.put("boardList2",a);
		return map;
	}
	
}
