package com.sangeetha.inventoryauthenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangeetha.inventoryauthenticationservice.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Long>{

}
