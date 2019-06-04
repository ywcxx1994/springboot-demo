package cn.yanwin.demo.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:YanWei
 * @date: 2019/5/22 17:13
 * @desc: sping中的定时器，
 * 结论：默认spring中的定时器是一个线程在执行。可以使用线程池多线程执行任务
 * fixedDelay：当本任务执行完毕间隔指定时间(fixedDelay)再次执行该任务，若该任务阻塞，则直到执行完毕后，间隔执行时间再次执行该任务。
 * fixedRate：本任务执行时间开始算，间隔指定时间后再次执行该任务，若本任务阻塞，则累计阻塞时间中应执行的任务，一下子执行完毕，再次按照rate执行。
 * initialDelay: 该属性代表，容器启动成功后，间隔指定时间，开始执行定时任务。
 */
@Slf4j
@Component
public class SchedulingDemo {
    DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    //@Scheduled(cron = "*/5 * * * * ?")
    //@Scheduled(fixedRate=5000)
    public void noreCharge() {
        System.out.println("test1定时任务开始:"+sdf.format(new Date()));
        demo1();
        System.out.println("test1定时任务结束"+sdf.format(new Date()));
    }

    public void demo1(){
        log.info("demo1 start"+sdf.format(new Date()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("demo1 end"+sdf.format(new Date()));
    }
    public void demo2(){
        log.info("demo2 start");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("demo2 end");
    }
    @Scheduled(initialDelay = 1000*10,fixedDelay = 15000)
    public void test2() {
        System.out.println("test2定时任务开始:"+sdf.format(new Date()));
        demo2();
        System.out.println("test2定时任务结束"+sdf.format(new Date()));
    }
}
