## DEMO 1 - Creating a container registry and AKS cluster

### Prior Steps 

#### Docker file creation and Push into Repo

Open cmd in this folder:

Jar file creation

    gradle install

Docker image Build

    docker build -t <para-aks-app> .
    
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Docker.JPG)

Check up 

    docker images

Docker image Push to Registry:

1. Pushing to ACR(Azure Container Registry) : [here](https://github.com/parane/manulife-aks-training/tree/main/demo-basic-AKS#readme) 

2. Push to Docker Hub (public Repo)

    2.1 docker tag image :

        docker image tag para-aks-app parane/para-aks-app:latest

    2.2 Login to Docker hub
    
        docker login
    
    2.3 push to Repo
    
        docker image push parane/para-aks-app
    
    2.4 Check up:
        go to the https://hub.docker.com/ check your image
        
     ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/docker_hub.JPG)
        

### Deploy to AKS Cluster

#### Setup the AKS Namespace

This is simple springboot application and some some env configuration. We need to deploy the application in AKS and 
expose this app into external world.

Creating name space in AKS

    kubectl create namespace <para-sara>

To switch default namespace

    kubectl config set-context --current --namespace=<para-sara>

Check the cluster and  context are correct

    kubectl config get-contexts
    
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/context.JPG)

For remove all in namespace , if any issue or freshly doing 

    kubectl delete all --all -n <para-sara>

#### Running K8s component

##### Creating config map for inject the configuration entries to application

[**ConfigMap :**](https://kubernetes.io/docs/concepts/configuration/configmap/)

A ConfigMap is an API object used to store non-confidential data in key-value pairs.

    kubectl create -f configmap.yaml

 Check up 
    
    kubectl get configmap

##### creating simple pod :

[**Pod:**](https://kubernetes.io/docs/concepts/workloads/pods/)

Pods are the smallest deployable units of computing that you can create and manage in Kubernetes.

    kubectl create -f pod-definition.yml

 Check up :

    kubectl get pod
 
 If it is not running in privious steps:

    kubectl describe pod <node-app>

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/context.JPG)


##### creating Deployment

[**Deployment:**](https://kubernetes.io/docs/concepts/workloads/controllers/deployment/)

A Deployment provides declarative updates for Pods and ReplicaSets.

Note: we ll create the seperate deployment with 3 replicas with our same image.

Create deployment command 

    kubectl create -f deployment-definition.yml

Check up 

    kubectl get deployment
    kubectl get pods

make sure 3 pods are running stage
if not , pls check the event logs using kubectl describe command

We can upgrade our image in repo and redeploy using deployment apply or kubectl set image.

##### creating Service 

[**Services:**](https://kubernetes.io/docs/concepts/services-networking/service/)

An abstract way to expose an application running on a set of Pods as a network service


![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Services.JPG)

Note: Service selector label same as pod label

Creating Load balancer service for exposing to external: 

    kubectl create -f service-definition.yml
    
checkup: 

    kubectl get svc

hit External-ip:80 in browser 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/loadbalancer.JPG)