#!/bin/bash
java -jar TGBotApp.jar &        # You send it in background
MyPID=$!                        # You sign it's PID
echo "my pid is: $MyPID"                     # You print to terminal
echo "kill $MyPID" > ominibotStop.sh  # Write the the command kill pid in MyStop.sh