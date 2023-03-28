package org.ptt.spring.service.impl;

import org.ptt.spring.service.Notifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class TwitterNotifier implements Notifier {

    private static final Logger log = Logger.getLogger(TwitterNotifier.class.getName());

    @Override
    public void notify(String message) {
        log.info("TwitterNotifier: " + message);
    }

    public void aopNotifyExample(String anotherMessage) {
        log.info("TwitterNotifier-aopNotifyExample: " + anotherMessage);
    }
}
