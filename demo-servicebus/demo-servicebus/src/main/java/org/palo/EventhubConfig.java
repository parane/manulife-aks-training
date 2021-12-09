package org.palo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventhubConfig {

    public String getEventhubReadConnection() {
        return eventhubReadConnection;
    }

    public void setEventhubReadConnection(String eventhubReadConnection) {
        this.eventhubReadConnection = eventhubReadConnection;
    }

    public String getEventhubWriteConnection() {
        return eventhubWriteConnection;
    }

    public void setEventhubWriteConnection(String eventhubWriteConnection) {
        this.eventhubWriteConnection = eventhubWriteConnection;
    }

    public String getEventhubName() {
        return eventhubName;
    }

    public void setEventhubName(String eventhubName) {
        this.eventhubName = eventhubName;
    }

    @Value("${eventhub.read-connection}")
    private String eventhubReadConnection;
    @Value("${eventhub.write-connection}")
    private String eventhubWriteConnection;
    @Value("${eventhub.name}")
    private String eventhubName;

}
