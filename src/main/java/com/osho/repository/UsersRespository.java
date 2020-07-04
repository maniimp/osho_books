package com.osho.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.osho.model.Users;

@Repository
public interface UsersRespository extends CrudRepository<Users, Long> {

}
