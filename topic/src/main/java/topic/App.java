package topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import topic.service.TopicService;

@SpringBootApplication
public class App 
{
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        context.getBean(TopicService.class).createTopics();
    }    
}
