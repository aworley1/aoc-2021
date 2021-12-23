#!/usr/bin/env bash

day_num=$1
export DAY_NAME="Day$day_num"
export DAY_DIR="day$day_num"

mkdir src/main/kotlin/$DAY_DIR
envsubst < template/Daykt > src/main/kotlin/$DAY_DIR/${DAY_NAME}.kt
touch src/main/kotlin/$DAY_DIR/${DAY_NAME}.txt src/main/kotlin/$DAY_DIR/${DAY_NAME}_test.txt