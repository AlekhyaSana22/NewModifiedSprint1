package com.multiplex.entities;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="show")
public class Show {
	@Id
	@Column(name="showid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="hallId")
	private Hall hall;
	@JoinColumn(name="showTime")
	private LocalTime showTime;
	public Show() {
		super();
	}
	public Show(Integer showId, Hall hall, LocalTime showTime) {
		super();
		this.showId = showId;
		this.hall = hall;
		this.showTime = showTime;
	}
	public Integer getShowId() {
		return showId;
	}
	public Hall getHall() {
		return hall;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", hall=" + hall + ", showTime=" + showTime + "]";
	}
	
}

























//@Entity
//@Table(name="show")
//public class Show {
//	@Id
//	@Column(name="showid")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer showId;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hall_id")
//    private Hall hall;
//	@JoinColumn(name="show_time")
//	private LocalTime time;
//	
////	@ManyToOne(fetch = FetchType.LAZY)
//////	@JoinColumn(name = "movie_id")
////	private Movie movie;
//	
//	@OneToMany(mappedBy = "show")
//    private List<Booking> bookings;
//
//	public Show() {
//		super();
//	}
//
//	
//
//	public Show(Integer showId, Hall hall, LocalTime time, List<Booking> bookings) {
//		super();
//		this.showId = showId;
//		this.hall = hall;
//		this.time = time;
////		this.movie = movie;
//		this.bookings = bookings;
//	}
//
//
//
//	public Integer getShowId() {
//		return showId;
//	}
//
//
//
//	public Hall getHall() {
//		return hall;
//	}
//
//
//
//	public LocalTime getTime() {
//		return time;
//	}
//
//
//
////	public Movie getMovie() {
////		return movie;
////	}
//
//
//
//	public List<Booking> getBookings() {
//		return bookings;
//	}
//
//
//
//	public void setShowId(Integer showId) {
//		this.showId = showId;
//	}
//
//
//
//	public void setHall(Hall hall) {
//		this.hall = hall;
//	}
//
//
//
//	public void setTime(LocalTime time) {
//		this.time = time;
//	}
//
//
////
////	public void setMovie(Movie movie) {
////		this.movie = movie;
////	}
//
//
//
//	public void setBookings(List<Booking> bookings) {
//		this.bookings = bookings;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Show [showId=" + showId + ", hall=" + hall + ", time=" + time+ ", bookings="
//				+ bookings + "]";
//	}
//
//
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(bookings, hall, showId, time);
//	}
//
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Show other = (Show) obj;
//		return Objects.equals(bookings, other.bookings) && Objects.equals(hall, other.hall)
//				 && Objects.equals(showId, other.showId)
//				&& Objects.equals(time, other.time);
//	}
//	
//	
//
//
//	
//}
	