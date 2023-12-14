Gabriela Roznawska
13/12/2023
CSC-207-Fall2023

Acknowledgements: Prof.Rebelsky for his help and advice as well as the
online resources. Mentor Micah Cantor for reading thorugh the file
and understanding what is happening.

The program consists of structures (AssociativeArray), TextSpeech.java 
AAC.java, AACCategory.java, and AACMappings.java. Only the last two of 
these consist of my code and are relevant for this project assesment.

AACCategory maps image locations (a "link", such as the one in AACMappings.txt)
to strings (names of the categories). It implements a few methods: 
- addItem(String, String)
- getCategory()
- getImages()
- getText(String)
- hasImage()

AACMappings uses the AACCategory, reads in the file and adds higher
level categories and regular level ones. It implements a few methods:
- add(String, String)
- getCurrentCategory()
- getImageLocas()
- getText(String)
- isCategory(String)
- reset()
- writeToFile(String)
