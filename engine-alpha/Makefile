all: format package

build:
	mvn clean
	mvn compile

format:
	mvn formatter:format

package:
	mvn package

test:
	mvn clean
	mvn test

.PHONY: build format package test
