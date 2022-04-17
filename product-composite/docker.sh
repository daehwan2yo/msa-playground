
docker build -t product-composite:1.0 .

docker run --rm -d -p 8080:8080 product-composite
