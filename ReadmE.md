

## prerequisites

K3D
Docker
Kubectl

## How to use this application

Add Github token to below files

poc/conf/argocd/git-repository.yaml
poc/conf/tekton/git-access/secret.yaml

## cleanup docker to avoid issues

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
