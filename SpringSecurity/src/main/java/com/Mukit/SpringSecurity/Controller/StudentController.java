package com.Mukit.SpringSecurity.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mukit.SpringSecurity.Model.Student;

import jakarta.servlet.http.HttpServletRequest;
@RestController
public class StudentController {
	List<Student>st=new ArrayList<>(List.of(new Student(1,"Mukit","ICE"),
			new Student(2,"Muhsin","Architect"),
			new Student(3,"Moli","Doctor")));
	@GetMapping("/allStudent")
	public List<Student> getStudent(){
		return st;
	}
	@PostMapping("/allStudent")
	public void postStudent(@RequestBody Student stu){
		st.add(stu);
	}
	@GetMapping("/csrf")
	public CsrfToken getcsrf(HttpServletRequest request) {
	  return (CsrfToken)request.getAttribute("_csrf")  ;
	}

}
