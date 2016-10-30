# **Administration Manual**

Our application is hosted on an open repository on github.com https://github.com/TheA-Team/TicTacToe.git. 
You will need to have jdk 1.8 installed on your machine in order to run this application.


You can go to the url above and download a zip file containing the application
Or you can clone the repository to your computer by running the command below from the console:


git clone https://github.com/TheA-Team/TicTacToe.git


After cloning the repository or download the zip folder and unzipping it to your machine you will need to run the following command from the root folder of your repository.
For osx and linux:
```
./gradlew installApp
```
For Windows:
```
Gradlew installApp
```
Upon receiving a message from the command line prompting you of an successful install you will need to run the following script which is located at:
For osx and linux users:
```
*project root*/build/install/TicTacToe/bin/TicTacToe
```
For Windows users:
```
*project root*/build/install/TicTacToe/bin/TicTacToe
```


This will run the application as a localhost server on the following url:
```
http://localhost:1337
```
You are now able to go to this address and play our TicTacToe application.
```
https://svansea.herokuapp.com/
```


Heroku Deployment


To deploy the application you need the heroku toolbelt https://toolbelt.heroku.com/ and a heroku account.
To begin you need to clone the git repository and then you need to run the following commands from the console in the root of the project.
Heroku login
Heroku create appname


Where appname is what you want your heroku app to be called. You can skip this and heroku will provide you with a random name.
```
./gradlew installApp (for *nix)
Gradlew installApp (for windows)
```


And then you run this command to push everything to heroku
Git push heroku master.  
