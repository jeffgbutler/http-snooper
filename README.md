# HTTP Snooper

This application will display HTTP request attributes to the screen for debugging. The OCI image is published
at Docker Hub here: https://hub.docker.com/repository/docker/jeffgbutler/http-snooper

## Deploy to Docker

```shell
docker run -p8080:8080 jeffgbutler/http-snooper:0.0.1-SNAPSHOT 
```

Hit the application at http://localhost:8080

## Deploy to Kubernetes
Sample Kubernetes configuration files are in the `kubernetes` subdirectory of this repository. They can be used as is,
or modified for your environment. In particular, the `ingress.yaml` file will likely need changing for your
environment.

Create a deployment:

```shell
kubectl apply -f kubernetes/deployment.yaml
```

Expose the deployment with NodePort:

```shell
kubectl apply -f kubernetes/service.yaml
```

(Optional) Configure ingress (the included example assumes the NGINX ingress controller is installed in the cluster):

```shell
kubectl apply -f kubernetes/ingress.yaml
```

Access the application either through the NodePort, or through your configured ingress.
