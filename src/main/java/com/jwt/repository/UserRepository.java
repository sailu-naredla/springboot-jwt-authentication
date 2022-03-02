package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwt.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

	@Query("SELECT u FROM UserEntity u WHERE u.name = :name")
	UserEntity findByName(@Param("name") String name);
}
