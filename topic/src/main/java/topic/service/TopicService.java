package topic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topic.model.Topic;
import topic.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> linkedWithThree() {
		return topicRepository.linkedWithThree();
	}
	
	public List<Topic> oneChildOneParent() {
		return topicRepository.oneChildOneParent();
	}

	public List<Topic> thirldLevel() {
		List<Topic> thirldLevel = topicRepository.thirldLevel();
		return thirldLevel;
	}
	
	/*
	 * Function called at app start to create h2 database with topics
	 */
	public void createTopics() {
		Topic link1 = new Topic();
		link1.setName("link1");
		topicRepository.save(link1);
		
		Topic link2 = new Topic();
		link2.setName("link2");
		topicRepository.save(link2);

		Topic link3 = new Topic();
		link3.setName("link3");
		topicRepository.save(link3);
		
		Topic four = new Topic();
		four.setName("four");
		four.getLinkedTo().add(link1);
		four.getLinkedTo().add(link2);
		four.getLinkedTo().add(link3);
		
		link1.getLinkedTo().add(four);
		link2.getLinkedTo().add(four);
		link3.getLinkedTo().add(four);
		four = topicRepository.save(four);
		topicRepository.save(link1);
		topicRepository.save(link2);
		topicRepository.save(link3);
		
		Topic five = new Topic();
		five.setName("five");
		five.setParent(four);
		topicRepository.save(five);

		Topic six = new Topic();
		six.setName("six");
		six.setParent(five);
		topicRepository.save(six);
		
	}
}
