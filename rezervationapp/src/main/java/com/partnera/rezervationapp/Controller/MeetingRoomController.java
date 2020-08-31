package com.partnera.rezervationapp.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partnera.rezervationapp.Entities.MeetingRoom;
import com.partnera.rezervationapp.Service.IMeetingRoomService;

@RestController
@RequestMapping("/meeting")
public class MeetingRoomController {
	
	private IMeetingRoomService meetingRoomService;
    
	@Autowired
	public MeetingRoomController(IMeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}
	
	@GetMapping("/getMeeting")
	public ResponseEntity<List<MeetingRoom>> getMeetingAll(){
		List<MeetingRoom> meetingRooms=meetingRoomService.getAllMeeting();
		return new ResponseEntity<List<MeetingRoom>>(meetingRooms,HttpStatus.OK);
	}
	
	@GetMapping("/getMeeting/{id}")
	public ResponseEntity<MeetingRoom> getMeetingById(@PathVariable("id") int id){
		MeetingRoom meetingRooms=meetingRoomService.getByIdMeeting(id);
		return new ResponseEntity<MeetingRoom>(meetingRooms,HttpStatus.OK);
	}
	
	@GetMapping("/getMeetingDate/{id}")
	public ResponseEntity<Date> getEmployeePosition(@PathVariable("id") int id){
		return ResponseEntity.ok(meetingRoomService.getByMeetingDate(id)) ;	
	} 
	
	@PostMapping("/createMeeting")
	public ResponseEntity<MeetingRoom> createMeeting(@RequestBody MeetingRoom meeting){
		return ResponseEntity.ok(meetingRoomService.addMeeting(meeting));
	}
	
	@PutMapping("/updateMeeting")
	public ResponseEntity<MeetingRoom> updateMeeting(@RequestBody MeetingRoom meeting){
		return ResponseEntity.ok(meetingRoomService.updateMeeting(meeting));
	}
	
	@DeleteMapping("/deleteMeeting/{id}")
	public ResponseEntity<Boolean> deleteCity(@PathVariable("id") int id){
		return ResponseEntity.ok(meetingRoomService.deleteMeeting(id));
	}
	

}
