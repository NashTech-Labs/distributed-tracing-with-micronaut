## Distributed tracing with Micronaut

<!-- wp:paragraph -->
<p>When operating Microservices in production it can be challenging to troubleshoot interactions between Microservices in a distributed architecture.
To solve this problem, a way to visualize interactions between Microservices in a distributed manner can be critical. Currently, there are various distributed tracing solutions, the most popular of which are Zipkin and Jaeger, both of which provide different levels of support for the Open Tracing API.
Micronaut features integration with both Zipkin and Jaeger (via the Open Tracing API).</p>
<!-- /wp:paragraph -->

- Creatd itemCatalogue microservice
- Creatd itemInventory microservice
- Creatd itemRecommendation microservice.


## Requirements
- Micronaut
- Gradle 3.6.1 
- JDK 1.8 or greater installed with JAVA_HOME
- Enable annotation Processing.
    - ![1 5](https://user-images.githubusercontent.com/85616604/196144615-83ca2d81-667f-4832-9783-9575cee4dce6.png)
- Install Jaeger via Docker
    - docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 14250:14250 \
  -p 9411:9411 \
  jaegertracing/all-in-one:latest

## How to run the project?

- Run itemCatalogue microservice.
    - gradle run
    - ![1](https://user-images.githubusercontent.com/85616604/196146455-1d68ad14-f903-4626-bfc4-23074441fe0f.png)

    - http://localhost:8081/items
    - ![1 1](https://user-images.githubusercontent.com/85616604/196146340-9054563a-759e-4047-8414-d86396651f2c.png)


- Run itemInventory microservice.
    - gradle run
    - ![2](https://user-images.githubusercontent.com/85616604/196146770-0d88ad74-c691-4dac-ad82-16378ed48e1a.png)

    - http://localhost:8082/items/stock/1680502395
    - ![1 2](https://user-images.githubusercontent.com/85616604/196145945-24ff597f-5faa-4973-89b5-9c5b29ac2652.png)

- Run itemRecommendation microservice.
    - gradle run
    - ![3](https://user-images.githubusercontent.com/85616604/196146794-204ede7a-4551-489d-b5c9-e6c7b646cbd6.png)

    - http://localhost:8080/items
    - ![1 3](https://user-images.githubusercontent.com/85616604/196145983-f7717d84-bdd0-4511-9106-18119724b554.png)

- You can then navigate to http://localhost:16686 to access the Jaeger UI.
    - ![Screenshot from 2022-10-17 15-59-34](https://user-images.githubusercontent.com/85616604/196155375-4e577319-6fcb-4c9b-ad6a-c714274004ed.png)

    - ![6](https://user-images.githubusercontent.com/85616604/196155163-fa18ebf4-4ae2-4ef3-bcc9-5c8fee6f6285.png)

## Note
    - IF you see io.jaegertracing.internal.exceptions.SenderException: Failed to flush spans. then open terminal and remove the container via following           cmd
        docker stop <Container_ID>
        docker rm <Container_ID>


