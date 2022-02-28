
mvn-build:
	@echo "---> Building maven jars"
	mvn clean package -Dmaven.test.skip

mvn-clean:
	@echo "---> Cleaning maven jars"
	mvn clean
