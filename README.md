# fizz-buzz
FizzBuzz as a Service, Demonstrating use of a design pattern.  Chain of Responsibility is
used.

Implemented using [Spring Boot](https://projects.spring.io/spring-boot/)

### EndPoint /fizzbuzz/{number}
* expects {number} for upperbound for fizzbuzz
* response is a JSON dictionary of arrays.
* **Example request** : localhost:8080/fizzbuzz/32
* **Example Response** : {"FizzBuzz":[15,30],"Fizz":[3,6,9,12,18,21,24,27],"Buzz":[5,10,20,25]}


### Build command
Build with Maven standard commands. "mvn package" , "mvn install" if you would like to add it to your local repo.

#### Build artifact
Build will produce a standalone jar in the target directory "bbelanger-fizz-buzz-1.0.jar"

### Run command
Execute the standalone "java -jar target/bbelanger-fizz-buzz-1.0.jar" will start the service running on localhost:8080

If you desire a different port specify the JVM option "java -jar -Dserver.port=8090 target/bbelanger-fizz-buzz-1.0.jar"


## Helpful Scripts
1. **buildAndRun.sh**  : builds and starts the service with default port 8080
2. **smokeTest.sh** _host_ _port_ : will execute crude smoke test and display number of Passed and Failed tests pointing to _host_ _port_
