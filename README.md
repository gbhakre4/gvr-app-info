# gvr-app-info
Software installation Requisits
1) Java 1.8
2) Maven
3) Heroku Cli.executor
4) Eclipse.

Consists of app-info-service which gives information about application having method 
returns Json string containing number of calls made with current timestamp.

Build and Deploy the application -
1. Run the cmd and generate the Heroku key using heroku auth:token command.
2. Please find reference to Deploy the war in heroku application using eclipse
   https://devcenter.heroku.com/articles/deploying-java-applications-to-heroku-from-eclipse-or-intellij-idea
3. Open your application by browsing to http://<app-name>.herokuapp.com/app-info-service/get-current-hits
   (replace <app-name with the name of your app).
   

