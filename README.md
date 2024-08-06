# Rock-Paper-Scissors Game

## Overview

This prject contains a simple implementation of the Rock-Paper-Scissors game where a player plays against the computer. The game allows the player to choose between three gestures (Rock, Paper, Scissors) and plays a series of rounds until the player decides to exit.

## Project Structure

The project is organized into the following packages:

- `com.suganya.rockpaperscissors.model`: Contains enums and interfaces representing game gestures and players.
- `com.suganya.rockpaperscissors.factory`: Contains the `GestureFactory` class for creating gesture instances.
- `com.suganya.rockpaperscissors.game`: Contains the `Game` class which handles the game logic.

## Requirements

- Java Development Kit (JDK) 17 or higher is required to compile and run the code.

## Usage
1. Start the Game:
   - Run the GameMain class. 

2. Choose a Gesture:
   - Enter 1 for Rock
   - Enter 2 for Paper
   - Enter 3 for Scissors
   - Enter 4 to Exit the Game
   
3. Game Flow:
   - The game will display the player’s and computer’s gestures for each round.
   - Scores will be updated and displayed after each round.
   - At the end of the game, the final scores and the winner will be shown.