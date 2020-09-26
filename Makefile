all: clean build run

.PHONY: clean build run cb br

clean:
	./gradlew --stop
	./gradlew clean

build:
	./gradlew build

run:
	./gradlew runClient

cb: clean build

br: build run
