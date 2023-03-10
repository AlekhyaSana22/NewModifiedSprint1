package com.multiplex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.multiplex.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUserNameAndPassword(String userName, String password);
    
//    @Query("select u from User u where u.userName=:userName")
//    public List<User> findUserByName(@Param(value="userName")String userName);
    
    @Query("select u from User u where u.emailId=:emailId")
    public List<User> findByEmailId(@Param(value="emailId")String emailId);
    
    @Query("select u from User u where u.emailId=:emailId and u.password=:password")
    public User findByEmailIdAndPassword(@Param(value="emailId")String emailId, @Param(value="password")String password);


	User findByUserName(String userName);
}




























//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.multiplex.entities.User;
//@Repository
//public interface UserRepository extends JpaRepository<User, Integer>{
//	User findByUserNameAndPassword(String userName, String password);
//	
//	@Query("select u from User u where u.userName=:userName")
//	public List<User> findUserByName(@Param(value="userName")String userName);
//	@Query("select u from User u where u.emailId=:emailId")
//	public List<User> findByEmailId(@Param(value="emailId")String userName);
//	@Query("Select u from User u where u.emailId=:email_id and u.password=:password")
//
//	public User findByUserName(String username);
//	
//
//}
