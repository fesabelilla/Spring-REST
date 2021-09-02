package com.devrezaur.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.model.Student;
import com.devrezaur.main.repository.CourseRepository;
import com.devrezaur.main.repository.StudentRepository;

@RestController
public class MainController {
	
	@Autowired
	private StudentRepository studentRepository; 
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/")
	public String check() {
		return "Hello Zahid";
	}
	
	@GetMapping("/students/all")
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable("id") int id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping("/course/all")
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	@GetMapping("/course/{id}")
	public Optional<Course> getCourse(@PathVariable("id") int id) {
		return courseRepository.findById(id);
	}
	
	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PostMapping("/course/add")
	public Course addCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@PostMapping("/student/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/student/{id}/delete")
	public String deleteStudent(@PathVariable("id") int id) {
		try {
			studentRepository.deleteById(id);
			return "Successful";
		} catch (Exception e) {
			return "Failed";
		}
	}
	
	
}
