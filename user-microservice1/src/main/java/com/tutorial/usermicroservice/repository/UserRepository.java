package com.tutorial.usermicroservice.repository;

import com.tutorial.usermicroservice.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User1, Integer> {


}