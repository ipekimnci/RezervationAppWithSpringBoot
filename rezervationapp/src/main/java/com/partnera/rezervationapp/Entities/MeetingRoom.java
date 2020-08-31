package com.partnera.rezervationapp.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="meetingroom")
public class MeetingRoom {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	//@NaturalId
	private String name;
	
	@Column(name="meetingdate")
	private Date meetingdate;
	
	@Column(name="participant")
	private String participant;
	
	@Column(name="employeeid")
	private int employeeid;

	public MeetingRoom(int id, String name, Date meetingdate, String participant, int employeeid) {
		super();
		this.id = id;
		this.name = name;
		this.meetingdate = meetingdate;
		this.participant = participant;
		this.employeeid = employeeid;
	}

	public MeetingRoom() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMeetingdate() {
		return meetingdate;
	}

	public void setMeetingdate(Date meetingdate) {
		this.meetingdate = meetingdate;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	@Override
	public String toString() {
		return "MeetingRoom [id=" + id + ", name=" + name + ", meetingdate=" + meetingdate + ", participant="
				+ participant + ", employeeid=" + employeeid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeid;
		result = prime * result + id;
		result = prime * result + ((meetingdate == null) ? 0 : meetingdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((participant == null) ? 0 : participant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingRoom other = (MeetingRoom) obj;
		if (employeeid != other.employeeid)
			return false;
		if (id != other.id)
			return false;
		if (meetingdate == null) {
			if (other.meetingdate != null)
				return false;
		} else if (!meetingdate.equals(other.meetingdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (participant == null) {
			if (other.participant != null)
				return false;
		} else if (!participant.equals(other.participant))
			return false;
		return true;
	}
	
	

	
	
	
	
	

}
