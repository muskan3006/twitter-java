package com.knoldus;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

/**
 * GetStatus class is used to get a list of statuses.
 */
public class GetStatus {
    TwitterInstance twitterInstance;
    Query hashTag;

    /**
     * This is a constructor of class GetStatus.
     *
     * @param twitterInstance is an instance of TwitterInstance
     * @param hashTag         is an instance of Query
     */
    public GetStatus(TwitterInstance twitterInstance, Query hashTag) {
        this.twitterInstance = twitterInstance;
        this.hashTag = hashTag;
    }

    /**
     * getListOfStatus gets a list of status on the basis of a query.
     *
     * @param hashTag an instance of Query.
     * @return a list of Status.
     */
    List<Status> getListOfStatus(Query hashTag) {
        List<Status> listOfStatus = new ArrayList<>();
        try {
            listOfStatus = twitterInstance.getTwitterInstance().search(hashTag).getTweets();
        } catch (TwitterException twitterException) {
            twitterException.printStackTrace();
        }
        return listOfStatus;
    }
}
