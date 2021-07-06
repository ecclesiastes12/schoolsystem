package com.org.schoolsystem.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@NonNull
	@Column(unique = true)
	String email;
	
	@NonNull
	@Column(name = "first_name")
	String firstName;
	
	@NonNull
	@Column(name = "last_name")
	String lastName;
	
	@NonNull
	String password;
	
	boolean enabled;
	
	@ManyToMany
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
			)
	Set<Role> roles = new HashSet();

	//method to add roles to users
	public void addRole(Role role) {
		this.roles.add(role);
	}
	
}
