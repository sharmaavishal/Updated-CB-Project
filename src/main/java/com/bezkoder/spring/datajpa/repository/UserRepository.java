package com.bezkoder.spring.datajpa.repository;


import com.bezkoder.spring.datajpa.model.Tutorial;
import com.bezkoder.spring.datajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>

{
    List<User> findByfirstnameContaining(String firstname );

     List <User> findByEmailidAndPassword(String emailId, String password);

    List<User> findByEmailid(String emailId);
}