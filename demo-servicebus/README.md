## Azure Service Bus and Event Hub

### Azure Service Bus

Azure Service Bus is a messaging service on cloud used to connect any applications, devices, and also services running in the cloud to any other applications or services.

##### Azure Service Bus Queues and Topics

Queues and Topics are similar when a sender sends messages, but messages are processed differently by a receiver. A queue can have only one consumer, whereas a topic can have multiple subscribers.

1. Creating servicebus in Azure 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/sv.JPG)


2. Creating the Queue:

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/sv3.JPG)


3. get the SharedAccessKey for accessing the queue 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/sv2.JPG)

**Note:**

If you are behind proxy , you may get following error msg  :

    com.azure.core.amqp.exception.AmqpException: Connection timed out: no further information, errorContext[NAMESPACE: demo-manulife-servicebus.servicebus.windows.net. ERROR CONTEXT: N/A]
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/sv6.JPG)


4. Send msg to service Bus Queue 
    
        Post http://localhost:8080/servicebus
        
5. verify in azure :

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/sv4.JPG)

6. Send msg to Event hub
    
        Post http://localhost:8080/eventhub
        
7. verify in azure :

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/sv5.JPG)
