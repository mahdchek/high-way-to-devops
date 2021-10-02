# delete all pods
sudo kubectl delete -f ./deployments/

# delete all services
sudo kubectl delete -f ./services/

sleep 5

# create kubernetes dashboard
sudo kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended.yaml

# create config maps
sudo kubectl apply -f ./config-map/

# create secrets
#sudo kubectl apply -f ./secrets/

# create all pods
#sudo kubectl apply -f ./deployments/

# create all services
#sudo kubectl apply -f ./services/
