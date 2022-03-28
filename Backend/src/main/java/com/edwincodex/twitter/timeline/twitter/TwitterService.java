package com.edwincodex.twitter.timeline.twitter;

import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    private final static int MAX_POSTS = 5;

    public static Twitter getTwitterinstance() {
        return TwitterFactory.getSingleton();
    }

    public List<Tweet> getTimeLine(Long userId) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        List<Status> statuses = twitter.getUserTimeline(userId, new Paging(1, MAX_POSTS));
        return statuses.stream()
                .map(this::toPost)
                .collect(Collectors.toList());
    }

    private Tweet toPost(Status status){
        Tweet tweet = new Tweet();
        tweet.setId(status.getId());
        tweet.setUserName(status.getUser().getName());
        tweet.setText(status.getText());
        tweet.setPhoto(status.getUser().getMiniProfileImageURL());
        return tweet;
    }
}
