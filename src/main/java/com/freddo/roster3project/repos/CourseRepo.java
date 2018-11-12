package com.freddo.roster3project.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.freddo.roster3project.models.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{
	List<Course> findAll();
}
