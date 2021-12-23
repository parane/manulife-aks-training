## Istio = Ingress Resource (API) + Ingress Controller 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Istio1.JPG)

Demo:

Installing Istio on our Cluster

    istioctl install --set profile=demo -y

Verify Istio

    istioctl verify-install

Add a namespace label to instruct Istio to automatically inject Envoy sidecar proxies when you deploy your application later

    kubectl label namespace para-sara istio-injection=enabled
    
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/istiolabel.JPG)

    
Verify the Istio inject by creating new pod (need to inject the istio proxy as sidecar)

    kubectl describe pod demoapp-sts
 
 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Istio2.JPG)
 
### Bookinfo Application

Sample app:  
[BookInfo](https://istio.io/latest/docs/examples/bookinfo/)
 
1. Intall the microservices and resources:

2. Accessible in Cluster 
   -> create temp pod and execute the cmd (if u r in window)
   
        curl -sS productpage:9080/productpage | grep -o "<title>.*</title>"

3. Accessible through gateway


 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/istio12.JPG) 
 
 
v3 Rating microservice
 
 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/istio4.JPG)

v1 Rating microservice 

 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/istio5.JPG)

### Some add Add-ons on top of Istio

**Giali :**

    kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.12/samples/addons/kiali.yaml
    
Port forwarding to get the access :

    kubectl port-forward svc/kiali 20001:20001 -n istio-system
 
 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Kilai.JPG)
 
**Grafana:** 

    kubectl port-forward service/grafana 3000:3000 -n istio-system

 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/graphana.JPG)
