package com.example.demo.schedled;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 声明任务类2(实现Job接口)
 *
 * @author 杨正
 */
public class SchedulerQuartzJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务2开始执行...");
        System.out.println("任务2执行中...");
        System.out.println("任务2执行结束...");
    }
}
