package com.graph;

import com.graph.scheduler.JobScheduler;
import com.graph.scheduler.MyJob;
import org.quartz.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a JobDetail instance
            JobDetail job = JobBuilder.newJob(MyJob.class)
                    .withIdentity("fraudDetectionJob", "group1")
                    .build();

            // Create a Trigger to run the job every minute
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("fraudTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(60)  // Every 60 seconds
                            .repeatForever())
                    .build();

            // Start the Job Scheduler
            JobScheduler.startJob(job, trigger);
            System.out.println("🚀 Scheduler started successfully!");

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
