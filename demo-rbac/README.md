# DEMO RBAC - Creating an AKS cluster with RBAC enabled 

----
The project creates an AKS cluster which has RBAC enabled. According to AAA principle(Authentication, Authorisation and Admission Control) process, the steps that are put below will address to :

1. Authentication and Authorisation using Azure AD.
2. Authentication using Azure AD and Authorisation using Kubernetes RBAC.

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

1. AKS-managed Azure Active Directory integration
   
   - Create an AKS cluster by using the following CLI commands 
    
     az group create --name <Resource Group Name> --location <Azure Location>
     # Create an AKS-managed Azure AD cluster
     az aks create -g <Resource Group Name> -n <Cluster Name> --enable-aad --aad-admin-group-object-ids <id> [--aad-tenant-id <id>]

   - Get the AKS ID 
     
     AKS_ID=$(az aks show -g piyush-training -n piyushTrainingAKSRBAC --query id  -o tsv)

   - az role assignment create --role <Azure Role for the User> for eg. "Azure Kubernetes Service RBAC Admin" --assignee <Assignee username> --scope $AKS_ID

