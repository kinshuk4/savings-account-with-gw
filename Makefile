
mvn-build:
	@echo "---> Building maven jars"
	mvn clean package -Dmaven.test.skip

mvn-clean:
	@echo "---> Building maven jars"
	mvn clean package -Dmaven.test.skip
