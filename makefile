DIR=${PWD}
ASST=$(notdir ${DIR})
JAVAFILES=$(wildcard src/main/java/edu/odu/cs/cs350/pne/*.java)
CLASSFILES=$(JAVAFILES:%.java=%.class)

compile: $(CLASSFILES)

%.class: %.java
	javac -cp 'src/main/java:lib/*' $*.java

clean:
	rm src/main/java/edu/odu/cs/cs350/pne/*.class

STANDALONE=$(wildcard lib/junit-platform-console-standalone-*.jar)
JARS=$(wildcard lib/*.jar)
CPATH=$(shell echo lib/*.jar | tr ' ' ':')

test: compile
	java -jar $(STANDALONE)  -cp 'src/main/java:$(CPATH)' -c edu.odu.cs.cs350.pne.TestSemester

