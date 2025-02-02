# GraphQL with Java

### GraphQL vs REST
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

### Setup
Maven dependencies: spring-boot-starter-graphql, spring-boot-starter-web.

