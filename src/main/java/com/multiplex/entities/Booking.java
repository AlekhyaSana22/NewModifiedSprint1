package com.multiplex.entities;

import java.time.LocalDate;


import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@Column(name="bookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer bookingId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private Hall hall;
	
	private LocalDate date;
	private LocalTime time;

	public Booking() {
		super();
	}

	public Booking(Integer bookingId, User user, Show show, Hall hall, LocalDate date, LocalTime time) {
		super();
		this.bookingId = bookingId;
		this.user = user;

		this.show = show;
		this.hall = hall;
		this.date = date;
		this.time = time;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", show=" + show + ", hall="
				+ hall + ", date=" + date + ", time=" + time + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(bookingId, date, hall, movie, show, time, user);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Booking other = (Booking) obj;
//		return Objects.equals(bookingId, other.bookingId) && Objects.equals(date, other.date)
//				&& Objects.equals(hall, other.hall) && Objects.equals(movie, other.movie)
//				&& Objects.equals(show, other.show) && Objects.equals(time, other.time)
//				&& Objects.equals(user, other.user);
//	}
	
	
	
}