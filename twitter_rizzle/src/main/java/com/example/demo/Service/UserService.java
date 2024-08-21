package com.example.demo.Service;

import com.example.demo.DTO.User;
import com.example.demo.Repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void followUser(String follower, String followee) {

        User followUser = userDao.findById(UUID.fromString(follower)).orElse(new User());
        User followeeUser = userDao.findById(UUID.fromString(followee)).orElse(new User());

        followeeUser.getFollowing().add(followeeUser);
        userDao.save(followeeUser);

        followeeUser.getFollowing().add(followUser);
        userDao.save(followeeUser);
    }
}
