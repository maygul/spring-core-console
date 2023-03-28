package org.ptt.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.logging.Logger;


public class NotificationService implements ApplicationContextAware {
    private ApplicationContext context;
    private Logger log = Logger.getLogger(NotificationService.class.getName());
    private Notifier notifier;
    @Autowired
    private UselessBean uselessBean;

    public NotificationService(@Qualifier("slackNotifier") Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {
        log.info("**NotificationService**: " + message);
        notifier.notify(message);
    }

    public UselessBean getUselessBean() {
        uselessBean = context.getBean(UselessBean.class);
        return uselessBean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
