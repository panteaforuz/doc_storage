project automatically configures DataSource for in-memory databases .For using the MySQL database,just add the database connection properties to the properties file.
# MySQL connection properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root  #set the user name here
spring.datasource.password=mypass  #set the password here
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?createDatabaseIfNotExist=true&useSSL=false  #set your address here
# Log JPA queries
# Comment this in production
spring.jpa.show-sql=true
# Drop and create new tables (create, create-drop, validate, update)
# Only for testing purpose - comment this in production
spring.jpa.hibernate.ddl-auto=create
# Hibernate SQL dialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
