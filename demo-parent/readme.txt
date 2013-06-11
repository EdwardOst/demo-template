demo-parent

Common parent pom for all demo projects.  Should ideally allow to build the project for karaf, tomcat, jetty, or spring by justing changing package type and setting profiles.

Profiles are controlled using file flags in the profiles folder, e.g. spring.profile, tomcat.profile, jetty.profile, karaf.profile,  There is one non-platform profile for logging.

Property file conventions are as follows.  First, there must be a platform property file in the project directory, e.g. springContainer.properties.  This file must follow the convention
of <platform>Container.properties.  In addition, there must be an application properties file following the convention <artifactId>.properties.