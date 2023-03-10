package com.multiplex.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@Column(name="movieid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer movieId;
private String movieName;
@DateTimeFormat
private LocalDate date;
@DateTimeFormat
private LocalTime duration;
public Movie() {
	super();

}
public Movie(Integer movieId, String movieName, LocalDate date, LocalTime duration) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.date = date;
	this.duration = duration;
}
public Integer getMovieId() {
	return movieId;
}
public void setMovieId(Integer movieId) {
	this.movieId = movieId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public LocalTime getDuration() {
	return duration;
}
public void setDuration(LocalTime duration) {
	this.duration = duration;
}
@Override
public String toString() {
	return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", date=" + date + ", duration=" + duration + "]";
}
@Override
public int hashCode() {
	return Objects.hash(date, movieId, movieName, duration);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Movie other = (Movie) obj;
	return Objects.equals(date, other.date) && movieId == other.movieId && Objects.equals(movieName, other.movieName)
			&& Objects.equals(duration, other.duration);
}

}




//@Entity
//@Table(name="movie")
//public class Movie {
//	@Id
//	@Column(name="movieid")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer movieId;
//	private String movieName;
//	@DateTimeFormat
//	private LocalDate date;
//	@DateTimeFormat
//	private LocalTime duration;
//	
//	@OneToMany(mappedBy = "movie")
//	private List<Booking> bookings;
//	
//	
//	@OneToMany(mappedBy = "movie")
//    private List<Show> shows;
//	
////	@ManyToMany
////	@JoinTable(name = "movie_hall",joinColumns = @JoinColumn(name = "movie_id"),
////	inverseJoinColumns = @JoinColumn(name = "hall_id"))
////	private List<Hall> halls;
//	
//	@ManyToMany(mappedBy = "movies")
//	private List<Hall> halls;
//	
//	public Movie() {
//	super();
//	}
//	
//	public Movie(Integer movieId, String movieName, LocalDate date, LocalTime duration, List<Booking> bookings,
//			List<Show> shows, List<Hall> halls) {
//		super();
//		this.movieId = movieId;
//		this.movieName = movieName;
//		this.date = date;
//		this.duration = duration;
//		this.bookings = bookings;
//		this.shows = shows;
//		this.halls = halls;
//	}
//
//	public Integer getMovieId() {
//		return movieId;
//	}
//
//	public String getMovieName() {
//		return movieName;
//	}
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//	public LocalTime getDuration() {
//		return duration;
//	}
//
//	public List<Booking> getBookings() {
//		return bookings;
//	}
//
//	public List<Show> getShows() {
//		return shows;
//	}
//
//	public List<Hall> getHalls() {
//		return halls;
//	}
//
//	public void setMovieId(Integer movieId) {
//		this.movieId = movieId;
//	}
//
//	public void setMovieName(String movieName) {
//		this.movieName = movieName;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//	public void setDuration(LocalTime duration) {
//		this.duration = duration;
//	}
//
//	public void setBookings(List<Booking> bookings) {
//		this.bookings = bookings;
//	}
//
//	public void setShows(List<Show> shows) {
//		this.shows = shows;
//	}
//
//	public void setHalls(List<Hall> halls) {
//		this.halls = halls;
//	}
//
//	@Override
//	public String toString() {
//		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", date=" + date + ", time=" + duration
//				+ ", bookings=" + bookings + ", shows=" + shows + ", halls=" + halls + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(bookings, date, halls, movieId, movieName, shows, duration);
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
//		Movie other = (Movie) obj;
//		return Objects.equals(bookings, other.bookings) && Objects.equals(date, other.date)
//				&& Objects.equals(halls, other.halls) && Objects.equals(movieId, other.movieId)
//				&& Objects.equals(movieName, other.movieName) && Objects.equals(shows, other.shows)
//				&& Objects.equals(duration, other.duration);
//	}
//	
//	
//}

