//Task5.3 Write a maven command for executing one of your tasks with arguments (number of elements).

mvn clean install exec:java -Dexec.mainClass="task5.Task5Stream" -Dexec.args="6"
