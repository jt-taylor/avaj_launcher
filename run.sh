#!/bin/sh
#for this project we have to compile in this manner
find . -name "*.java" > sources.txt
javac -g -sourcepath . @sources.txt
# and to actually run the main
java launcher.Simulator scenario.txt
