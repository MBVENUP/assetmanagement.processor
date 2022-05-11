package com.sprint1.assetmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.assetmanagementsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u.userPassword from User u where userId=:id")
	public String getPassword(@Param("id") int id);

	@Query("select u.role from User u where userId=:id")
	public String getRole(@Param("id") int id);

	@Modifying
	@Query(value = "update user_table set role=:role where userId=:id", nativeQuery = true)
	@Transactional
	public void updateUser(@Param("id") int id, @Param("role") String role);

}
