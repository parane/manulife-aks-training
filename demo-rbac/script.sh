az aks create -g piyush-training -n piyushTrainingAKSRBAC --enable-aad --enable-azure-rbac --generate-ssh-keys

AKS_ID=$(az aks show -g piyush-training -n piyushTrainingAKSRBAC --query id  -o tsv)

az role assignment create --role "Azure Kubernetes Service RBAC Admin" --assignee pjain@palo-it.com --scope $AKS_ID

APPDEV_ID=$(az ad group create --display-name appdev --mail-nickname appdev --query objectId -o tsv)

az role assignment create \\n  --assignee $APPDEV_ID \\n  --role "Azure Kubernetes Service Cluster User Role" \\n  --scope $AKS_ID

az ad group member add --group appdev --member-id "bd0923d4-a804-404d-9045-fe53b9a15f9f"

az aks get-credentials --resource-group piyush-training --name piyushTrainingAKSRBAC --admin

kubectl create namespace dev

kubectl apply -f role-dev-namespace.yaml

az ad group show --group appdev --query objectId -o tsv

vi rolebinding-dev-namespace.yaml

kubectl apply -f rolebinding-dev-namespace.yaml

az aks get-credentials --resource-group piyush-training --name piyushTrainingAKSRBAC --overwrite-existing

kubectl run nginx-dev --image=mcr.microsoft.com/oss/nginx/nginx:1.15.5-alpine --namespace dev

kubectl get pods --namespace dev

OPSSRE_ID=$(az ad group create --display-name opssre --mail-nickname opssre --query objectId -o tsv)

az role assignment create  --assignee $OPSSRE_ID  --role "Azure Kubernetes Service Cluster User Role"  --scope $AKS_ID

az ad group member add --group opssre --member-id "8f5e308f-592a-4408-b76f-c2210e5886e8"

kubectl create namespace sre

az aks get-credentials --resource-group piyush-training --name piyushTrainingAKSRBAC --admin

kubectl create namespace sre

vi role-sre-namespace.yaml

kubectl apply -f role-sre-namespace.yaml

az ad group show --group opssre --query objectId -o tsv

vi rolebinding-sre-namespace.yaml

kubectl apply -f rolebinding-sre-namespace.yaml

az aks get-credentials --resource-group myResourceGroup --name myAKSCluster --overwrite-existing

az aks get-credentials --resource-group piyush-training --name piyushTrainingAKSRBAC --overwrite-existing

kubectl run nginx-sre --image=mcr.microsoft.com/oss/nginx/nginx:1.15.5-alpine --namespace sre

kubectl get pods --namespace sre

kubectl get pods --namespace dev

kubectl get pods --all-namespaces

kubectl run nginx-sre --image=mcr.microsoft.com/oss/nginx/nginx:1.15.5-alpine --namespace dev\n

az aks get-credentials --resource-group piyush-training --name piyushTrainingAKSRBAC --admin

kubectl get pods --all-namespaces
