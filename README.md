# GraphQL with Java

## GraphQL vs REST
- Developed by Meta.
- Used for API data fetching.
- Efficient data fetching.
- Strogly typed schema.
- No need for API versioning api/v1/customers, api/v2/customers.
- In graphQL, the client defines the structure while in RESTm the server defines the structure.
- Avoids over-fetching and under-fetching.
- GraphQL uses a single endpoint, while REST provides multiple endpoints (customers, users, transactions).
- GraphQL doe not need versioning while it's needed in REST.
- Minimal payload (only requested data). REST provides fixed payload and may include unnecessary data.
- Highly flexible.
- Efficient in reducitng network requests.
- Complex error handling compared to REST.

## Setup
Maven dependencies: spring-boot-starter-graphql, spring-boot-starter-web.
Create a file called schema.graphqls under resources/graphql

## Schema
A file containing the kind of objects that you can fetch from your service including its fields.

### The Query Type
```
// The Query type is a special object type that defines all of the top-level
// entry points for queries that clients execute against your server.
// Each field of the Query type defines the name and return type of a different entry point.
type Query {
  bookById: String
  books: [Book]
  authors: [Author]
}

// Based on our example schema so far, a client could execute the following query,
// which requests both a list of all book titles and a list of all author names:
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
```
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

###
```
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
