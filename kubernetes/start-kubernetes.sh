# delete all pods
kubectl delete -f ./deployments/

# delete all services
kubectl delete -f ./services/

sleep 5

# create kubernetes dashboard
#kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended.yaml

# create config maps
kubectl apply -f ./config-map/

# create secrets
#kubectl apply -f ./secrets/

# create all pods
kubectl apply -f ./deployments/

# create all services
kubectl apply -f ./services/
