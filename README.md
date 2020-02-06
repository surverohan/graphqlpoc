# spqr-graphql-java-spring-boot-example

Graphql benefits:

1)Avoid Multiple Network Calls/Underfetching and the n+1 problem-->

With REST, we might have a /authors/:id endpoint to fetch an author, then another /authors/:id/posts endpoint to fetch the post of that particular author. Lastly, we could have a /authors/:id/posts/:id/comments endpoint that fetches the comments on the posts. As you can see, we need to make requests to three different endpoints in other to accomplish our scenario above.

With GraphQL, we only need to make a request to one endpoint, say /graphql with the following query:

    {
      author {
        name
        posts {
          title
          comments {
            comment
          }
        }
      }
    }
2) Overfetching: Downloading superfluous data -->
Overfetching means that a client downloads more information than is actually required in the app. Imagine for example a screen that needs to display a list of users only with their names. In a REST API, this app would usually hit the /users endpoint and receive a JSON array with user data. This response however might contain more info about the users that are returned, e.g. their birthdays or addresses - information that is useless for the client because it only needs to display the users’ names.

3)Versioning -->
Often when consuming third-party REST APIs, we see stuff like v1, v2, v3 etc. which simply indicate the version of the REST API we are using. This leads to code redundancy and less maintainable code. With GraphQL, there is no need for versioning as we can easily add new fields and types to our GraphQL API without impacting existing queries. Also, we can easily mark fields as deprecated and the fields will be excluded from the response gotten from the server.

4)Schema & Type System -->
GraphQL uses a strong type system to define the capabilities of an API. All the types that are exposed in an API are written down in a schema using the GraphQL Schema Definition Language (SDL). This schema serves as the contract between the client and the server to define how a client can access the data.

Once the schema is defined, the teams working on frontend and backends can do their work without further communication since they both are aware of the definite structure of the data that’s sent over the network.

Frontend teams can easily test their applications by mocking the required data structures. Once the server is ready, the switch can be flipped for the client apps to load the data from the actual API.

5)Caching -->
Since HTTP already implements caching, and REST is implemented using HTTP, the client can use HTTP caching to avoid refetching resources. GraphQL has no caching mechanism in place, hence leaving the clients with the responsibility of taking care of caching on their end.

And many more


Clone this repo and execute `mvnw spring-boot:run`. Or inside an IDE, execute the class `com.spike.graphql.GraphqlApplication`.


For Documentation/schema or operation defination/testing url
http://localhost:8080/documentation

For end user url 
http://localhost:8080/employee

 Start executing queries.
 For example create employee:
```
mutation{
  createEmployee(employee:{employee_id:2,employee_firstname:"john",employee_lastname:"foo",employee_code:1111 },address:{address_id:2,state:"VA",street_name:"centriville st"}){
    id
    firstName
   lastName
    code
   addressId
  }
}
```
Or create address :
```
mutation{
  createAddress(address:{address_id:2,state:"VA",street_name:"elden st"}){
    id
    state
   streetName
  }
}

```

Or find address:
```
query{
  findAllAddresses{
  id
  state
  streetName  
  }
}
```

Or getAddress:
```
query{
  getAddress(id:1){
     id
  state
  streetName 
  }
}
```
