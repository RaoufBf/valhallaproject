package tn.esprit.bzbz.valhalla.entity.embeddable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class MessageId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private Integer userOneId;
	private Integer userTwoId;

	public MessageId(Integer userOneId, Integer userTwoId) {
		super();
		this.userOneId = userOneId;
		this.userTwoId = userTwoId;
		this.date = new Date();
	}

	public MessageId() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUserOneId() {
		return userOneId;
	}

	public void setUserOneId(Integer userOneId) {
		this.userOneId = userOneId;
	}

	public Integer getUserTwoId() {
		return userTwoId;
	}

	public void setUserTwoId(Integer userTwoId) {
		this.userTwoId = userTwoId;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
