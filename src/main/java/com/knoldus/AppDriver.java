package com.knoldus;

import twitter4j.Query;
import twitter4j.Status;

import java.time.LocalDate;
import java.util.List;

public class AppDriver extends Const {
    public static void main(String[] args) {
        TwitterInstanceImpl twitterInstanceImpl = new TwitterInstanceImpl();
        Query hashTag = new Query("#suraj");
        GetStatus getStatus = new GetStatus(twitterInstanceImpl, hashTag);
        AnalysingTweets analysingTweets = new AnalysingTweets(getStatus, hashTag);
        List<Status> list;
        System.out.println("Posts from latest");
        list = analysingTweets.getLatestTweets();
        list.forEach((status) -> System.out.println(status.getId()
                + "\t\t" + status.getCreatedAt()
                + "\t\t" + status.getRetweetCount()
                + "\t\t" + status.getFavoriteCount()));
        System.out.println("#########################################################################################");
        System.out.println("Pots from oldest");
        list = analysingTweets.getOldestTweets();
        list.forEach((status) -> System.out.println(status.getId()
                + "\t\t" + status.getCreatedAt()
                + "\t\t" + status.getRetweetCount()
                + "\t\t" + status.getFavoriteCount()));

        System.out.println("#########################################################################################");
        System.out.println("Posts with highest Retweet first");
        list = analysingTweets.getNoOfRetweets();
        list.forEach((status) -> System.out.println(status.getId()
                + "\t\t" + status.getCreatedAt()
                + "\t\t" + status.getRetweetCount()
                + "\t\t" + status.getFavoriteCount()));
        System.out.println("#########################################################################################");
        System.out.println("Posts with highest Likes first");
        list = analysingTweets.getNoOfLikes();
        list.forEach((status) -> System.out.println(status.getId()
                + "\t\t" + status.getCreatedAt()
                + "\t\t" + status.getRetweetCount()
                + "\t\t" + status.getFavoriteCount()));
        System.out.println("#########################################################################################");
        System.out.println("Posts with highest Retweet first");
        list = analysingTweets.getNoOfRetweets();
        list.forEach((status) -> System.out.println(status.getId()
                + "\t\t" + status.getCreatedAt()
                + "\t\t" + status.getRetweetCount()
                + "\t\t" + status.getFavoriteCount()));
        System.out.println("#########################################################################################");
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Posts of a date");
        list = analysingTweets.getStatusOnDate(date);
        list.forEach((status) -> System.out.println(status.getId()
                + "\t\t" + status.getCreatedAt()
                + "\t\t" + status.getRetweetCount()
                + "\t\t" + status.getFavoriteCount()));
        System.out.println("#########################################################################################");
        System.out.println("Count of posts on that date" + analysingTweets.getCount(date));
    }

}
