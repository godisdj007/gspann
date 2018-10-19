package topic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


@Entity
public class Topic {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    
    @ManyToOne
    private Topic parent;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "parent")
    private List<Topic> subTopics;
    
    @ManyToMany
    @JoinTable(name="links",
     joinColumns=@JoinColumn(name="linked_id"),
     inverseJoinColumns=@JoinColumn(name="linker_id")
    )
    private List<Topic> linker = new ArrayList();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="links",
     joinColumns=@JoinColumn(name="linker_id"),
     inverseJoinColumns=@JoinColumn(name="linked_id")
    )
    private List<Topic> linkedTo = new ArrayList();
    
    public Topic() {
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Topic getParent() {
		return parent;
	}
	public void setParent(Topic parent) {
		this.parent = parent;
	}
	public List<Topic> getLinkedTo() {
		return this.linkedTo;
	}
}
