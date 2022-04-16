# !/bin/bash

java -jar ./product-composite/build/libs/product-composite-0.0.1-SNAPSHOT.jar & \
java -jar ./product/build/libs/product-0.0.1-SNAPSHOT.jar & \
java -jar ./review/build/libs/review-0.0.1-SNAPSHOT.jar & \
java -jar ./recommendation/build/libs/recommendation-0.0.1-SNAPSHOT.jar & 
