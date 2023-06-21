package com.sangeetha.inventoryauthenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sangeetha.inventoryauthenticationservice.entity.UserDetails;



//@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	Optional<UserDetails> findByUserUsername(String username);

}
