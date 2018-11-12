package com.freddo.roster3project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.freddo.roster3project.models.Course;
import com.freddo.roster3project.repos.CourseRepo;

@Service
	public class CourseService {
	 // adding the course repository as a dependency
	private final CourseRepo courseRepo;
 
	public CourseService(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}
	// returns all the courses
public List<Course> allCourses() {
    return courseRepo.findAll();
}
// creates a course
public Course createCourse(Course c) {
    return courseRepo.save(c);
}
//updates a course
public Course updateCourse(Course c) {
 return courseRepo.save(c);
}


// retrieves a course
	public Course findCourse(Long id) {
	    Optional<Course> optionalCourse = courseRepo.findById(id);
	    if(optionalCourse.isPresent()) {
	        return optionalCourse.get();
	    } else {
	        return null;
	    }
	}
}
