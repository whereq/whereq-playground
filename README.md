## WhereQ Playground
Sample spring boot service project



## Sprint Boot Project Structure
```
com
 +- whereq
     +- myapp
         +- MyApplication.java
         |
         +- config
         +- controller
         +- exception
         +- model
                +- value
                +- entity
                +- enums
                +- constant
         |
         +- repository 
         +- service
         +- util
         |
         +- client
```

## Sprint Boot Project Principles

Follow SOLID design principles. SOLID is a mnemonic acronym for five design principles intended to make object-oriented designs more understandable, flexible, and maintainable.

#### 1. Database Layer: entity and repository packages
Entity and Repository should not import any classes from other layers.

#### 2. Service Layer: value and service packages
Service should only import classes from service and database layers.

#### 3. Controller Layer: controller package
Controller can only use classes from service

#### 4. Model: model package
All Value classes should be POJO.
Model classes under different layers should be converted by MapStruct.

#### 5. Utility: util package
Singleton stateless class. 

- static method with a private constructor (preferred)
 
#### 6. Lint: Fix all lint errors before commit your code

#### 7. Test
- All services require unit test for each public method (mandatory)
- All repository requires unit test for CRUD (optional)

## Database Layer

### Entity
All entities should be inherited from BaseEntity or AuditableEntity.

BaseEntity provides createdById and createdEpochNbr attributes, which are open for creation and closed for update. BaseEntity attributes are managed by framework. 

AuditableEntity provides updatedById, updatedEpochNbr and versionNbr attributes, which are closed for creation and open for update. AuditableEntity attributes are managed by framework. 

### Repository

For any entity extends AuditableEntity, the Repository should extend from AuditableRepository, which provides below functions:

- convert delete() method to version attribute update
- add version > 0 to findAll() 

### Generic Audit

For any AuditableEntity with @Audit annotation, framework will automatically log entity changes in entity_audit table.

### Lazy load entity attribute
Entity
```
    @Lob 	
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ENTITY_JSON")
    protected String entityJson;
```
pom.xml
```
<plugin>
    <groupId>org.hibernate.orm.tooling</groupId>
    <artifactId>hibernate-enhance-maven-plugin</artifactId>
    <executions>
        <execution>
            <configuration>
                <failOnError>true</failOnError>
                <enableLazyInitialization>true</enableLazyInitialization>
            </configuration>
            <goals>
                <goal>enhance</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

application.yml
```
spring:
    jpa:
        properties:
            "[hibernate.show_sql]": true
            "[hibernate.format_sql]": true
            "[hibernate.enable_lazy_load_no_trans]": true
```

## Service Layer

### MapStruct
Use mapstruct to covert beans between entity and value.

- entity to value
    - single entity to value: map all attributes, a base for other mappings
        <br> Sample: Ticket getTicket(id)

    - collection of entity to value: ignore lazy load and unused attribute
        <br> Sample: List<Ticket> getAllTickets()

- value to entity: ignore createdByEpoch, updatedByEpoch, versionNbr
    - new entity: ignore id, updatedById, and other system generated attribute
        <br> Sample: Ticket createTicket(Ticket ticket)

    - update entity: patching input ticket
        <br> Sample: Ticket updateTicket(Ticket ticket)

- always verify generated source code

### Controller Layer
- HTTP / REST / JSON
- Controllers should be stateless. 
- Controllers should not execute business logic but rely on delegation(service).
- Controllers should be stateless. 

### Exception

Use Springboot default exception handler with error message included.
```
server.error.include-message: always
```

- throw any java exception will return HTTP 500 error

```
repo.findById(ticket.getId()).orElseThrow(() -> 
    new IllegalArgumentException("invalid ticket id " + ticket.getId()))

{
    "timestamp": "2023-02-02T17:26:39.396+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "invalid ticket id 2131231",
    "path": "/tickets/"
}
            
```

- throw error with specific HTTP error code
```
new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket Not Found " + id);

{
    "timestamp": "2023-02-02T17:08:39.522+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Ticket Not Found 123123",
    "path": "/tickets/123123"
}

```

### Logging

All controllers and services will be logged by framework.

pom.xml
```
<dependency>
    <groupId>com.whereq.common</groupId>
    <artifactId>whereq-common-utils</artifactId>
    <version>3.0-SNAPSHOT</version>
</dependency>
```

application.java
```
@ComponentScan(value = {"com.whereq.common.log"})
```

sample log
```
2023-02-02 14:57:49.790  INFO com.whereq.common.log.ControllerFilter    :  --> [CALL]: GET by:(workshop) /tickets/10143:
2023-02-02 14:57:49.866  INFO com.whereq.common.log.LogAspect           : -> TicketController.getTicket args:[String(workshop),Long(10143)]
2023-02-02 14:57:49.923  INFO com.whereq.common.log.LogAspect           : -> TicketService.getTicket args:[Long(10143)]
2023-02-02 14:57:50.477  INFO com.whereq.common.log.LogAspect           : <- TicketService.getTicket args:[Long(10143)] 553ms return:[Optional(Optional:Optional[Ticket(id=10143, title=test ticket - 1675190238094, detail=test ticket creation by service,..)]
2023-02-02 14:57:50.485  INFO com.whereq.common.log.LogAspect           : <- TicketController.getTicket args:[String(workshop),Long(10143)] 619ms return:[ResponseEntity(Ticket(Ticket:Ticket(id=10143, title=test ticket - 1675190238094, detail=test ticket creation by service, props=nu..))]
2023-02-02 14:57:50.649  INFO com.whereq.common.log.ControllerFilter    :  <---[CALL] :GET 200 OK by:(workshop) /tickets/10143: ------- (861ms)
```

### Version

- Springboot 2.7.6


### Security
Furture
```
@PreAuthorize("permitAll()")
@PreAuthorize("isAuthenticated()") 
@PreAuthorize("hasAuthority('Admin')")
@PreAuthorize("hasRole('user')")
```


