# transactions

Sample java service for transaction data by Cory L.

## Build and Run

First, ensure Tomcat is not running in your IDE and not started manually. 
1. Run "mvn package" at a command line.
    1. mvn should be in your path.
    2. this will create the .war file in "target" folder. 
2. Copy the .war file to your Tomcat 8 server.  "webapps" folder. 
3. Start Tomcat. From the <tomcat home>/bin folder
    1. On Windows: run "startup.bat".  JAVA_HOME and/or JRE_HOME env variables should be setup first. 
    2. On *nix:  run startup.sh
4. Assuming default Tomcat port, in your browser, navigate to http://localhost:8080/transactions-1.0-SNAPSHOT/transactions

## API Methods
http://localhost:8080/transactions-1.0-SNAPSHOT/transactions

http://localhost:8080/transactions-1.0-SNAPSHOT/transactions/type/SEPA

http://localhost:8080/transactions-1.0-SNAPSHOT/transactions/type/SEPA/total
