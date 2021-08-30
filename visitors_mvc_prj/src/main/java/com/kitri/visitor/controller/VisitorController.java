package com.kitri.visitor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.visitor.service.VisitorService;
import com.kitri.visitor.vo.VisitorVO;

@Controller
public class VisitorController {
	@Autowired
	private VisitorService vservice;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/session")
	public String session(String nickname,HttpSession session) {
		session.setAttribute("nickname", nickname);
		
		return "redirect:/visitor";
	}

	@RequestMapping("/visitor")
	public String visitor(Model model) {
		List<VisitorVO> vlist = vservice.searchVisitors();
		model.addAttribute("vlist",vlist);
		
		return "visitor";
	}
	
	@RequestMapping("/regist")
	public String regist(VisitorVO vvo) {
		int result = vservice.registVisitor(vvo);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/update")
	public String update(VisitorVO vvo) {
		int result = vservice.updateVisitor(vvo);
		return "redirect:/visitor";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("vno") int vno) {
//		RequestParam생략 가능
		int result = vservice.deleteVisitor(vno);
		return "redirect:/visitor";
	}
	
	@RequestMapping("/resbody")
	@ResponseBody // @ResponseBody는 VO객체와 List를 json으로 변환하여 return한다.
	public List<VisitorVO> resBody() throws IOException{
		List<VisitorVO> vlist = vservice.searchVisitors();
		return vlist;
	}
}
