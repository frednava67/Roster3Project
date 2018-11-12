package com.freddo.roster3project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freddo.roster3project.models.Course;
import com.freddo.roster3project.models.Student;
import com.freddo.roster3project.services.CourseService;

@Controller
public class CourseController {
	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping("/courses/new")
	public String newBook(@ModelAttribute("course") Course course) {
		return "/courses/newcourse.jsp";
	}

	@RequestMapping(value="/courses", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "courses/newcourse.jsp";
		} else {
			courseService.createCourse(course);
			return "redirect:/courses/new";
		}
	}
	
	@RequestMapping("/courses/{courseid}")
	public String showstudent( @PathVariable("courseid") Long id, Model model) {
		Course course = courseService.findCourse(id);
		model.addAttribute("course", course);
		
		List<Student> enrolledStudents = course.getStudents();
		model.addAttribute("enrolledStudents", enrolledStudents);		
		
		return "/courses/showcourse.jsp";
	}	
}