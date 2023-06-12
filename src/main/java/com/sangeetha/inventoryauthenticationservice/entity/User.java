package com.sangeetha.inventoryauthenticationservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
	
	@Id
	  @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 1)
	  @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
	  private Long userId;
	  
	  @Column(length = 20, unique = true)
	  private String username;
	  @Column(length = 60)
	  private String password;
	  @Column(length = 10)
	  private String role;
}
