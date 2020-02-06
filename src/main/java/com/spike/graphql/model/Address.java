package com.spike.graphql.model;

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
 * Created by Rohan Surve on 01/31/2020. This class is represents Address POJO
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {
	@Id
	@GraphQLQuery(name = "address_id", description = "A Address id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@GraphQLQuery(name = "street_name", description = "A Address street name")
	private String streetName;

	@GraphQLQuery(name = "state", description = "A Address state")
	private String state;

}
