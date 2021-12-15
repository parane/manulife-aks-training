# DEMO 1 - Creating a container registry and AKS cluster

----
The project creates an 3 resources in total 
1. Service Principal : An Azure service principal is an identity created for use with applications, hosted services, and automated tools to access Azure resources. 
2. Azure container registry : Azure Container Registry is a private registry service for building, storing, and managing container images and related artifacts
3. Azure Kubernetes Service Cluster: AKS allows you to quickly deploy a production ready Kubernetes cluster in Azure

----
### Tools used 

1. Azure CLI
2. Kubectl

----
 ### Pre-requisites

1. az cli installed
2. kubectl installed

----
### Steps to run 

1. Run below command to create a resource group in Azure.

     az group create --name <<Resource Group Name>> --location <<Region>>

2. Create a service principal ( it is much like an identity : a username and password ) and assign role to pull images/gain access to certain Azure resources.

3. Command to create : 
        
        az ad sp create-for-rbac --skip-assignment

   We are returned an "appId" and "password" --> save this separately somewhere

4. Now run to create an Azure Container Registry 
        
        az acr create --resource-group <<RG Name>> --name <<ACR Name>> --sku Basic'

5. Now, we can assign/add permissions to our Service Principal to read ACR images by runnning
        
        az role assignment create --assignee <<APP_ID>> --role acrpull --scope <<ACR_ID>>


6. At this point to build and push images to ACR, we can run :

        az acr build --image <IMG_NAME>:<VERSION> --registry <ACR_NAME> --file Dockerfile .

5. To create a basic AKS cluster:

        az aks create --resource-group <<RG_NAME>> \
        --name <<Cluster_Name>> \
        --node-count <<default is 3>> \
        --enable-addons [<monitoring etc.>] \
        --generate-ssh-keys \
        --service-principal <<SP_ID>> \
        --client-secret <<client-pass>>
