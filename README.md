<h1>RestApi Development Studies </h1>
<h2>Introduction</h2>
<p>
  This project was made to apply some skills in the development of REST Apis with SpringBoot, learning the most common architetures properties when developing apis to do some of the http requests in a way that responsibilities get encapsulated and client can consume it with ease.
</p>

<h2>Technologies Used</h2>
<ul>
  <li>Java 21</li>
  <li>SpringBoot 3.2.3 and Maven for dependency management</li> 
  <li>JPA/HIBERNATE - To iterate with the database </li>
  <li>MySQLWorkBench - To run SQL scripts and visualize dataBase state when making changes</li>
  <li>Postman - To make the tests when making CRUD requests</li>
</ul>

<h2>Packages Summaries</h2>

<h3>1.0. CrudDemmoApplication </h3>
<p>
    <strong>Description:</strong> This class works as the default initializer for the api, handling beans creations and setting the localserver live.
</p>

<h3>2.0. Entity </h3>
<p>
    <strong>Description:</strong> Have the Entity class to relation database table to Employee object and his columns to object fields, also managing the primaryKey of Employee ID.
</p>

<h3>3.0. DAO </h3>
<p>
    <strong>Description:</strong> Has the DAO and DAOImpl to manage repository responsability when dealing with the dataBase.
</p>
<p>
    <strong>Summary:</strong> Encapsulates the Jpa/Hibernate Methods when performing dataBase changes using the 'EntityManager' methods provided.
</p>

<h3>4.0. Service </h3>
<p>
    <strong>Description:</strong> Deal with bussines logic and transactions when performing the DAO methods.
</p>

<h3>5.0. Rest </h3>
<p>
    <strong>Description:</strong> Has the restController of api to deal with client-side iteration.
</p>
<p>
 <strong>Summary:</strong> Expose the end-points to be accessible when consuming the api and implements the CRUD methods by calling the service layer to perform transactions.
</p>
 
 <h3>5.0. ExceptionHandler </h3>
<p>
    <strong>Description:</strong> Manage exceptions that can happen globally in the code providing client with more clear responses of what went wrong, a AOP concept to handle issues.
</p>
