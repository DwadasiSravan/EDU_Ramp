package com.user_service.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity  
@Table(name = "users")

public class User {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	    private String name;
	    private String email;
	    private String phone;
	    private String role;
	    private Long planId;

	    public User() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Long getPlanId() {
			return planId;
		}

		public void setPlanId(Long planId) {
			this.planId = planId;
		}

		public User(Long id, String name, String email, String phone, String role, Long planId) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.role = role;
			this.planId = planId;
		}
	        

	    
}
