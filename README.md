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
 2. Terraform (infrastructure as code software tool that provides a consistent CLI). Enterprise standard
 3. Azure Cli 

### 2. Sync up with AKS cluster : 
Replace kube config file which contain access credential step 1 
(If any issue pls remove exsiting config file and remove ~/.kube and ~/Library/Group\ Containers/group.com.docker/pki directory, then restart docker desktop and wait like 5 minutes)

### 3. checkup : 
kubectl get node 
kubectl get ns
To make sure the connectivity to AKS cluster

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Checkup.JPG)

### 4. Creating basic k8s components: 
demo- completion 
practice - for our practice

pls refer: [practice-aks](https://github.com/parane/manulife-aks-training/tree/main/practice-aks)
