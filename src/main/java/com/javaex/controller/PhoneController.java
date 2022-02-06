package com.javaex.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	
			//필드
			@Autowired
			private PhoneDao phoneDao;  //저장에놓았던거 필드에 올려놓고 쓰기 
			private PersonVo personVo;
		
			//생성자
			
			//메소드 gs
		
			//메소드 일반
			
			@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
			public String list(Model model) {
				System.out.println("PhoneController>list()");
				
				//다오에서 리스트를 가져온다
				//PhoneDao phoneDao = new PhoneDao();
				List<PersonVo> personList = phoneDao.getPersonList();
				System.out.println(personList.toString());
				
				//컨트롤러-->DS데이터를 보낸다 (model)
				model.addAttribute("personList", personList);
				
				//jsp정보를 리턴한다(view)
				return "list";
			}
			
			
			@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
			public String writeForm() {
				System.out.println("PhoneController>writeForm()");
				
				
				return "writeForm";
			}
			
			
			@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST} )
			public String write(@ModelAttribute PersonVo personVo) {
				System.out.println("PhoneController>write()");
				//System.out.println(personVo);
				
				//저장
				phoneDao.personInsert(personVo);
				
				//리다이렉트
				return "redirect:/phone/list";
			}
			
			
			@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST} )
			public String delete(@RequestParam("personId") int personId) {
				System.out.println("PhoneController>delete()");
				
				//삭제
				phoneDao.personDelete(personId);
				
				return "redirect:/phone/list";
			}
			
			@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST} )
			public String update(@ModelAttribute PersonVo personVo) {
				System.out.println("PhoneController>update()");
				
				phoneDao.personInsert(personVo);
				
				return "redirect:/phone/list";
			}
			
			@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
			public String updateForm(@RequestParam("personId") int personId, Model model) {
				System.out.println("PhoneController>updateForm()");
				
				personVo = phoneDao.getPerson(personId);
				
				model.addAttribute("personVo", personVo);
				
				return "updateForm";
			}
			
			
			/*
			@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST} )
			public String write(@RequestParam("name") String name, 
								@RequestParam("hp") String hp, 
								@RequestParam("company") String company) {
				System.out.println("PhoneController>write()");
				
				System.out.println(name);
				System.out.println(hp);
				System.out.println(company);
				
				//저장
				PersonVo personVo = new PersonVo(name, hp, company);
				
				PhoneDao phoneDao = new PhoneDao();
				phoneDao.personInsert(personVo);
				
				//리다이렉트
				
				return "";
			}
			*/
			
			
			/*
			@RequestMapping(value="/test", method = {RequestMethod.GET, RequestMethod.POST})
			public String test(@RequestParam(value="n") String name,
					           @RequestParam(value="age", required =false, defaultValue = "-1" ) int age ) {
				
					System.out.println(name);
					System.out.println(age);
				
				
				return "writeForm";
			}
			
			
			@RequestMapping(value="/view", method = {RequestMethod.GET, RequestMethod.POST})
			public String view(@RequestParam(value="no") int no)  {
					System.out.println("@RequestParam");
					System.out.println( no + "번글 가져오기");
				
				
				return "writeForm";
			}
			
			// localhost:8088/phonebook3/phone/aaa
			// localhost:8088/phonebook3/phone/bbb
			@RequestMapping(value="/{id}", method = {RequestMethod.GET, RequestMethod.POST})
			public String blog(@PathVariable(value="id") String id)  {
					System.out.println(id +"의 블로그입니다.");
				
				return "writeForm";
			}
			
			
			
			
			
			@RequestMapping(value="/{no}/{num}/view", method = {RequestMethod.GET, RequestMethod.POST})
			public String view11(@PathVariable("no") int no, @PathVariable("num") int num)  {
					System.out.println("@PathVariable");
					System.out.println(no +"번글 가져오기");
					System.out.println(num);
				
				
				return "writeForm";
			}
			*/
			
	

}