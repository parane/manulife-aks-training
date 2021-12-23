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
### Understanding the process 

![RBAC Image](https://docs.microsoft.com/en-us/azure/aks/media/concepts-identity/auth-flow.png)

As shown in the graphic above, the API server calls the AKS webhook server and performs the following steps:

1. kubectl uses the Azure AD client application to sign in users with OAuth 2.0 device authorization grant flow.
2. Azure AD provides an access_token, id_token, and a refresh_token.
3. The user makes a request to kubectl with an access_token from kubeconfig.
4. kubectl sends the access_token to API Server.
5. The API Server is configured with the Auth WebHook Server to perform validation.
6. The authentication webhook server confirms the JSON Web Token signature is valid by checking the Azure AD public signing key.
7. The server application uses user-provided credentials to query group memberships of the logged-in user from the MS Graph API.
8. A response is sent to the API Server with user information such as the user principal name (UPN) claim of the access token, and the group membership of the user based on the object ID.
9. The API performs an authorization decision based on the Kubernetes Role/RoleBinding.
10. Once authorized, the API server returns a response to kubectl.
11. kubectl provides feedback to the user.

----
### Steps to run 

1. AKS-managed Azure Active Directory integration
   
   - Create an AKS cluster by using the following CLI commands 
    
     `az group create --name <Resource Group Name> --location <Azure Location>`
     `az aks create -g <Resource Group Name> -n <Cluster Name> --enable-aad --aad-admin-group-object-ids <id> [--aad-tenant-id <id>]`

   - Get the AKS ID 
     
     `AKS_ID=$(az aks show -g piyush-training -n piyushTrainingAKSRBAC --query id  -o tsv)`

   - `az role assignment create --role <Azure Role for the User> for eg. "Azure Kubernetes Service RBAC Admin" --assignee <Assignee username> --scope $AKS_ID`

2. 

