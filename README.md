# Pirc-Bot-project

This repository contains the files I used and wrote to create an interactive chat-bot project. 

## Abstract

The goal of this project was to utilize the pirc-bot framework and create an interactive chat-bot in java that accessed the OpenWeatherAPI and one other API of our choosing. The bot should have functionality to make calls to both API and return relevant information.

## Running the bot

To run this bot the following files will be required (.java files can be found in the SourceCode folder):
- MyBotMain.java
- MyBot.java
- gson-2.6.2.jar
- pircbot.jar

For MyBotMain.java and MyBot.java to properly compile, both gson-2.6.2.jar and pircbot.jar must be added to the project as libraries. Once all the code is compiled, simply run MyBotMain.java.

To interact with the bot once it is running, go to https://webchat.freenode.net/ select your user-name, and choose '#pircbot' as the designated channel. Once in the chatroom, simply type commands to interact with the bot.

## Commands

'bye' - causes the bot to leave the chatroom.

'help' - displays all of the bots commands.

'movie [Movie Title]' - accesses the IMDB API to display information about the given movie title.

'time' - displays the current time in 

'weather [city] [country]' - Displays the current, peak, and trough temperatures of the day in farenheight. City is a required argument while country is optional.
