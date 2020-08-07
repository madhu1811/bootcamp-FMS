package com.capg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.fms.dto.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, String>
{
	@Query(" FROM Login where username=:madhu and password=:bvrit")
	public Login findUser(@Param("madhu") String username,@Param("bvrit") String password);
}