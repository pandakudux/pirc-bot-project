# Pirc-Bot-Project

This repository contains the files used in the project. 

## Abstract

The goal of this project was to utilize the pirc-bot framework and create an interactive chat-bot using java that accessed the OpenWeatherAPI and one other API of our choosing. The bot has functionality to make calls to both APIs and return relevant information.

The .java files were created by me, both .jar files were supplied by the instructor.

## Running the bot

To run this bot the following files will be required (files can be found in the SourceCode folder):
- MyBotMain.java
- MyBot.java
- gson-2.6.2.jar
- pircbot.jar

For MyBotMain.java and MyBot.java to properly compile, both gson-2.6.2.jar and pircbot.jar must be added to the project as libraries. Once all the code is compiled, simply run MyBotMain.java.

To interact with the bot once it is running, go to https://webchat.freenode.net/ select your user-name, and choose '#pircbot' as the designated channel. Once in the chatroom, simply type commands to interact with the bot.

<p align="center">
  <i>Example Connection</i>
</p>
<p align="center">
  <img src="/assets/chatroom-connection.png" alt="Screenshot of a sample connection to chatroom" title="Sample connection to chatroom" />
</p>

## Commands

**Bolded arguments** are required, *italicized arguments* are optional.

'bye' - causes the bot to leave the chatroom.
>![Example of 'bye' command](/assets/bye-example.png)

'help' - displays all of the bots commands.
>![Example of 'help' command](/assets/help-example.png)

'movie **[movie title]**' - accesses the OMDb API to display information about the given movie title.
>![Example of 'movie' command](/assets/movie-example.png)

'time' - displays the current time (*24-Hour clock format*)
>![Example of 'time' command](/assets/time-example.png)

'weather **[city]** *[country]*' - Displays the current, peak, and trough temperatures of the day in farenheight. City is a required argument while country is optional.
>***NOTICE:** FUNCTION MAY NOT WORK BECAUSE THE OPENWEATHERAPI KEY COULD BE SWITCHED OFF WHEN TESTING. This is due to the fact that Open Weather closes keys lacking recent use. This can be solved by contacting me, or replacing the api key in the code with your own. Key's can be recieved at https://openweathermap.org/api*
>
>![Example of 'weather' command](/assets/weather-example.png)
