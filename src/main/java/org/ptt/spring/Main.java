package org.ptt.spring;

import org.ptt.spring.config.SpringBeanConfig;
import org.ptt.spring.service.UselessBean;
import org.ptt.spring.service.impl.TwitterNotifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);

        /*
        TwitterNotifier twitterNotifier = context.getBean(TwitterNotifier.class);
        twitterNotifier.notify("Hello World");

        DiscordNotifier discordNotifier = context.getBean(DiscordNotifier.class);
        discordNotifier.notify("Hello World");

        SlackNotifier slackNotifier = context.getBean(SlackNotifier.class);
        slackNotifier.notify("Hello World");
         */

        /*
        Notifier notifier = context.getBean(TwitterNotifier.class);
        notifier.notify("Hello World");
        */

        /*
        Notifier notifier = context.getBean(TwitterNotifier.class);
        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.setNotifier(notifier);
        notificationService.notify("Hello World");
        */

        /*
        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.notify("Hello World");
        */

        /*
        UselessBean uselessBean = context.getBean(UselessBean.class);
        uselessBean.setName("Useless1");

        UselessBean uselessBean2 = context.getBean(UselessBean.class);

        if (uselessBean2.getName().equals(uselessBean.getName())) {
            log.info("Same instance");
        }
         */

        /*
        UselessBean uselessBean = context.getBean(UselessBean.class);
        uselessBean.setName("Useless1");

        UselessBean uselessBean2 = context.getBean(UselessBean.class);
        if (uselessBean.equals(uselessBean2)) {
            log.info("Same instance");
        } else {
            log.info("Different instance");
        }
        */

        /*
        NotificationService notificationService = context.getBean(NotificationService.class);
        UselessBean uselessBean = notificationService.getUselessBean();

        NotificationService notificationService2 = context.getBean(NotificationService.class);
        UselessBean uselessBean1 = notificationService2.getUselessBean();

        if (uselessBean == uselessBean1) {
            log.info("Same instance");
        } else {
            log.info("Different instance");
        }
         */

        /*
        PropertyConfig propertyConfig = context.getBean(PropertyConfig.class);
        log.info(propertyConfig.getUrl());
        log.info(propertyConfig.getUsername());
        log.info(propertyConfig.getPassword());
         */
        /*
        TwitterNotifier twitterNotifier = context.getBean(TwitterNotifier.class);
        twitterNotifier.notify("Hello World! Do you hear me!");
        twitterNotifier.aopNotifyExample("not null message");
*/
        UselessBean uselessBean = context.getBean(UselessBean.class);
        uselessBean.uselessMethod();

        log.info("Started application");
    }
}