cd common-security
mvn clean install
cd ..

cd user-service
mvn clean package
cd ..

cd point-service
mvn clean package
cd ..

docker-compose build
docker-compose up