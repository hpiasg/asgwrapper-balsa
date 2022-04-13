ASGwrapper-balsa
----------------

ASGwrapper-balsa is a library helping to abstract calling tools from the [Balsa](http://apt.cs.manchester.ac.uk/projects/tools/balsa/) suite.

It supports
* Balsa-c v4.0
* Balsa-netlist v4.0

We'd like to thank all the people involved in development of Balsa for their excellent work. Because Balsa is free software, it is included in this release.

### Build instructions ###

To build ASGwrapper-balsa, Apache Maven v3.1.1 (or later) and the Java Development Kit (JDK) v1.8 (or later) are required.

1. Build [ASGcommon](https://github.com/hpiasg/asgcommon)
2. Build [ASGprotocols](https://github.com/hpiasg/asgprotocols)
3. Execute `mvn clean install -DskipTests`