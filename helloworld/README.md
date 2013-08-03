Purpose
-------
This simple example aims to demonstrate a basic ESB example using CXF and Camel.
It deploys a basic web service that utilizes TESB infrastructure such as the
Service Locator and Service Activity Monitor in a flexible virtual service 
container which can run in any java environment.  It also demonstrates loose
coupling to the TESB platform using the apache-platform maven projects so that
it is simple to upgrade (or downgrade) from one version of Talend to another.

Install and Deploy
------------------
To build

    > mvn clean install

To deploy

    karaf> features:addurl mvn:com.talend.se.demo/helloworld/5.2.2/xml/features
    karaf> features:install helloworld

To run in a simple jvm with camel during interactive integration tests use
camel:run

    > mvn camel:run

Multi-Container
---------------

This sample file should be easily deployed to any target container including

- [ ] spring jvm
- [x] karaf
- [x] tomcat
- [ ] jetty
- [ ] weblogic
- [ ] websphere
- [ ] jboss

Which target is used is controlled via maven profiles which controlled by flag
files in the profiles directory.  Only one of the corresponding profiles should
be enabled.  All others should be disabled.  To enable a flag file, just end it
with .profile.  To disable a flag file append .disabled to the file name.

Ports
-----

The property files have defaults for ports that allow the different build
targets to coexist.

* Unit Test (Spring): http://localhost:8070/helloworld
* Karaf:  http://localhost:9091/helloworld
* Tomcat: http://localhost:8080/helloworld/helloworld


Service Locator and Service Activity Monitor
--------------------------------------------

The build files include alternate spring xml configuration to allow support for
the appropriate imports for the service locator whether used in a Spring JVM,
karaf, or tomcat.  The application beans are layered into business 
logic (beans), container, and integrate files.  The container file is then
selected dynamically via maven when a karaf profile is selected.


Property Files
--------------

This example also demonstrates flexible use of property files integrated with
the Spring and Camel property placeholders as well as the Karaf config-admin
service.  The approach taken is to aggregate the layered properties files into a
single PropertiesFactoryBean which is then referenced from the Camel property
placeholder.  This allows a single consistent environment property injection
environment to be applied to both spring beans and camel routes.

Talend Apache Platform
----------------------

This pom depends on the demo-parent project which in turn imports a pair of
apache-platform pom's for dependencyManagement.  This encapsulates and provides
a single point of control for Talend dependencies.  Note that the "apache
platform" just refers to the fact that the project is intended to compose
multiple apache projects into a logical "platform".  It is not an Apache
community project although it is apachev2 licensed.