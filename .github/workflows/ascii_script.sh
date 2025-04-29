#!/bin/bash
ls -ltra
cat README.md
sudo apt-get install cowsay -y
cowsay -f dragon "welcome to github-actions" >> dragon.txt
grep -i "welcome"  dragon.txt
cat dragon.txt
