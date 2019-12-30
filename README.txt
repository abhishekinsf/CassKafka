--------------------------------------------------------------------
Project Title: Spring boot + Cassandra + Kafka to do CRUD Operation
--------------------------------------------------------------------

Tools And Technologies:
-----------------------
.Java 8
.Maven 4.0.0
.Spring Boot 2.0.1.RELEASE
.Cassandra Database 3.11.4
.Zookeeper client 0.10
.Apache Kafka  2.0.0


Installing software in windows
--------------------------------

Cassandra Keyspace and Table Creation:
----------------------------------------------
1. install and run Cassandra db: http://cassandra.apache.org/download/
   open cmd and type cassandra once its started open other cmd and type "cqlsh" then type "use keyspace_name" now cassandra db is connected 

cqlsh> create keyspace "ajavasource" with replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};
cqlsh:ajavasource> create table person (id bigint PRIMARY KEY, name text, age int, salary double);
cqlsh:ajavasource> insert into person (id,age,name,salary) values(3,26,'Vikash', 25000);




Kafka and Zookeeper installation
----------------------------------

Download and install Apache Kafka : https://kafka.apache.org/downloads

Kafka installation comes with an inbuilt zookeeper.

start zookeeper server in new cmd 
-----------------------
command -> C:\kafka_2.12-0.10.2.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

start kafka server in new cmd
------------------------
command -> C:\kafka_2.12-0.10.2.1>.\bin\windows\kafka-server-start.bat .\config\server.properties

open new cmd and create a topic with this command
-------------------------------------------------------
command -> C:\kafka_2.12-0.10.2.1>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic personInfo




Getting Started with Project Structure
---------------------------------------
1. Download and import the project 
2. clean and build the project 
3. Run DemoApplication.java file


Testing with Rest Api
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Info                              api url                          Request method type          Request                                                        Response
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Getting All Person       : http://localhost:8080/person               Get                 							     [{"id":2,"name":"Mahesh","salary":32000,"age":24},{"id":3,"name":"Vikash","salary":25000,"age":26}]	
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Inserting  Person        : http://localhost:8080/person               Post                {"id": 9,"name": "Rukesh","salary": 54000,"age": 4239}        record inserted
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Getting one Person       : http://localhost:8080/person/{id}          Get                                                                             {"id": 9,"name": "Rukesh","salary": 54000,"age": 4239}
-------------------------------------------------------------------------------------------------------- -----------------------------------------------------------------------------------------------------------------------------------------------------
Updating Specific Person : http://localhost:8080/person/update        Put                 {"id": 9,"name": "Rukesh","salary": 54000,"age": 4239}         record updated
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Deleting Specific Person : http://localhost:8080/person/{id}          Delete                                                                             record deleted  
------------------------------------------------------------- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





































 




