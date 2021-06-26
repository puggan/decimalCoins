all: clean build run

.PHONY: clean build run cb br reset rebuild

clean:
	./gradlew --stop
	./gradlew clean

build:
	./gradlew build

reset:
	./gradlew --refresh-dependencies genSources

run:
	./gradlew runClient

cb: clean build

br: build run

rebuild: clean reset build
