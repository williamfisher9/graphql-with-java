# GraphQL with Java

## GraphQL vs REST
- Developed by Meta.
- Used for API data fetching.
- Efficient data fetching.
- Strongly typed schema.
- No need for API versioning api/v1/customers, api/v2/customers.
- In graphQL, the client defines the structure while in RESTm the server defines the structure.
- Avoids over-fetching and under-fetching.
- GraphQL uses a single endpoint, while REST provides multiple endpoints (customers, users, transactions).
- GraphQL does not need versioning while it's needed in REST.
- Minimal payload (only requested data). REST provides fixed payload and may include unnecessary data.
- Highly flexible.
- Efficient in reducing network requests.
- Complex error handling compared to REST.

## Setup
Maven dependencies: spring-boot-starter-graphql, spring-boot-starter-web.

Create a file called schema.graphqls under resources/graphql

## Schema
A file containing the kind of objects that you can fetch from your service including its fields.

### The Query Type
The Query type is a special object type that defines all the top-level entry points for queries that clients execute against your server.

Each field of the Query type defines the name and the return type of different entry points.

```schema.graphqls
type Query {
  bookById: String
  books: [Book]
  authors: [Author]
}

query GetBooksAndAuthors {
  books {
    title
  }
  authors {
    name
  }
}

query GetBooks {
  books {
    title
    author {
      name
    }
  }
```

### The Mutation Type
The Query type defines entry points for read operations, the Mutation type defines entry points for write operations.
```schema.graphqls
type Mutation {
  addBook(title: String, author: String): Book
}

mutation CreateBook {
  addBook(title: "Fox in Socks", author: "Dr. Seuss") {
    title
    author {
      name
    }
  }
}
```

### Types (Object)
```schema.graphqls
type Book {
  id: ID
  name: String
  pageCount: Int
  author: Author
}

type Author {
  id: ID
  firstName: String
  lastName: String
}
```

### Controller Class
In the controller, the name of the method should match the name of the endpoint in the Query type.

@QueryMapping  annotation in the controller maps the method name to the type in the graphql schema.

### application.properties
To enable GraphQL in Spring Boot:

```application.properties
spring.graphql.graphiql.enabled=true
```

To use GraphQL from the browser: http://localhost:8080/graphiql

In Graphiql you can use the queries defined in the Query:
```graphicl.graphicl
  {
    books {
      name
      pageCount
      id
    }
  }

  {
    bookById(id: "book-1") {
        id
        name
      }
  }
```

@SchemaMapping is used to get an object from another object that is mapped to it.

You can also send multiple queries in the same request as in the above example.

### Postman
To test the endpoints from Postman:
- Start postman
- File -> New -> GraphQL
- Send the request to the path specified in application.properties which defaults to /graphql
  ```
    http://localhost:8080/graphql
  ```
- In application.properties if spring.graphql.path is set, then use the new path:
  ```
    spring.graphql.path=/api/graphql
  
    http://localhost:8080/api/graphql
  ```

- In React, you can use axios to send POST request to qraphql endpoint with request body as JSON containing:
  ```dtd
  {
      operationName: "fetchAllBuildingInfo",
      query: `query fetchAllBuildingInfo ${AllBuildingQuery}`,
      variables: {}
  }
  ```