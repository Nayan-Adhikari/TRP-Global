package com.graph.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobScheduler {

    public static void startJob(JobDetail job, Trigger trigger) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}