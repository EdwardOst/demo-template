demo-template
=============

Provides a sample template that uses the apache platform maven projects.
Note that although provided as apache v2 licensed code, this project is not part
of an Apache Software foundation project.  The "apache platform" just refers to
the fact that the project is intended to compose multiple apache projects into a
logical "platform".

In addition to using the apache-platform, the demo-parent project provides the
folowing additional functionality:

1.  Establish property file conventions.

2.  Provides profiles for different target platforms: 
    spring, tomcat, jetty, karaf

3.  Relates property conventions to the platforms.

4.  Provides profiles for different sets of utilities: 
    logging

The demo-parent is used by the helloworld project which demonstrates connecting
these conventions to spring.xml conventions to allow a consistent approach to
configuring spring in different environments.

