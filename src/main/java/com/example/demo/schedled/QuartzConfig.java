package com.example.demo.schedled;

import lombok.AllArgsConstructor;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * 任务调度处理
 *
 * @author 杨正
 */
@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuartzConfig {

    /**
     * 任务调度
     */
    private final Scheduler scheduler;

    /**
     * 开始执行所有任务
     */
    public void startJob() throws SchedulerException {
        startJob1(scheduler);
        startJob2(scheduler);
        scheduler.start();
    }

    /**
     * 获取job信息
     *
     * @param name  任务名
     * @param group 任务组
     * @return {@link String}
     */
    public String getJobInfo(String name, String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        return String.format("time:%s,state:%s", cronTrigger.getCronExpression(), scheduler.getTriggerState(triggerKey).name());
    }

    /**
     * 修改某个任务执行时间
     *
     * @param name  任务名
     * @param group 任务组
     * @param time  要修改的时间
     * @return 是否修改成功
     */
    public boolean modifyJobExcuteTime(String name, String group, String time) throws SchedulerException {
        Date date = null;
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldCronExpression = cronTrigger.getCronExpression();
        if (!oldCronExpression.equalsIgnoreCase(time)) {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time);
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(cronScheduleBuilder).build();
            date = scheduler.rescheduleJob(triggerKey, trigger);
        }
        return date != null;
    }

    /* -------------------------------------------------↓ 添加任务 ↓---------------------------------------------------------------------------------- */

    private void startJob1(Scheduler scheduler) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        JobDetail jobDetail = JobBuilder.newJob(SchedulerQuartzJob1.class).withIdentity("job1", "group2").build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // CronTrigger表达式触发器 继承于Trigger TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1").withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    private void startJob2(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SchedulerQuartzJob2.class).withIdentity("job2", "group2").build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/5 * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job2", "group2").withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

}
