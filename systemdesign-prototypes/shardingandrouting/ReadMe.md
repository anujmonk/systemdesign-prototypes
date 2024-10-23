http://localhost:8080/users/2 => Request sent to Connection 1 
http://localhost:8080/users/1 => Request sent to Connection 2

Prototype for Database sharding and Routing => We have created 2 shards where data is distributed. We are mimicking the shards by having 2 connections into the same database instance.