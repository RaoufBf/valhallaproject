package tn.esprit.bzbz.valhalla.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.bzbz.valhalla.entity.embeddable.ModerateId;

/**
 * Entity implementation class for Entity: Moderate
 *
 */
@Entity

public class Moderate implements Serializable {

	@EmbeddedId
	private ModerateId moderateId;

	@ManyToOne
	@JoinColumn(name = "moderatorId", referencedColumnName = "id", updatable = false, insertable = false)
	private User moderator;

	@ManyToOne
	@JoinColumn(name = "sectionId", referencedColumnName = "id", updatable = false, insertable = false)
	private Section section;

	public Moderate(User moderator, Section section) {
		super();
		this.moderateId = new ModerateId(moderator.getId(), section.getId());
		this.moderator = moderator;
		this.section = section;
	}

	public ModerateId getModerateId() {
		return moderateId;
	}

	public void setModerateId(ModerateId moderateId) {
		this.moderateId = moderateId;
	}

	public User getModerator() {
		return moderator;
	}

	public void setModerator(User moderator) {
		this.moderator = moderator;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	private static final long serialVersionUID = 1L;

	public Moderate() {
		super();
	}

}
