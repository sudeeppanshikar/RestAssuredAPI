package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactsAPIAddContact {
	
	private  String firstName;
	private  String lastName;
	private  String birthdate;
	private  String email;
	private  String phone;
	private  String street1;
	private  String street2;
	private  String city;
	private  String stateProvince;
	private  String postalCode;
	private  String country;
	private String _id;
	

}
