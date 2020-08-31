package com.partnera.rezervationapp.Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.partnera.rezervationapp.Entities.Employee;
import com.partnera.rezervationapp.Entities.MeetingRoom;

@Repository
public class MeetingRoomRepository implements IMeetingRoomRepository{
	
	private EntityManager entityManager;
	
	@Autowired
	public MeetingRoomRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<MeetingRoom> getAllMeeting() {
		Session session=entityManager.unwrap(Session.class);
		List<MeetingRoom> meetingRooms =session.createQuery("from MeetingRoom", MeetingRoom.class).getResultList();
		return meetingRooms;
	}

	@Override
	public void addMeeting(MeetingRoom meeting) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(meeting);
		
	}

	@Override
	public void updateMeeting(MeetingRoom meeting) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(meeting);
		
	}

	@Override
	public void deleteMeeting(int id) {
		Session session=entityManager.unwrap(Session.class);
		MeetingRoom meetingRoom=session.get(MeetingRoom.class, id);
		session.delete(meetingRoom);
		
	}

	@Override
	public MeetingRoom getByIdMeeting(int id) {
		Session session=entityManager.unwrap(Session.class);
		MeetingRoom meetingRoom=session.get(MeetingRoom.class, id);
		return meetingRoom;
	}

	@Override
	public MeetingRoom getByNameMeeting(String name) {
		Session session=entityManager.unwrap(Session.class);
		MeetingRoom meetingRoom=session.get(MeetingRoom.class, name);
		return meetingRoom;
	}
	
	@Override
	public String getPositionEmployee(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee.getPozition();
	}

	@Override
	public Date getByMeetingDate(int id) {
		Session session=entityManager.unwrap(Session.class);
		MeetingRoom meetingRoom=session.get(MeetingRoom.class, id);
		return meetingRoom.getMeetingdate();
	}

	@Override
	public Date getByNameMeetingDate(String name) {
		Session session=entityManager.unwrap(Session.class);
		//MeetingRoom meetingRoom=session.get(MeetingRoom.class, name);
		//MeetingRoom meetingRoom=session.byNaturalId(MeetingRoom.class).using("name", name).load();
		Query query = session.createQuery("SELECT c FROM MeetingRoom c WHERE c.name = :pName ORDER BY c.meetingdate DESC")
				.setParameter("pName", name, StringType.INSTANCE)
				.setMaxResults(1);
		MeetingRoom meetingRoom=(MeetingRoom) query.uniqueResult();
		return meetingRoom.getMeetingdate();

		
	}

	@Override
	public List<MeetingRoom> getAllMeetingByName(String name) {
		Session session=entityManager.unwrap(Session.class);
		Query query = session.createQuery("SELECT c FROM MeetingRoom c WHERE c.name = :pName")
				.setParameter("pName", name, StringType.INSTANCE);
		List<MeetingRoom> meetingRooms=query.getResultList();
		return meetingRooms;
	}

	@Override
	public List<MeetingRoom> getAllMeetingByDate(String gtDate) {
		Session session=entityManager.unwrap(Session.class);
		Query query = session.createQuery("SELECT c FROM MeetingRoom c WHERE DATE_FORMAT(c.meetingdate, '%d-%m-%Y') = :pDate")
				.setParameter("pDate", gtDate, StringType.INSTANCE);
		List<MeetingRoom> meetingRooms=query.getResultList();
		return meetingRooms;
	}

}
