This repository holds API code for Spring IO Jamon game


# Commands:  
The app was created using Spring Initializr.   

After making any changes, update following command with new version number.
Execute to build the image and push it:  
````
gradle jibDockerBuild --image=gcr.io/jamon-coderprabhu/jamon:v4
docker push gcr.io/jamon-coderprabhu/jamon:v3


gradle jibDockerBuild --image=gcr.io/kubegcp-256806/jamon:v3
docker push gcr.io/kubegcp-256806/jamon:v3
kubectl apply -f k8s/coderprabhu-jamon-deployment.yaml  

````
```
gcloud auth login
gcloud auth configure-docker
```
You can run the image locally using
````
docker run -p 8080:8080 -t gcr.io/kubegcp-256806/jamon:v1  
curl http://localhost:8080
````
To update the k8s deployment with new version, update the api deployment yaml with new 
container image version and execute
````
kubectl apply -f k8s/coderprabhu-k8s/coderprabhu-api-deployment.yaml  
````

# Curl commands:   
````
curl http://jamon.coderprabhu.com
curl https://jamon.coderprabhu.com
curl https://api.coderprabhu.com/actuator/info
curl https://api.coderprabhu.com/actuator/health
````   