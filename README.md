ASGwrapper-balsa
---------------------

ASGwrapper-balsa is a helper project to abstract from the external tool calls for the Balsa tools.

### Build instructions ###

To build ASGwrapper-balsa, Apache Maven v3 (or later) and the Java Development Kit (JDK) v1.7 (or later) are required.

1. Build [ASGcommon](https://github.com/hpiasg/asgcommon)
2. Build [ASGprotocols](https://github.com/hpiasg/asgprotocols)
3. Execute `mvn clean install -DskipTests`