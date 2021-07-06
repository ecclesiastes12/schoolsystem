package com.org.schoolsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

	/**
	 * NB @RequiredArgsConstructor goes with @NonNull
	 * without @NonNull on the field variable  @RequiredArgsConstructor will generate error
	 */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	Integer id;
	
	@NonNull
	@Column(unique = true)
	String name;
	
	@NonNull
	String description;
}
