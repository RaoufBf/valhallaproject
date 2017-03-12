package tn.esprit.bzbz.valhalla.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.bzbz.valhalla.entity.embeddable.ReportSubjectId;

/**
 * Entity implementation class for Entity: ReportSubject
 *
 */
@Entity

public class ReportSubject implements Serializable {

	@EmbeddedId
	private ReportSubjectId reportSubjectId;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id", updatable = false, insertable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "subjectId", referencedColumnName = "id", updatable = false, insertable = false)
	private Subject subject;

	private Date date;

	private String reason;

	public ReportSubject(User user, Subject subject, String reason) {
		super();
		this.reportSubjectId = new ReportSubjectId(user.getId(), subject.getId());
		this.user = user;
		this.subject = subject;
		this.date = new Date();
		this.reason = reason;
	}

	public ReportSubjectId getReportSubjectId() {
		return reportSubjectId;
	}

	public void setReportSubjectId(ReportSubjectId reportSubjectId) {
		this.reportSubjectId = reportSubjectId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	private static final long serialVersionUID = 1L;

	public ReportSubject() {
		super();
	}

}
