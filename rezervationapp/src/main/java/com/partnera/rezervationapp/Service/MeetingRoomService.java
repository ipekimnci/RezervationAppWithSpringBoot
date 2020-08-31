package com.partnera.rezervationapp.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.partnera.rezervationapp.Entities.MeetingRoom;
import com.partnera.rezervationapp.Repository.IMeetingRoomRepository;

@Service
public class MeetingRoomService implements IMeetingRoomService{
	
	private IMeetingRoomRepository meetingRoomRepository;
	
	@Autowired
	public MeetingRoomService(IMeetingRoomRepository meetingRoomRepository) {
		this.meetingRoomRepository = meetingRoomRepository;
	}

	@Override
	@Transactional
	public List<MeetingRoom> getAllMeeting() {
		return this.meetingRoomRepository.getAllMeeting();
	}

	@Override
	@Transactional
	public MeetingRoom addMeeting(MeetingRoom meeting) {
		String position=this.meetingRoomRepository.getPositionEmployee(meeting.getEmployeeid());
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat( "dd-MM-yyyy HH:mm");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat( "dd-MM-yyyy");
		String meetingName=meeting.getName().trim();
		Date lastMeetingDateByName=this.meetingRoomRepository.getByNameMeetingDate(meetingName);
		Date now = new Date();
		String strMeetingDate = dateFormat.format(lastMeetingDateByName);
		String strNow= dateFormat.format(now);
		String strMeetingDatee = dateFormat2.format(lastMeetingDateByName);
		String strAddingMeetingDate=dateFormat2.format(meeting.getMeetingdate());
		String strAddingMeetingDatee=dateFormat3.format(meeting.getMeetingdate());
		long differenceHours=findDifferenceHours(strMeetingDate,strNow);
		List<MeetingRoom> meetingRooms= this.meetingRoomRepository.getAllMeetingByName(meetingName);
		int meetingCount=meetingRooms.size();
		List<MeetingRoom> meetingRoomsByDate= this.meetingRoomRepository.getAllMeetingByDate(strAddingMeetingDatee);
		int meetingDateCount=meetingRoomsByDate.size();
		String day=convertDateToDay(strAddingMeetingDatee);
		Boolean checkDay=checkWeekDays(day);
		String getHour = getCurrentHour(meeting.getMeetingdate());
		String start = "08:00";
	    String end   = "17:00";
	    Boolean checkHour=isHourInInterval(getHour,start,end);
		if(!position.equals("Ekip Lideri")) {
			throw new IllegalArgumentException("Rezervasyonu sadece Ekip Lideri oluşturabilir.");
		}
		if(differenceHours>=2) {
			throw new IllegalArgumentException(meetingName+"İsimli toplantı odası için rezervasyon 2 saat önce yapıldı. Artık aktif değil. Katılımcı eklenemez.");
		}
		if(strMeetingDatee.equals(strAddingMeetingDate) && meetingCount>7) {
			throw new IllegalArgumentException("Aynı gün ve saatte aynı toplantıya en fazla 7 kişi katılabilir.");
		}
		if(meetingDateCount>3) {
			throw new IllegalArgumentException("Ekip Lideri gün içerisinde en fazla 3 toplantı oluşturabilir.");
		}
		if(!checkDay && !checkHour) {
			throw new IllegalArgumentException("Rezervasyon sadece hafta içi 08:00 ve 17:00 saatleri arasında oluşturabilir.");
		}
		this.meetingRoomRepository.addMeeting(meeting);
		return meeting;
		
	}

	@Override
	@Transactional
	public MeetingRoom updateMeeting(MeetingRoom meeting) {
		this.meetingRoomRepository.updateMeeting(meeting);
		return meeting;
	}

	@Override
	@Transactional
	public Boolean deleteMeeting(int id) {
		this.meetingRoomRepository.deleteMeeting(id);
		return true;
	}

	@Override
	@Transactional
	public MeetingRoom getByIdMeeting(int id) {
		return this.meetingRoomRepository.getByIdMeeting(id);
	}

	@Override
	@Transactional
	public MeetingRoom getByNameMeeting(String name) {
		return this.meetingRoomRepository.getByNameMeeting(name);
	}

	@Override
	@Transactional
	public Date getByMeetingDate(int id) {
		return this.meetingRoomRepository.getByMeetingDate(id);
	}

	@Override
	@Transactional
	public Date getByNameMeetingDate(String name) {
		return this.meetingRoomRepository.getByNameMeetingDate(name);
	}
	
	public long findDifferenceHours(String start_date, String end_date) {
		SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");

			Date d1 = null;
			try {
				d1 = sdf.parse(start_date);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
            Date d2 = null;
			try {
				d2 = sdf.parse(end_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            
            long difference_In_Time = d2.getTime() - d1.getTime();
            long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60))% 24;
            long differenceDays=findDifferenceDays(start_date, end_date)*24;
            long differenceYears=findDifferenceYears(start_date, end_date)*8766;
			return difference_In_Hours+differenceDays+differenceYears;
	}
	
	public long findDifferenceDays(String start_date, String end_date) {
		SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");

			Date d1 = null;
			try {
				d1 = sdf.parse(start_date);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
            Date d2 = null;
			try {
				d2 = sdf.parse(end_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            
            long difference_In_Time = d2.getTime() - d1.getTime();
            long difference_In_Days= (difference_In_Time / (1000 * 60 * 60 * 24)) % 365; 
			return difference_In_Days;
	}
	
	public long findDifferenceYears(String start_date, String end_date) {
		SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");

			Date d1 = null;
			try {
				d1 = sdf.parse(start_date);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
            Date d2 = null;
			try {
				d2 = sdf.parse(end_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            
            long difference_In_Time = d2.getTime() - d1.getTime();
            long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365)); 
			return difference_In_Years;
	}
	
	public Boolean checkWeekDays(String day) {
		if(day=="Monday"|| day=="Tuesday" || day=="Wednesday" ||day=="Thursday" || day=="Friday") {
		return true;}
		else {
			return false;
		}
	}
	
	public String convertDateToDay(String dateString) {
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		  String DayNo;
		  String Day = null;
		  Date date = null;
		  try {
		    date = simpleDateFormat.parse(dateString);
		  } catch (ParseException e) {
		    e.printStackTrace();
		  }
		  if (date == null)
		    return "";
		   DayNo=(String.valueOf(date.getDay()).length() == 1 ? "0" + date.getDay() : String.valueOf(date.getDay()));
		  switch (DayNo) {
		    case "00":
		    Day="Sunday";
		    break;
		    case "01":
		    Day="Monday";
		    break;
		    case "02":
		    Day="Tuesday";
		    break;
		    case "03":
		    Day="Wednesday";
		    break;
		    case "04":
		    Day="Thursday";
		    break;
		    case "05":
		    Day="Friday";
		    break;
		    case "06":
		    Day="Saturday";
		    break;
		    case "":
		    Day="";
		    break;
		  }
		  return Day;
		}
	
	public  boolean isNowInInterval(String start, String end,Date gtDate) {
	        return isHourInInterval(getCurrentHour(gtDate), start, end);
	}
	
    public  boolean isHourInInterval(String target, String start, String end) {
    		return ((target.compareTo(start) >= 0)
                && (target.compareTo(end) <= 0));
    }
	
	public  String getCurrentHour(Date gtdate) {
	        SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
	        String hour = sdfHour.format(gtdate.getTime());
	        return hour;
	}

	@Override
	@Transactional
	public List<MeetingRoom> getAllMeetingByName(String name) {
		return this.meetingRoomRepository.getAllMeetingByName(name);
	}

	@Override
	@Transactional
	public List<MeetingRoom> getAllMeetingByDate(String gtDate) {
		return this.meetingRoomRepository.getAllMeetingByDate(gtDate);
	}


}
