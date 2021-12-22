## Statefulset vs Stateless Application

A **Stateful application** saves data about each client session and uses that data the next
time the client makes a request. ie DB, Msg Queue

A **Stateless app** is an application program that does not save client data generated in one
session for use in the next session with that client. ie Web apps

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/stateful.JPG)
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/dep_stat.JPG)

### healess Service (headless-service.yml)

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/headless.JPG)

Demo - Create headless services 
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/headless2.JPG)



## Using PVCs in StatrfulSet (statefulset-definition.yml)

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/state.JPG)