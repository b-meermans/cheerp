# How to Run CheerpJ 3

1.  You need JDK 8 installed.
2.  You need to be able to run a web server (Live Server on VS Code).
3.  Compile the Java then build into a Jar. The jar file needs to be compiled with JDK8. 
```
# compile
javac -d build src/**/*.java

# Added this one in to make the images directory be copied to the build folder - they weren't appearing in the jar
rsync -a src/images build

# make the jar
jar cvfm build/AopsApp.jar manifest.txt -C build .
```

4.  Right click `index.html` in VS Code and select `Open with Live Server`. 
It should open a browser window with your app running at `http://127.0.0.1:5500/index.html`
