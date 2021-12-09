package org.palo;

import com.azure.core.util.IterableStream;
import com.azure.messaging.eventhubs.*;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;


@RestController
public class EventController {

    @Autowired
    private EventhubConfig eventhubConfig;

    @PostMapping("/eventhub")
    public String publisher() throws IOException {


        EventHubProducerClient producer = new EventHubClientBuilder()
                .connectionString(eventhubConfig.getEventhubWriteConnection(), eventhubConfig.getEventhubName()).buildProducerClient();

        //generate event data
        List<EventData> events = new LinkedList<>();
        long lCurrentTime = System.currentTimeMillis();

        EventDataBatch batch = producer.createBatch();
        batch.tryAdd(new EventData("First event new"));
        batch.tryAdd(new EventData("Second event new"));
        batch.tryAdd(new EventData("Third event new"));
        batch.tryAdd(new EventData("Fourth event new"));
        batch.tryAdd(new EventData("Fifth event new"));

        // send the batch of events to the event hub
        producer.send(batch);
        // close the producer
        producer.close();

        System.out.println("Events send");

        return "Events created";

    }

    @GetMapping("/eventhub")
    public List<String> subscriber() throws IOException {


        // The required parameters are `consumerGroup`, and a way to authenticate with Event Hubs using credentials.
        EventHubConsumerClient consumer = new EventHubClientBuilder()
                .connectionString(eventhubConfig.getEventhubReadConnection(), eventhubConfig.getEventhubName())
                .consumerGroup("consumergroup")
                .buildConsumerClient();


        Instant twelveHoursAgo = Instant.now().minus(Duration.ofHours(12));
        EventPosition startingPosition = EventPosition.fromEnqueuedTime(twelveHoursAgo);
        String partitionId = "0";

        // Reads events from partition '0' and returns the first 100 received or until the 30 seconds has elapsed.
        IterableStream<PartitionEvent> events = consumer.receiveFromPartition(partitionId, 100,
                startingPosition, Duration.ofSeconds(30));

        try {
            List<String> lData = new LinkedList<>();

            for (PartitionEvent partitionEvent : events) {
                // For each event, perform some sort of processing.
                System.out.println(String.format("Event received: %d - Data-> %s ",
                        partitionEvent.getData().getSequenceNumber(),
                        new String(partitionEvent.getData().getBody())));
                lData.add(new String(partitionEvent.getData().getBody()));
            }
            System.out.println("data read done");
            return lData;

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());

        } finally {
            consumer.close();
        }


        return null;
    }
}