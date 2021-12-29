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


Not able to continue , following error :

    com.azure.core.amqp.exception.AmqpException: Connection timed out: no further information, errorContext[NAMESPACE: demo-manulife-servicebus.servicebus.windows.net. ERROR CONTEXT: N/A]

