# Technical Test

## Flexera Engineering Candidate Technical Test

#### Test Instructions

> Create a web API that allows you to add, update and remove people from a data store.

### Instructions

#### Endpoints:
* /app/people
* /app/people/{name}
* /app/people/create
* /app/people/delete/{name}

For example,
> `curl -X GET http://localhost:8080/app/people`

will return a list of all people in the database.  Whereas,

> `curl -X GET http://localhost:8080/app/people/steve%20rogers`

will return a list of people with the name "Steve Rogers" only.

The **.../create** method will take a JSON formatted string and add that person to the database.
Duplicate names are allowed, but if the person object already exists, a duplicate will not be added.

The **.../delete/{name}** method takes a single name and deletes that person (or all people matching that
 name) from the database.

As I was informed that the front end element was not required, I worked only on the backend process.
I did however add a simple html file to list (GET) all records, and to delete a record.

### REST API

I have written the REST API in Java using SpringBoot.  I have added some enhancements, but there is room
 for the project to grow.  At present I have only added the capability for a single person to be added at
  a time.  However, given more time, this could be easily modified to parse multiple people.

### Data Store

Initially I developed and tested the project using the in-memory **h2** database.  Using the Spring
 framework, this can be easily switched to a production database.  Once most of the work was complete, I
  created a MySQL database locally and added the properties to the application.properties file to test.
