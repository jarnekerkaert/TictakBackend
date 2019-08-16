# TictakBackend
This repository contains the Spring backend for my [Chords app](https://github.com/HoGentTIN/native-apps-1-android-creative-app-Nuggitz).
It connects to a [MongoDB](https://www.mongodb.com/) backend.

### Install and run
To run this application, first download and install [MongoDB](https://www.mongodb.com/). When finished, you should start the service.
Clone this project and open it your IDE of choice. I personally recommend [IntelliJ](https://www.jetbrains.com/idea/).

MongoDB runs on **localhost:27017** by default. When you run the backend for the first time, it should automatically 
create a new database called tictakdb. If you want to use a different port or database name, you can change this in the 
application.properties file of this project.

The backend itself runs on **localhost:8080**. This is the Spring Boot default.

### Libraries
This backend uses [Swagger 2](https://swagger.io/). When running the application, you can access the documentation at [http://localhost:8080/api/v2/api-docs](http://localhost:8080/api/v2/api-docs)

### Author
* **Jarne Kerkaert** - [jarnekerkaert](https://github.com/jarnekerkaert)
