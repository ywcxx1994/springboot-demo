package cn.yanwin.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
@Component
public class CommonLineRunnerDemo implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.printf("5: CommonLineRunnerDemo init success ");
    }
}
