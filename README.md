# MyPrj
 a website to show my projects

## connect to DB
 This project use ``Ajax`` + ``JDBC`` to fetch data from database.
 First, you need to create your table in database. You can use the ``SQL script`` below:
```
create database prj;
create table `prj`.`status`
(
	status varchar(10) primary key
);
insert into `prj`.`status` values('proceeding');
insert into `prj`.`status` values('finished');
insert into `prj`.`status` values('aborted');

create table `prj`.`list`
(
    no int primary key auto_increment,
    name varchar(20),
    language varchar(50),
    last_update date default '1970-01-01',
    status varchar(10),
    url varchar(100),
    foreign key(status) references `prj`.`status`(status)
);
```
 The default JDBC configuration(jdbcUrl, user, password) is stored in ``conf/bruce.conf``, which isn't uploaded together, so you need to create it, just like this:
```
jdbcUrl=jdbc:mysql://localhost:3306/?characterEncoding=UTF-8&serverTimezone=UTC
user=root
password=root
```
 and change the ``src/main/java/com.bk.prj.dao/ProjectDAO.java``:
```
public ProjectDAO() {
    this.tableName = "`prj`.`list`";
    JdbcUtil.setPropertyFile("./conf/bruce.conf");
}
```
 ``tableName`` is your table name in DB, and you can use ``JdbcUtil.setPropertyFile(String filePath)`` to load your own configuration file path.

## run
 This project runs under Tomcat7. You can also run it under ``tomcat7-maven-plugin``, which needs to add the content below to your maven build settings:
```
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <port>8080</port>
        <path>/</path>
        <uriEncoding>UTF-8</uriEncoding>
    </configuration>
</plugin>
```
 and add ``tomcat7:run`` to ``Command line`` in ``Run/Debug configurations``.
