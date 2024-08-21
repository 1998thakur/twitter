package com.example.demo.Service;

import com.example.demo.DTO.Feed;
import com.example.demo.DTO.User;
import com.example.demo.Repository.FeedRepository;
import com.example.demo.Repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Slf4j
@Service
public class FeedService {

    @Autowired
    FeedRepository feedRepository;

    @Autowired
    UserDao userDao;

    List<Feed> contents = new ArrayList<>();

    public Feed saveFeed (Feed feed) {
        return feedRepository.save(feed);
//        contents.add(feed);
//        return feed;
    }

    public List<Feed> getAllFeeds(String userId) {
        Optional<User> user = userDao.findById(UUID.fromString(userId));
        if (user.isEmpty()) {
            throw new RuntimeException("No user found");
        }

        return feedRepository.findAllByUserIn(user.get().getFollowing());
    }
}
