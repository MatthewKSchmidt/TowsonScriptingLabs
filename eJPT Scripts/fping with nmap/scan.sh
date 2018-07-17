#!/bin/bash

# https://github.com/MatthewKSchmidt

fping -s -g 192.168.1.0 192.168.1.255 -r 1 > results.txt
grep alive results.txt | cut -d " " -f 1 > alive.txt
echo "The following hosts are alive..."
cat alive.txt
echo "Performing SYN scan on targets..." 
while IFS='' read -r line || [[ -n "$line" ]]; do
  nmap -sS -sV $line
done < "$1"
