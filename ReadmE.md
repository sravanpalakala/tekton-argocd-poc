

## prerequisites

K3D

Docker

Kubectl

Ngrok

## Disable 5000 port (airplay) for macbook guys

## fork this repository

checkout forked repository to localmachine

serach for "Manikanta-Reddy-Pasala" and replace with your github user id

## update create-local-cluster.sh file

please chnage below folder as per your local folder structure..

--registry-config "/Users/manikantapasala/Documents/coderepo/POC/tekton-argocd-poc/poc/conf/k3d/tekton-registry.yaml"

## How to use this application

Add Github token to below files also 

poc/conf/argocd/git-repository.yaml

poc/conf/tekton/git-access/secret.yaml

poc/conf/tekton/tasks/push-to-gitops-repo.yaml

## cleanup docker to avoid issues
## First tomer skip this step 
##  it deleted all resources from docker

docker rm -vf $(docker ps -aq)

docker rmi -f $(docker images -aq)

docker system prune -a --volumes

## Create Kubernetes cluster

sudo sh poc/create-local-cluster.sh

## setup poc applications

cd poc 
sudo sh setup-poc.sh

## port forwarding

kubectl port-forward svc/argocd-server -n argocd 9080:443

kubectl proxy --port=8080

## change sonarcube password

url: http://localhost:9000
admin/admin to admin/admin123

## create a webhook

ngrok http 8080

update webhook in github repo with following url and passcode

https://<ngrok url>/hooks
passcode: 1234567

## clean up local kubernetes cluster and poc applications

sudo sh delete-local-cluster.sh
