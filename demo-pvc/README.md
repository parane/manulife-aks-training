## DEMO Volume Provisioning

## [Volume](https://kubernetes.io/docs/concepts/storage/volumes/)

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Volume.JPG)


### Prior Steps 

Creating azure Storage Account and Azure File setup:

[Refer](https://zimmergren.net/mount-an-azure-storage-file-share-to-deployments-in-azure-kubernetes-services-aks/)


## Creating Azure file and manual static Volume Provisioning 

PVs are created by Kubernetes cluster administrators and exist in the Kubernetes API. PVs
represent real storage, and these stores provided by PVs are available to all users in the cluster.
With static provisioning, the PV is created in advance by the cluster administrator; the developer
creates the PVC and the Pod, and the Pod uses the storage provided by the PV through the PVC.


go into azurefile-static

### Creating Azure Secret
Add your Strorage account name and token in base64 format into azure-secret file and create 

    kubectl create -f azure-secret.yaml
    
### Creating Persistent Volume

    kubectl create -f pv-definition.yaml

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/PV.JPG)

    kubectl create -f pvc-definition.yaml

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/PVC.JPG)


### Creating K8s App component

create config map

    kubectl apply -f configmap-definition.yaml

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/Configmap.JPG)

create Pod or deployment for checking the app sync up with storage account 

**Make sure:**
 
Azure File Name is same as PersistentVolume(shareName) and Pod volumeMounts mountPath


**Debug steps**

Check any connectivity issue in K8s events:

    kubectl describe pod demopvc-pod
    
Check app log sync issues

    kubectl logs demopvc-pod  -c demopvc-pod
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/log.JPG)
  
    
Check App functionality 
List Down All exsiting files in Azure File in App Api 

1.
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/azure_file.JPG)

2. 
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/getfile.JPG)


**Upload File:**

1.
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/uploadfile.JPG)

2.
![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/azure_upload.JPG)


## Creating Azure file and  Dynamic Volume Provisioning 

For dynamic provisioning, when none of the static PVs created by the administrator can match the
user’s PVC, the cluster will try to automatically provision a storage volume for the PVC, which is
based on StorageClass.

![alt text](https://github.com/parane/manulife-aks-training/raw/main/images/storage.JPG)


go into azurefile-dynamic and follow the same steps as azurefile-static



