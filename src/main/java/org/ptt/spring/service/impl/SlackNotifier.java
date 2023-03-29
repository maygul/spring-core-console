package org.ptt.spring.service.impl;

import org.ptt.spring.service.Notifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Primary
@Component
public class SlackNotifier implements Notifier {

    private static final Logger log = Logger.getLogger(SlackNotifier.class.getName());

    @Override
    public void notify(String message) {
        log.info("SlackNotifier: " + message);
    }
}
