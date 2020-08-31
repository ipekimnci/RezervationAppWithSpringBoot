package com.partnera.rezervationapp.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.partnera.rezervationapp.Entities.MeetingRoom;
import com.partnera.rezervationapp.Repository.IMeetingRoomRepository;
import com.partnera.rezervationapp.Repository.MeetingRoomRepository;

@ExtendWith(MockitoExtension.class)
class MeetingRoomServiceTest {
	
	@InjectMocks
	private IMeetingRoomService meetingRoomService;
	
	@Mock
	private IMeetingRoomRepository meetingRoomRepository;
	
	@Test
	void testAddMeeting() {
		MeetingRoom meetingRoom = new MeetingRoom();
		Date nowDate = new Date();
		meetingRoom.setName("blue room");
		meetingRoom.setMeetingdate(nowDate);
		meetingRoom.setParticipant("test_employee");
		meetingRoom.setEmployeeid(1);  //Ekip Lideri İd
		
		MeetingRoom meetingMock = Mockito.mock(MeetingRoom.class);
		//when(this.meetingRoomRepository.addMeeting(ArgumentMatchers.any(MeetingRoom.class))).then(meetingMock);
		
		MeetingRoom result = meetingRoomService.addMeeting(meetingRoom);
		assertEquals(result.getName(), meetingRoom.getName());
		
	}
	
	@Test
	void testGetByIdMeeting() {
		
		String name="blue room";
		
		int id=1;
		MeetingRoom meetingRoom = this.meetingRoomRepository.getByIdMeeting(id);
		assertEquals(meetingRoom.getName(), name);
	}
	
	@Test
	void testFindDifferenceHours() {
		fail("Not yet implemented");
	}

	@Test
	void testMeetingRoomService() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllMeeting() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMeeting() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteMeeting() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByNameMeeting() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByMeetingDate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByNameMeetingDate() {
		fail("Not yet implemented");
	}

	@Test
	void testFindDifferenceDays() {
		fail("Not yet implemented");
	}

	@Test
	void testFindDifferenceYears() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckWeekDays() {
		fail("Not yet implemented");
	}

	@Test
	void testConvertDateToDay() {
		fail("Not yet implemented");
	}

	@Test
	void testIsNowInInterval() {
		fail("Not yet implemented");
	}

	@Test
	void testIsHourInInterval() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCurrentHour() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllMeetingByName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllMeetingByDate() {
		fail("Not yet implemented");
	}

}
