package com.sangeetha.inventoryauthenticationservice.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@SequenceGenerator(name = "address_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue		(generator ="address_id_sequence",strategy = GenerationType.SEQUENCE)
	private Long addressId;
	@Column(length = 25)
	@Size(min = 3,max=25)
	@NotBlank
	private String city;
	@Column(length = 25)
	@Size(min = 3, max = 20)
	@NotBlank
	private String area;
	@Column(length = 25)
	@Size(min = 3, max = 20)
	@NotBlank
	private String state;
	@Size(min = 6, max = 6, message = "Must be 6 digits only")
	@Column(length = 6)
	@NotBlank
	private String pinCode;

}
