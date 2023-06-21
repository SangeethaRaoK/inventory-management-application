package com.sangeetha.inventoryauthenticationservice.entity;

import java.time.LocalDate;

import com.sangeetha.inventoryauthenticationservice.enums.GENDER;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class UserDetails {
	@Id
	private Long userDetailsId;
	@Column(length = 40)
	private String firstName;
	@Column(length = 40)
	private String lastName;
	@Column(length = 40)
	private String designation;
	@Enumerated(EnumType.STRING)
	private GENDER gender;
	private LocalDate dob;
	@Column(length = 50)
	private String emailId;
	@Column(length = 10)
	private String phoneNumber;
	@Column(length = 80)
	private String securityQuestion;
	@Column(length = 10)
	private String securityAnswer;
	@OneToOne
	@JoinColumn(name = "addressId", referencedColumnName = "addressId",foreignKey = @ForeignKey(name = "FK_ADDR_ID"))
	private Address address;
	@OneToOne
	@JoinColumn(name = "userDetailsId", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "FK_USER_ID"))
	@MapsId
	private User user;
	
	

}
