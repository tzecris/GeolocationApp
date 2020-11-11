package com.user.project.userApp.repositories;

import com.user.project.userApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public List<User> findByFirstNameContainsOrAfmOrLastNameContains(String fName, String afm, String lName);
}
