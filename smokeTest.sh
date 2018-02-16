#!/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32 m'
BLUE='\033[0;34 m'
YELLOW='\033[1;33 m'
NC='\033[0m' # No Color

usage() {
  echo " "
	echo "This script runs a quick smoke test on the FizzBuzz Service."
  echo "-----------------------------------------------------------------"
  echo -e "${YELLOW}Param1${NC} : Hostname or address of the machine hosting the Service"
  echo -e "${BLUE}Param2${NC} : Port or address of the service"
  echo -e "${GREEN}example${NC}: smokeTest.sh ${YELLOW}localhost${NC} ${BLUE}8080${NC}"

	}
#Set default values
HOST=localhost
PORT=8080
#Check for help screen
if [ "$1" == "-h" ]
then
  usage
  exit 0
fi
#Parse Params
if [[ ! -z $1 ]]
then
  HOST=$1
fi

if [[ ! -z $2 ]]
then
  PORT=$2
fi
#Set local vars
PASSED=0
FAILED=0
#Run tests
#If I had more time would write a parser for results.
RESULTPOSITIVE=$(curl -s $HOST:$PORT/fizzbuzz/32)
if [[ $RESULTPOSITIVE = *"30"* ]]
then
  ((PASSED++))
else
  ((FAILED++))
fi

RESULTSTRING=$(curl -s $HOST:$PORT/fizzbuzz/zxcasd)
if [[ $RESULTSTRING = *"Bad Request"* ]]
then
  ((PASSED++))
else
  ((FAILED++))
fi

RESULTNEG=$(curl -s $HOST:$PORT/fizzbuzz/-32)
if [[ $RESULTNEG = *"-30"* ]]
then
  ((PASSED++))
else
  ((FAILED++))
fi
#Print Results
echo -e "PASSED ${GREEN}${PASSED}${NC} "
echo -e "FAILED ${RED}${FAILED}${NC} "
