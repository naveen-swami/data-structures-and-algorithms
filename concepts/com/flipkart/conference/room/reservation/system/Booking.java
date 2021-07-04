package com.flipkart.conference.room.reservation.system;

import java.util.List;

public class Booking {

	private User user;
	private ConferenceRoom conferenceRoom;
	private List<BookingManager> bookingManagerList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ConferenceRoom getConferenceRoom() {
		return conferenceRoom;
	}

	public void setConferenceRoom(ConferenceRoom conferenceRoom) {
		this.conferenceRoom = conferenceRoom;
	}

	public List<BookingManager> getBookingManagerList() {
		return bookingManagerList;
	}

	public void setBookingManagerList(List<BookingManager> bookingManagerList) {
		this.bookingManagerList = bookingManagerList;
	}
}
