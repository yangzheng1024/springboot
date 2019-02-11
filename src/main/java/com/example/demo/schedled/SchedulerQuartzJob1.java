package com.example.demo.schedled;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 声明任务类1(实现Job接口)
 *
 * @author 杨正
 */
public class SchedulerQuartzJob1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务1开始执行...");
        System.out.println("任务1执行中...");
        System.out.println("任务1执行结束...");
    }
}
