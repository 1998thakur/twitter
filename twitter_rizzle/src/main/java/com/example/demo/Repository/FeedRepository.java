package com.example.demo.Repository;

import com.example.demo.DTO.Feed;
import com.example.demo.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FeedRepository extends JpaRepository<Feed, String> {
    List<Feed> findAllByUserIn(Set<User> user);
}
