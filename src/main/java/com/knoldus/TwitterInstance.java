package com.knoldus;

import twitter4j.Twitter;

/**
 * In TwitterInstance we have a method named getTwitterInstance that can be later implemented to get a twitter instance.
 */
interface TwitterInstance {
    Twitter getTwitterInstance();
}
