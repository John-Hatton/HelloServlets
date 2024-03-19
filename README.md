# Hello Servlets

---

### Introduction

This is part of a series of projects I'll be working on to refresh my memory with Java, Gradle, and so on, and the 
beginnings of Java Server Faces (JSF). Java Servlets are Java classes that dynamically process requests and construct 
responses for web applications. Servlets typically run on the server-side and handle HTTP requests from clients, such as
web browsers or mobile apps. They provide a way to generate dynamic content, interact with databases, manage sessions, 
and handle other server-side tasks.

---

### Project Structure


    my-servlet-project/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── mars/
    │   │   │       └── hatton/
    │   │   │           └── servlet/
    │   │   │               └── HelloServlet.java
    │   │   └── webapp/
    │   │       └── WEB-INF/
    │   │           └── web.xml
    │   └── test/
    │       └── java/
    │           └── HelloServletTest.java
    └── build.gradle

---

### Project Dependencies

See build.gradle for more...


We're including:

    providedCompile 'javax.servlet:javax.servlet-api:4.0.1'
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testImplementation 'org.mockito:mockito-core:3.12.4'

---

### Hello Servlet

Our 

