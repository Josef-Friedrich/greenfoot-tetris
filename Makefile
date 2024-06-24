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

doc:
	rm -rf target/site/apidocs
	mvn javadoc:javadoc
	xdg-open target/site/apidocs/index.html

.PHONY: doc build format package test
