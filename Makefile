all: format package

install_scripts:
	sudo cp resources/graphics/gameboyify.sh /usr/local/bin/gameboyify
	sudo chmod a+x /usr/local/bin/gameboyify

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
