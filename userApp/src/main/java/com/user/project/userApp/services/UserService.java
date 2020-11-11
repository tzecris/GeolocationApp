package com.user.project.userApp.services;

import com.google.maps.model.Geometry;
import com.user.project.userApp.entities.User;
import com.user.project.userApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInt {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GeoCoder geoCoder;

    @Override
    public User findById(String id) {
        Optional<User> result = userRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByAfmOrName(String text) {
        //in case there is a first and last name
        String[] splited = text.split("\\s+");
        if(splited.length>1){
            return userRepository.findByFirstNameContainsOrAfmOrLastNameContains(splited[0],text,splited[1]);
        }
        return userRepository.findByFirstNameContainsOrAfmOrLastNameContains(text,text,text);
    }

    @Override
    public User saveUser(User user) {
        Geometry geo= geoCoder.getGeolocation(user.getAddress());
        if(geo!=null){
            user.getAddress().setLat(geo.location.lat);
            user.getAddress().setLng(geo.location.lng);
            return userRepository.save(user);
        }
        return null;

    }

    @Override
    public void deleteUser(User user) {
            userRepository.delete(user);
    }


}
