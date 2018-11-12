package com.freddo.roster3project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.freddo.roster3project.models.Course;
import com.freddo.roster3project.models.Student;
import com.freddo.roster3project.repos.CourseRepo;
import com.freddo.roster3project.repos.StudentRepo;

@Service
	public class StudentService {
	 // adding the student repository as a dependency
	private final StudentRepo studentRepo;
	private final CourseRepo courseRepo;

	
	public StudentService(StudentRepo studentRepo, CourseRepo courseRepo) {
		this.studentRepo = studentRepo;
		this.courseRepo = courseRepo;
	}
	// returns all the students
public List<Student> allStudents() {
    return studentRepo.findAll();
}
// creates a student
public Student createStudent(Student s) {
    return studentRepo.save(s);
}
//updates a student
public Student updateStudent(Student s) {
 return studentRepo.save(s);
}

// retrieves a student
	public Student findStudent(Long id) {
	    Optional<Student> optionalStudent = studentRepo.findById(id);
	    if(optionalStudent.isPresent()) {
	        return optionalStudent.get();
	    } else {
	        return null;
	    }
	}
	
	// returns all unchosen categories
	public List<Course> allUnchosenCourses(Student student) {		
		List<Course> unchosenCourses = courseRepo.findAll();
		
		List<Course> allCourses = courseRepo.findAll();
		
		if (student.getCourses().size()==0) {
			return allCourses;
		}
		
		unchosenCourses.removeAll(student.getCourses());
		return unchosenCourses;
	}
	
}