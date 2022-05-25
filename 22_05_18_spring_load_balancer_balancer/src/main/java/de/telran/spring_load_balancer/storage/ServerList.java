package de.telran.spring_load_balancer.storage;

import de.telran.spring_load_balancer.model.Server;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Component
public class ServerList implements IServerStorage {
    List<Server> source = new ArrayList<>();

    @Override
    public synchronized void update(Server serverData) {
       source.remove(serverData);
       source.add(serverData);
    }

    @Override
    public synchronized void clear(int millis) {
        source.removeIf(serverData ->
                ChronoUnit.MILLIS.between(serverData.getTimeLastUpdate(), LocalDateTime.now()) > millis);
    };

    @Override
    public synchronized Server getOptimal() {
        return source.stream()
                .min(Comparator.comparingInt(Server::getLoad))
                .orElse(null);
    }
}
