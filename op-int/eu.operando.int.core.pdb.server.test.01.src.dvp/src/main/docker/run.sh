#!/bin/bash

echo Pdb Endpoint: $PDB_ENDPOINT

all_Successful=0

python -m unittest
if [ $? -eq 0 ]
then
  echo "ALL SUCCESSFUL"
else
  echo "ERROR"
fi
