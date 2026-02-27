# ForgeLite 

Minimal Java Swing game demonstrating state-driven UI, animation, and rendering

## Overview

ForgeLite is a small, self-contained Java Swing application implementing a complete gameplay loop with animated progress, XP tracking, and a win condition.

The project focuses on disciplined scope, clean state management, and proper separation between logic and rendering.

## Core Concepts Demonstrated

Event-driven architecture using Swing components

Custom rendering via paintComponent(Graphics)

Animation using javax.swing.Timer

State-driven UI updates (repaint() lifecycle)

Defensive rendering with value clamping

Controlled state transitions (isForging, hasWon)

UI locking on terminal state

## Gameplay Flow

Mine ore (probabilistic success)

Smelt ore into ingots

Forge swords with animated progress bar

Gain XP per successful forge

Win at 50 XP (UI disables further interaction)

## Technical Notes

Layout composed using BorderLayout with dedicated rendering panel

Rendering logic isolated to CanvasPanel

Timer lifecycle explicitly managed (start/stop/reset)

UI state protected against invalid transitions

## Run

Compile and run:

Main.java

Java 8+
