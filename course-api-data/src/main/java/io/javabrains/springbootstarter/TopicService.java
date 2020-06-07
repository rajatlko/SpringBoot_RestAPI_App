package io.javabrains.springbootstarter;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topic=new ArrayList<>();
		topicRepository.findAll().forEach(topic::add);
		return topic;
	}
	public Topic getTopic(String id) {
		
		return topicRepository.findById(id).get();
	}
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
