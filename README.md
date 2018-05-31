# Bootcamp_Space_Invaders

Edit this file when ...
If you want to create a task, preface list items with [ ].
To mark a task as complete, use [x].
If your working on something ... put WIP in front of the [ ] and add your name (so we don't all work on the same thing ...)

TODO : 

- [X] Define BadGuy Object
- [X] Mouse Handler - Humberto
- [X] Define Player Object - Adriano
- [X] Define "Play Area" Object - Barbara
- [X] Create Images - Pedro
- [X] Add sound - Adriano
- [ ] Collision Detector
- [ ] Buy Humberto beer !

notes: 
Cleanup Source :
for i in *; do FILE=$(cat -s "$i"); echo "$FILE" > "$i"; done

indent -bad -bap -bbb -cdb -sc -br -ce -cdw -cli4 -cbi4 -cs -pcs -nbc -bfde -brs -brf -ip0 -il 1 -nbbo -sob *.java

Rename .java~ to .java : 
find . -name "*.java~" -exec bash -c 'mv "$1" "${1%.java~}".java' - '{}' \;
