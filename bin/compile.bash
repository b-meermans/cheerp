#!/usr/bin/env bash

# Compile the src folder to a .jar file.

javac src/com/aops/main/AopsMain.java

mkdir -p build
jar cvfm build/AopsApp.jar manifest.txt -C src .

# This only seems to be needed when using CheerpJ 2.x.
# CheerpJ 3.x seems to be able to load a .jar file directly?
# Causes tons of security warnings on MacOS.
# Go to Security panel and keep clicking Allow until it works.
./cheerpj/cheerpjfy.py ./build/AopsApp.jar
