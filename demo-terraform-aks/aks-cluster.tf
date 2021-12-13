provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "default" {
  name     = "piyush-training-rg"
  location = "West US 2"

  tags = {
    environment = "Demo"
  }
}

resource "azurerm_kubernetes_cluster" "default" {
  name                = "piyush-terraform-aks"
  location            = azurerm_resource_group.default.location
  resource_group_name = azurerm_resource_group.default.name
  dns_prefix          = "piyush-terraform-k8s"

  default_node_pool {
    name            = "default"
    node_count      = 2
    vm_size         = "Standard_D2_v2"
    os_disk_size_gb = 30
  }

  service_principal {
    client_id     = var.appId
    client_secret = var.password
  }

  tags = {
    environment = "training"
  }
}