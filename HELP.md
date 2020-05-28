

1) start spring-cloud-starter-dataflow-server-local from project and see http://localhost:9393/dashboard

2) java -jar spring-cloud-dataflow-shell-1.3.0.M1.jar (get from maven repository)

3) register service
   app register --name product-service --type source --uri file:///D:/_MSA/_dataflow/product-service-0.0.1-SNAPSHOT.jar
   app register --name discount-service --type processor --uri file:///D:/_MSA/_dataflow/discount-service-0.0.1-SNAPSHOT.jar
   app register --name courier-service --type sink --uri file:///D:/_MSA/_dataflow/courier-service-0.0.1-SNAPSHOT.jar
   
4) Create and Deploy the Stream
   stream create --name product-to-courier --definition 'product-service | discount-service | courier-service'

5) Then to deploy the stream execute the following shell command:
   stream deploy --name product-to-courier