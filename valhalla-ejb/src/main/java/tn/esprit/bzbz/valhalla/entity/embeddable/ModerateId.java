package tn.esprit.bzbz.valhalla.entity.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ModerateId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer moderatorId;
	private Integer sectionId;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moderatorId == null) ? 0 : moderatorId.hashCode());
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		return result;
	}

	public ModerateId() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModerateId other = (ModerateId) obj;
		if (moderatorId == null) {
			if (other.moderatorId != null)
				return false;
		} else if (!moderatorId.equals(other.moderatorId))
			return false;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		return true;
	}

	public Integer getModeratorId() {
		return moderatorId;
	}

	public void setModeratorId(Integer moderatorId) {
		this.moderatorId = moderatorId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public ModerateId(Integer moderatorId, Integer sectionId) {
		super();
		this.moderatorId = moderatorId;
		this.sectionId = sectionId;
	}
	
	
}
