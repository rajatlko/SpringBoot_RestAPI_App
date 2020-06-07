package io.javabrains.springbootstarter.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.Topic;


	@RestController
	public class CourseController {
	
	@Autowired
	private CourseService courseService;
		

	@RequestMapping("/topic/{id}/course")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	} 
	
	@RequestMapping("/topic/{topicId}/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/course/")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/course/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/course/{id}")
	public void deleteTopic(@PathVariable String id) {
		 courseService.deleteCourse(id);
	}
	
	
	
}
