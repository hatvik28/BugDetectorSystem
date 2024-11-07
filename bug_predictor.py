import re
import json

# Load bug patterns from JSON file
with open('bug_specifications.json', 'r') as file:
    bug_patterns = json.load(file)
    print("Bug specs loaded")

with open('Main.java' , 'r') as file:
    java_code = file.read()
    print("Java file loaded")
          