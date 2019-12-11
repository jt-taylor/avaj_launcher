#!/bin/sh
#for this project we have to compile in this manner
find . -name "*.java" > sources.txt
javac -g -sourcepath . @sources.txt

java launcher.Simulator test_emptyfile.txt
echo "Exceptions from test_empty_file.txt >>"
cat exceptions1.txt
echo "\n"

java launcher.Simulator test_sim_of_0.txt
echo "Exceptions from test_sim_of_0.txt >>"
cat exceptions1.txt
echo "\n"

java launcher.Simulator test_missing_aircraft.txt
echo "Exceptions from test_missing_aircraft.txt >>"
cat exceptions1.txt
echo "\n"

java launcher.Simulator test_malformed_aircraft_in.txt
echo "Exceptions from test_malformed_aircraft_in.txt >>"
cat exceptions1.txt
echo "\n"
