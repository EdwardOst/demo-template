Purpose
-------
This simple example demonstrates a pluggable pojo OSGI service using Blueprint running in Apache Karaf.
The code is taken from the Apache Aries [helloworld sample][aries-example].

Install and Deploy
------------------
Build the source using maven

    > mvn clean install

If necessary deploy from the local maven repository to a nexus server.

    > mvn deploy

Deploy api, server, and client bundles to a Karaf instance

    karaf> install mvn:org.apache.aries.samples.blueprint.helloworld/org.apache.aries.samples.blueprint.helloworld.api/1.0.0
    karaf> install mvn:org.apache.aries.samples.blueprint.helloworld/org.apache.aries.samples.blueprint.helloworld.server/1.0.0
    karaf> install mvn:org.apache.aries.samples.blueprint.helloworld/org.apache.aries.samples.blueprint.helloworld.server_2/1.0.0
    karaf> install mvn:org.apache.aries.samples.blueprint.helloworld/org.apache.aries.samples.blueprint.helloworld.client/1.0.0

The bundles have now been deployed, but not started.

    karaf@trun> list | grep -i hello
    [ 368] [Active     ] [            ] [Started] [   80] se-demo :: helloworld (5.4.1.SNAPSHOT)
    [ 396] [Installed  ] [            ] [       ] [   80] Apache Aries Blueprint HelloWorld API (1.0.0)
    [ 397] [Installed  ] [            ] [       ] [   80] Apache Aries Blueprint HelloWorldServer (1.0.0)
    [ 398] [Installed  ] [            ] [       ] [   80] Apache Aries Blueprint HelloWorldServer_2 (1.0.0)
    [ 399] [Installed  ] [            ] [       ] [   80] Apache Aries Blueprint HelloWorldClient (1.0.0)

Start the Server bundle and then the client bundle using the bundleId.

    karaf@trun> start 397
    ======>>> Starting HelloWorld Server
    karaf@trun> start 399
    ========>>>>Client HelloWorld: About to execute a method from the Hello World service
    ======>>> A message from the server: Hello World!
    ========>>>>Client HelloWorld: ... if you didn't just see a Hello World message something went wrong

Stop the HelloWorldServer and then start the HelloWorldServer_2.

    karaf@trun> stop 397
    karaf@trun> start 398
    ======>>> Starting SERVER 2
    karaf@trun> stop 399
    karaf@trun> start 399
    ========>>>>Client HelloWorld: About to execute a method from the Hello World service
    ======>>> SERVER 2
    ========>>>>Client HelloWorld: ... if you didn't just see a Hello World message something went wrong

Note that the message returned by the new server has changed.
Nothing dramatic, just dependency injection in action.
But there are some other advantages to using OSGI services.
In this example we had to restart the client to demonstrate that the new service had been plugged in.
OSGI services provide dynamic services so that when services are unplugged and new realizations plugged in, clients are not affected.

[aries-example]: http://aries.apache.org/documentation/tutorials/blueprinthelloworldtutorial.html