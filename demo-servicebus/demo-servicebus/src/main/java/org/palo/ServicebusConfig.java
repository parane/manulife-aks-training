package org.palo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicebusConfig {

    @Value("${servicebus.queue-name}")
    private String queueName;

    @Value("${servicebus.connection}")
    private String servciebusConnection;

    public String getServciebusConnection() {
        return servciebusConnection;
    }

    public void setServciebusConnection(String servciebusConnection) {
        this.servciebusConnection = servciebusConnection;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
