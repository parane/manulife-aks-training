# manulife-aks-training

#### Prerequist Tools setup (Window) :
1. **Docker & Kubernetes** : Install [Docker Desktop](https://www.docker.com/products/docker-desktop)
We ll get both. 
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/docker_k8s.JPG)
2. **Azure CLI**:
[Download](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli)
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Azure.JPG)

3. **Istio Ctl** 
[Download](https://github.com/istio/istio/releases/tag/1.12.1)  istio-1.12.1-win or  istioctl-1.12.1-win from : 
and Add into Path in env variable: 
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Istio.JPG)

4. **Helm**
[Helm-Download](https://github.com/helm/helm/releases)
and Add into Path in env variable.
(ref: https://phoenixnap.com/kb/install-helm)
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Helm.JPG)


## Day-1
### 1. Creating AKS cluster Setup: 
Created Azure Kubernetes Cluster using following method :
 1. Azure potral (UI - Easy to setup)
 2. Azure Cli (Cmd - Easy for azure admin)  
 3. Terraform (infrastructure as code software tool that provides a consistent CLI(not cloud vendor dependent). 
 Easy for version control). Enterprise standard :thumbsup:
 
[demo-terraform-aks](https://github.com/parane/manulife-aks-training/tree/main/demo-terraform-aks)

### 2. Sync up with AKS cluster : 
Replace kube config file in your local (C:\Users\[user-name]\.kube) which contain access credential step 1 

(If any issue pls remove exsiting config file and remove ~/.kube and ~/Library/Group\ Containers/group.com.docker/pki directory, then restart docker desktop and wait like 5 minutes)

### 3. checkup : 
kubectl get node 
kubectl get ns
To make sure the connectivity to AKS cluster

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Checkup.JPG)

Note: 
Acessing Each folder for following topic: 

demo- completion / practice - for our practice

### 4. Creating basic k8s components (practice-aks & demo-basic-AKS ): 

pls refer: [practice-aks](https://github.com/parane/manulife-aks-training/tree/main/practice-aks)

### 5. Creating Volume (demo-pvc): 

pls refer: [demo-pvc](https://github.com/parane/manulife-aks-training/tree/main/demo-pvc)

### 6. Creating Statefulset (demo-statefulset): 

pls refer: [demo-statefulset](https://github.com/parane/manulife-aks-training/tree/main/demo-statefulset)

### 7. Creating Job (demo-job): 

pls refer: [demo-job](https://github.com/parane/manulife-aks-training/tree/main/demo-job)

### 8. Creating K8s Network Ingress (demo-k8s-ingress): 

pls refer: [demo-k8s-ingress](https://github.com/parane/manulife-aks-training/tree/main/demo-k8s-ingress)

### 9. Health Check (demo-healthcheck): 

pls refer: [demo-healthcheck](https://github.com/parane/manulife-aks-training/tree/main/demo-healthcheck)

## Day-2

### 1. Istio Setup (demo-istio): 

pls refer: [demo-istio](https://github.com/parane/manulife-aks-training/tree/main/demo-istio)

### 2. Security on AKS (demo-rbac): 

pls refer: [demo-rbac](https://github.com/parane/manulife-aks-training/tree/main/demo-rbac)

### 3. Security on AKS (demo-rbac): 

pls refer: [demo-rbac](https://github.com/parane/manulife-aks-training/tree/main/demo-rbac)

### 4. Helm (practice-helm): 

pls refer: [demo-rbac](https://github.com/parane/manulife-aks-training/tree/main/practice-helm)