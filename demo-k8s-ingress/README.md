## Ingress = Ingress Resource (API) + Ingress Controller 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Ingress.JPG)

Demo:

### Step 1 Ingress Controller :

An Ingress controller is a specialized load balancer for Kubernetes (and other containerized)
environments.

In order for the Ingress resource to work, the cluster must have an ingress controller running.

### Creating two services 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/ingress2.JPG)

### Create Ingress controller

    helm upgrade --install ingress-nginx ingress-nginx \
      --repo https://kubernetes.github.io/ingress-nginx \
      --namespace para-sara
    
if no helm 

    kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.1.0/deploy/static/provider/cloud/deploy.yaml

    
### Create Ingress 

    kubectl create -f hello-ingress.yml

### Check up 

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/check_svc.JPG)

http://20.212.88.19/hello-world-one ---> aks-hello1

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/ingress_hello1.JPG)

http://20.212.88.19/hello-world-two ---> aks-hello2

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/ingress_hello2.JPG)