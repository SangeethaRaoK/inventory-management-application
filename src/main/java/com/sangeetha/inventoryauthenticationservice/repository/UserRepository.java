package com.sangeetha.inventoryauthenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sangeetha.inventoryauthenticationservice.entity.User;
import com.sangeetha.inventoryauthenticationservice.entity.UserDetails;

//@Repository
public interface UserRepository extends JpaRepository<User	, Long>{
	
	Optional<User> findByUsername(String userName);
	boolean existsByUsername(String userName);

}
