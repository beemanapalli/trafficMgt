+------------------------------------------------------------------------------------------+
Requirements:
+------------------------------------------------------------------------------------------+
Required:
java1.8
maven 3.5.3

+------------------------------------------------------------------------------------------+
Environment Setup
+------------------------------------------------------------------------------------------+
1.Download maven: https://maven.apache.org/download.cgi
(apache-maven-3.5.3-bin.zip)
2.Extract to your desired location
3.Set Maven home in windows environment variables:
   under System variables: variable name: MAVEN_HOME
                           variable value: <absolute path of apache-maven-3.5.3>
4.Edit path variable unser System variables:
  append to existing path variable: %MAVEN_HOME%\bin

Test environment:
1.From DOS Command prompt type: mvn --version
2.It should give maven and java details.
  ex:
  Apache Maven 3.0.5 (r01de14724cdef164cd33c7c8c2fe155faf9602da; 2013-02-19 14:51:28+0100)
	Maven home: D:\apache-maven-3.0.5\bin\..
	Java version: 1.6.0_25, vendor: Sun Microsystems Inc.
	Java home: C:\Program Files\Java\jdk1.6.0_25\jre
	Default locale: nl_NL, platform encoding: Cp1252
	OS name: "windows 7", version: "6.1", arch: "amd64", family: "windows"

+------------------------------------------------------------------------------------------+
Running the App: with Source Code
+------------------------------------------------------------------------------------------+
1. Download , extract and save the app folder to  your desired location
2. Go to root folder of the application  	-->\traffic-ctrl-app
3. run: mvn package
4. run: java -cp target/traffic-ctrl-app-1.0-SNAPSHOT.jar org.traffic.mgt.SignalMgt

5. Enter no.of seconds your app need to run i.e iterations
   ex: Please Entere Time in Seconds here -----------> 10 --> will run for 10 iterations , can be considered as 10 seconds.
  
+------------------------------------------------------------------------------------------+
Running the App:: with executable JAR
+------------------------------------------------------------------------------------------+
  1. copy the jar to your desired location
  2. in command prompt, go to the JAR located folder.
  3. run the command: java -cp traffic-ctrl-app-1.0-SNAPSHOT.jar org.traffic.mgt.SignalMgt