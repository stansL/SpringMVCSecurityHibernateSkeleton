package ke.co.greid.entities;

// Generated Apr 1, 2015 12:52:51 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Relationship generated by hbm2java
 */
@Entity
@Table(name = "relationship", catalog = "hims")
public class Relationship implements java.io.Serializable {

	private Integer relationshipId;
	private String relationshipName;
	private String relationshipDescription;
	private Set<NextOfKin> nextOfKins = new HashSet<NextOfKin>(0);

	public Relationship() {
	}

	public Relationship(String relationshipName,
			String relationshipDescription, Set<NextOfKin> nextOfKins) {
		this.relationshipName = relationshipName;
		this.relationshipDescription = relationshipDescription;
		this.nextOfKins = nextOfKins;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "relationship_id", unique = true, nullable = false)
	public Integer getRelationshipId() {
		return this.relationshipId;
	}

	public void setRelationshipId(Integer relationshipId) {
		this.relationshipId = relationshipId;
	}

	@Column(name = "relationship_name", length = 45)
	public String getRelationshipName() {
		return this.relationshipName;
	}

	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}

	@Column(name = "relationship_description", length = 45)
	public String getRelationshipDescription() {
		return this.relationshipDescription;
	}

	public void setRelationshipDescription(String relationshipDescription) {
		this.relationshipDescription = relationshipDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationship")
	public Set<NextOfKin> getNextOfKins() {
		return this.nextOfKins;
	}

	public void setNextOfKins(Set<NextOfKin> nextOfKins) {
		this.nextOfKins = nextOfKins;
	}

}
