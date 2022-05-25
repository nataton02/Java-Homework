package de.telran.spring_load_balancer.thread;


import de.telran.spring_load_balancer.storage.IServerStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Cleaner {
    private final IServerStorage serverStorage;
    private final int periodMillis;

    public Cleaner(IServerStorage serverStorage,
                   @Value("${balancer.server.map.cleaner.period}") int periodMillis) {
        this.serverStorage = serverStorage;
        this.periodMillis = periodMillis;
    }

    @Async("threadExecutor")
    public void run() {
        System.out.println("Cleaner");
        while (true) {
            try {
                Thread.sleep(periodMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            serverStorage.clear(periodMillis);

        }
    }
}
