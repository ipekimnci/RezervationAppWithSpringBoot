package com.partnera.rezervationapp.Repository;

import java.util.Date;
import java.util.List;

import com.partnera.rezervationapp.Entities.MeetingRoom;

public interface IMeetingRoomRepository {
	List<MeetingRoom> getAllMeeting();
	void addMeeting(MeetingRoom meeting);
	void updateMeeting(MeetingRoom meeting);
	void deleteMeeting(int id);
	MeetingRoom getByIdMeeting(int id);
	MeetingRoom getByNameMeeting(String name);
	String getPositionEmployee(int id);
	Date getByMeetingDate(int id);
	Date getByNameMeetingDate(String name);
	List<MeetingRoom> getAllMeetingByName(String name);
	List<MeetingRoom> getAllMeetingByDate(String gtDate);

}
