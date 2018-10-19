package topic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import topic.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer>{
	List<Topic> findById(int id);
	
	@Query("SELECT t.id,t.name FROM Topic t join t.linkedTo l "
			+ "group by t.id having count(t.id)>2")
	public List<Topic> linkedWithThree();
	
	@Query("SELECT t.id,t.name FROM Topic t where t.parent is not null "
			+ "and exists (select 1 from Topic t2 where t2.parent.id=t.id)")
	public List<Topic> oneChildOneParent();

	@Query("SELECT t1.id,t1.name FROM Topic t1, Topic t2,Topic t3 "
			+ "where t1.parent=t2 and t2.parent=t3 and t3.parent is null")
	public List<Topic> thirldLevel();
}
