

## prerequisites

K3D
Docker
Kubectl

## How to use this application

Add Github token to below files

poc/conf/argocd/git-repository.yaml
poc/conf/tekton/git-access/secret.yaml

## Create Kubernetes cluster

sudo sh poc/create-local-cluster.sh

## setup poc applications

sudo sh setup-poc.sh

## port forwarding

kubectl port-forward svc/argocd-server -n argocd 9080:443

kubectl proxy --port=8080

## change sonarcube password

url: http://localhost:9000
admin/admin to admin/admin123

## clean up local kubernetes cluster and poc applications

sudo delete-local-cluster.sh