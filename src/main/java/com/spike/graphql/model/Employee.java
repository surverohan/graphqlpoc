package com.spike.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Rohan Surve on 01/31/2020. This class is represents Employee POJO
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Employee {
	@Id
	@GraphQLQuery(name = "employee_id", description = "A Employee id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@GraphQLQuery(name = "employee_firstname", description = "A Employee firstname")
	@Column(name = "employee_firstname", nullable = false)
	private String firstName;

	@GraphQLQuery(name = "employee_lastname", description = "A Employee lastname")
	private String lastName;

	@GraphQLQuery(name = "employee_code", description = "A Employee code")
	private int code;

	// @ManyToOne
	@GraphQLQuery(name = "address_id", description = "A Address id")
	// @JoinColumn(name = "address_id", nullable = false, updatable = false)
	private Long addressId;

}
