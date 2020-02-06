package com.spike.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spike.graphql.model.Address;

/**
 * Created by Rohan Surve on 01/31/2020.
 *This class is represents Employee Respository for CRUD
 */

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
