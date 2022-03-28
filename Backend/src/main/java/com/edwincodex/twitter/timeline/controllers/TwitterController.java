package com.edwincodex.twitter.timeline.controllers;

import com.edwincodex.twitter.timeline.twitter.Tweet;
import com.edwincodex.twitter.timeline.twitter.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TwitterController {

    private final TwitterService tweets;

    @Autowired
    public TwitterController(TwitterService tweets){
        this.tweets = tweets;
    }

    @RequestMapping(value = "api/v1/twitter/{userId}", method = RequestMethod.GET)
    public List<Tweet> getTweetsByUser(@PathVariable Long userId) {
        try {
            return tweets.getTimeLine(userId);
        } catch (TwitterException e){
            throw new RuntimeException(e);
        }
    }

}
