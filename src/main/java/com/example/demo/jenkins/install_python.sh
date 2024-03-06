#!/bin/bash

apt install -y python3
apt install -y python3-pip
rm /usr/lib/python3.11/EXTERNALLY-MANAGED

pip install sxl
pip install luadata