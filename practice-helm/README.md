## Helm

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm1.JPG)
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm2.JPG)


##  Demo
 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm8.JPG)
 
### Repository

You can also download and use existing ones in the cluster. 

Add stable repo:

    helm repo add stable https://charts.helm.sh/stable
    
Update Repository:
 
    helm repo update
    
Search ELK:

In repo:

    helm search repo ELK
    
  ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm3.JPG)
  
In hub :

Helm Hub is NOT like a repo that you can add and install from it helm charts

    helm search hub ELK
    
### Helm Chart
    
**Create Helm Chart**
    
A Helm Chart is a templated deployment package that describe a related set of Kubernetes
resources. It contains all the information required to build and deploy the manifest files for an
application to run on a Kubernetes cluster.

    helm create app-chart

following directory app-chart folder will be created :

  ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm7.JPG)

Install helm chart

    helm install para-app-helm -f .\app-chart\myvalues.yaml .\app-chart
    
 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm6.JPG)
 
 Note: --dry-run for without installation check up 

Uninstall/Delete in single command 

    helm delete paraapp-helm
    
List Installed chart:

    helm ls

 ![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/helm9.JPG)
    
Rollback helm release :

    helm rollback <release name> <release version>
