## smaple service


Environment Variables
```
export DB_URL=jdbc:oracle:thin:@ldap://eusoud.prod.fedex.com/OCE_DEV_COLO_SVC,cn=OracleContext
export DB_USER=OCE_C2G_APP
export DB_PASSWORD=Nt5mRaxVw#Z4PwRL8RcUqkuTjG5_ck
```

Build
```
mvn clean package
```

Run
```
mvn spring-boot:run
```


Test
```
# execute all test
mvn clean test

# execute one test class
mvn -Dtest=SampleServiceApplicationTests test

# execute one test method
mvn -Dtest=SampleServiceApplicationTests#contextLoads test
```

