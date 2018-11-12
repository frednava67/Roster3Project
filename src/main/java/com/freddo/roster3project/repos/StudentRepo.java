package com.freddo.roster3project.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.freddo.roster3project.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{
	List<Student> findAll();
}
