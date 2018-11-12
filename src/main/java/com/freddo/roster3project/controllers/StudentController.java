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
import org.springframework.web.bind.annotation.RequestParam;

import com.freddo.roster3project.models.Course;
import com.freddo.roster3project.models.Student;
import com.freddo.roster3project.services.CourseService;
import com.freddo.roster3project.services.StudentService;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;
    
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }
      
    @RequestMapping("/students/new")
    public String newBook(@ModelAttribute("student") Student Student) {
        return "/students/newstudent.jsp";
    }
    
    @RequestMapping(value="/students", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "students/newstudent.jsp";
        } else {
            studentService.createStudent(student);
            return "redirect:/students/new";
        }
    }
    
	@RequestMapping("/students/{studentid}")
	public String showstudent( @PathVariable("studentid") Long id, Model model) {
		Student student = studentService.findStudent(id);
		model.addAttribute("student", student);
		
		List<Course> chosenCourses = student.getCourses();
		model.addAttribute("chosenCourses", chosenCourses);		
		
		List<Course> unchosenCourses = studentService.allUnchosenCourses(student);
		model.addAttribute("unchosenCourses", unchosenCourses);
		
		return "/students/showstudent.jsp";
	}	
	
	@RequestMapping(value="/students/addCourse", method=RequestMethod.POST)
	public String addCourseToStudent(@RequestParam(value="studentid") Long studentid, @RequestParam(value="courseid") Long courseid) {
		Student student = studentService.findStudent(studentid);
		Course course = courseService.findCourse(courseid);

		List<Course> courses = student.getCourses();
				
		courses.add(course);
		student.setCourses(courses);
		studentService.updateStudent(student);
		
		return "redirect:/students/" + Long.toString(studentid);
	}	
	
	@RequestMapping(value="/students/dropCourse", method=RequestMethod.POST)
	public String dropCourseFromStudent(@RequestParam(value="studentid") Long studentid, @RequestParam(value="courseid") Long courseid) {
		Student student = studentService.findStudent(studentid);
		Course course = courseService.findCourse(courseid);

		List<Course> courses = student.getCourses();
				
		courses.remove(course);
		student.setCourses(courses);
		studentService.updateStudent(student);
		
		return "redirect:/students/" + Long.toString(studentid);
	}		
	
	
	
}
