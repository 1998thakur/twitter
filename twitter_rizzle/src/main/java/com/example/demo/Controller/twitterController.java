package com.example.demo.Controller;

import com.example.demo.DTO.Feed;
import com.example.demo.Service.FeedService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitter")
public class twitterController {

    @Autowired
    FeedService feedService;

    @Autowired
    UserService userService;

    @PostMapping("/post")
    public Feed postFeed(@RequestBody Feed feed) {
        return feedService.saveFeed(feed);
    }

    @GetMapping("/feed")
    public List<Feed> getAllFeeds(@RequestParam String userId) {
        return feedService.getAllFeeds(userId);
    }

    @PostMapping("/follow-user")
    public void followUser(@RequestParam String follower, String followee) {
        userService.followUser(follower, followee);
    }
}
