package com.knoldus;

import twitter4j.Query;
import twitter4j.Status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AnalysingTweets class analyses the tweets and do different functioning.
 */
public class AnalysingTweets {
    GetStatus getStatus;
    Query hashTag;

    /**
     * This is a constructor of the class.
     *
     * @param getStatus is an instance of GetStatus.
     * @param hashTag   is an instance of Query.
     */
    public AnalysingTweets(GetStatus getStatus, Query hashTag) {
        this.getStatus = getStatus;
        this.hashTag = hashTag;
    }

    /**
     * getLatestTweets return a list of Status keeping latest first.
     *
     * @return a list of Status.
     */
    List<Status> getLatestTweets() {
        return getStatus
                .getListOfStatus(hashTag)
                .stream()
                .limit(Const.limit)
                .collect(Collectors.toList());
    }

    /**
     * getOldestTweets return a list of Status keeping oldest first.
     *
     * @return a list of Status.
     */
    List<Status> getOldestTweets() {

        return getStatus
                .getListOfStatus(hashTag)
                .stream()
                .sorted(Comparator.comparing(Status::getCreatedAt))
                .limit(Const.limit)
                .skip(Const.offset)
                .collect(Collectors.toList());

    }

    /**
     * getNoOfRetweets analyses list of Status to arrange it such that most number of Retweeted tweets are first.
     *
     * @return list of Status.
     */
    List<Status> getNoOfRetweets() {
        return getStatus
                .getListOfStatus(hashTag)
                .stream()
                .sorted(Comparator.comparing(Status::getRetweetCount).reversed())
                .collect(Collectors.toList());

    }

    /**
     * getNoOfLikes analyses list of Status to arrange it such that most number of Liked tweets are first.
     *
     * @return list of Status.
     */
    List<Status> getNoOfLikes() {
        return getStatus
                .getListOfStatus(hashTag)
                .stream()
                .sorted(Comparator.comparing(Status::getFavoriteCount).reversed())
                .collect(Collectors.toList());

    }

    /**
     * getStatusOnDate returns tweets having the same date as of Input.
     *
     * @param date date of which tweets have to be found.
     * @return a list of Status.
     */
    List<Status> getStatusOnDate(LocalDate date) {
        return getStatus
                .getListOfStatus(hashTag)
                .stream()
                .filter(status -> status
                        .getCreatedAt()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .isEqual(date))
                .collect(Collectors.toList());
    }

    /**
     * getCount gives the count of the statuses on a particular date.
     *
     * @param date date of which tweets have to be counted.
     * @return the count of the statuses on that date.
     */
    Long getCount(LocalDate date) {
        return (long) getStatusOnDate(date)
                .size();
    }

}
