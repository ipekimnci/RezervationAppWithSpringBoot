package com.partnera.rezervationapp.Service;

import java.util.Date;
import java.util.List;

import com.partnera.rezervationapp.Entities.MeetingRoom;

public interface IMeetingRoomService {
	List<MeetingRoom> getAllMeeting();
	MeetingRoom addMeeting(MeetingRoom meeting);
	MeetingRoom updateMeeting(MeetingRoom meeting);
	Boolean deleteMeeting(int id);
	MeetingRoom getByIdMeeting(int id);
	MeetingRoom getByNameMeeting(String name);
	Date getByMeetingDate(int id);
	Date getByNameMeetingDate(String name);
	List<MeetingRoom> getAllMeetingByName(String name);
	List<MeetingRoom> getAllMeetingByDate(String gtDate);

}
