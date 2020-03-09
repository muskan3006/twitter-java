package com.knoldus;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * class TwitterInstanceImpl implements the TwitterInstance.
 */
public class TwitterInstanceImpl implements TwitterInstance {
    /**
     * getTwitterInstance method is overridden to give its implementation and retrieve an instance of twitter.
     *
     * @return an instance of Twitter.
     */
    @Override
    public Twitter getTwitterInstance() {
        Config config = ConfigFactory.load();
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(config.getString("consumer.key"))
                .setOAuthConsumerSecret(config.getString("consumer.secret"))
                .setOAuthAccessToken(config.getString("token.key"))
                .setOAuthAccessTokenSecret(config.getString("token.secret"));

        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        return twitterFactory.getInstance();
    }
}
