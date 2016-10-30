# **Development manual**

Our application is hosted on an open repository on github.com https://github.com/TheA-Team/TicTacToe.git. You will need to have jdk 1.8 installed on your machine in order to run this application.
You can clone the repository to your computer by running this command from the console:

```
git clone https://github.com/TheA-Team/TicTacToe.git
```


Or you can go to the url above and download a zip file containing the application.
The workflow is based on everyone having their own branch and push it to DeveloperBranch, there the code is revived. If the code passes the review and the tests on travis, DeveloperBranch is merged with master branch.
If you make changes to the code, run gradle check (compiles and runs all unit tests) by writing either:

```
./gradlew check (for *nix)
gradlw (for windows)
```

1. If you see “Build successful” on the screen you should commit your changes and push them too DeveloperBranch.
2. Then go to github and create a pull request. Then someone on your team must review your changes and see if the tests passes on Travis before changes are merged with master branch.
3. You don’t need gradle to build the project, the gradle wrapper (“./gradlew”) contains all the necessary commands you need. But you do need jdk 8 (java development kit). You can build the project by running either of the following commands on the command line:

```
./gradlew build (for *nix)
gradlew build (for windows)
```