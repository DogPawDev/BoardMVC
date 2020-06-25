package spring.foodev.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.javassist.ClassPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.multipart.MultipartFile;


import spring.foodev.board.BoardVO;
import spring.foodev.board.dao.BoardDAO;

/**
 * Handles requests for the application home page.
 */

@CrossOrigin
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ServletContext sc;
	

	@Inject
	private BoardDAO dao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	logger.info("게시물 작성 ");

	BoardVO vv = new BoardVO();
	System.out.println(vv);
	BoardVO bb = vv;
	System.out.println(bb);
	bb.setPost_id(1);
	System.out.println(vv.getPost_id());
		
	
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
		
		
		BoardVO a= new BoardVO();
		a.setDivision("시청하기");
		a.setPost_id(1);
		a.setTitle("제목이다 쉭쉭버거");
		a.setWriter("test");
	//	a.setWrite_date("2020-06-09");
		a.setUp_count(1);
		a.setLookup_count(1);
		
		
		
		
		return "hi";
	}
	
	@RequestMapping(value = "/board/uploadSummernoteImageFile", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> createImgUrl(@RequestParam("file") MultipartFile multipartFile ,HttpServletRequest req) {
		
		
//		String saveFileRoot=req.getServletContext().getRealPath("resources/image/");
		//System.out.println(req.getSession().getServletContext().getRealPath(""));
		String saveFileRoot ="D:\\summernote_image\\";
	


		
		String loadOriginalFileName = multipartFile.getOriginalFilename();
		
		String extension = loadOriginalFileName.substring(loadOriginalFileName.lastIndexOf("."));
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		String saveFileName = UUID.randomUUID() + extension;
	
		File targetFile  = new File(saveFileRoot+saveFileName);
		
		
		System.out.println(targetFile);
		
		
		try {
 			InputStream fileStream = multipartFile.getInputStream();
		    FileUtils.copyInputStreamToFile(fileStream, targetFile);
			map.put("url", "http://127.0.0.1:8080/board/summernote/"+saveFileName);
		
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		
		System.out.println(multipartFile);
		System.out.println(loadOriginalFileName);
	//	map.put("url",saveFileName);
		
		return map;
	}
	

	@RequestMapping(value = "/board/3", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> bo2ardListReturn(String sz) {
	//	logger.info("게시판 전달");
		
		
		

		
		BoardVO a= new BoardVO();
		HashMap<String, Object> map = new HashMap<String, Object>();
		a.setDivision("시청하기");
		a.setPost_id(1);
		a.setTitle("제목이다 쉭쉭버거");
		a.setWriter("test");
		
		a.setUp_count(1);
		a.setLookup_count(1);
		
		map.put("boardList",a);
		
		return map;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> boardListReturn(BoardVO vo) {
	//	logger.info("게시판 전달");
		
		
		System.out.println(dao.getBoardList(vo));

		
	//	BoardVO a= new BoardVO();
		HashMap<String, Object> map = new HashMap<String, Object>();
		/*a.setDivision("시청하기");
		a.setPost_id(1);
		a.setTitle("제목이다 쉭쉭버거");
		a.setWriter("test");
		a.setWrite_date("2020-06-09");
		a.setUp_count(1);
		a.setLookup_count(1);*/
		
		map.put("boardList",dao.getBoardList(vo));
		
		return map;
	}
	
	
	@RequestMapping(value = "/enen", method = RequestMethod.GET)
	public ResponseEntity<byte[]> testestet(String vo) throws IOException {
	     HttpHeaders header = new HttpHeaders();
	        header.setContentType(MediaType.IMAGE_PNG);
	        
	        
	        ResponseEntity<byte[]> tesm= new ResponseEntity<byte[]>(IOUtils.toByteArray(new FileInputStream(new File("D:\\summernote_image\\90335f4d-b2d8-477c-b33b-c6b29df9bd18.png"))), header, HttpStatus.CREATED);
	  
	       
	       System.out.println(tesm.getHeaders()); 
	        return tesm;
	        
	        
	}


	
}
