package tn.esprit.bzbz.valhalla.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.bzbz.valhalla.entity.embeddable.FollowId;

/**
 * Entity implementation class for Entity: Follow
 *
 */
@Entity

public class Follow implements Serializable {

	@EmbeddedId
	private FollowId followId;

	@ManyToOne
	@JoinColumn(name = "sectionId", referencedColumnName = "id", updatable = false, insertable = false)
	private Section section;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id", updatable = false, insertable = false)
	private User user;

	private Date date;

	public Follow(User user, Section section) {
		super();
		this.followId = new FollowId(user.getId(), section.getId());
		this.user = user;
		this.section = section;
		this.date = new Date();
	}

	private static final long serialVersionUID = 1L;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Follow() {
		super();
	}

	public FollowId getFollowId() {
		return followId;
	}

	public void setFollowId(FollowId followId) {
		this.followId = followId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
