package topic.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import topic.model.Topic;
import topic.service.TopicService;

@RestController
@RequestMapping(value={"/topic"})
public class TopicController {

	@Autowired
	TopicService topicService;
	
	/*
	 * Endpoint to get topics related with at least 3 topics
	 */
	@RequestMapping(value={"/linkedWithThree"})
	public List<Topic> linkedWithThree() {
		List<Topic> linkedWithThree = topicService.linkedWithThree();
		return linkedWithThree;
	}
	
	/*
	 * Endpoint to get topics with one child and one parent
	 */
	@RequestMapping(value={"/oneChildOneParent"})
	public List<Topic> oneChildOneParent() {
		List<Topic> oneChildOneParent = topicService.oneChildOneParent();
		return oneChildOneParent;
	}

	/*
	 * Endpoint to get topics at thirld level
	 */
	@RequestMapping(value={"/thirldLevel"})
	public List<Topic> thirldLevel() {
		List<Topic> thirldLevel = topicService.thirldLevel();
		return thirldLevel;
	}

}
