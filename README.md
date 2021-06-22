## Nordea Java Coding Assignment
The following is a small coding exercise. You have to provide a working Java program that fulfils a number of requirements. The assessment of your answer will be based on fulfilment of functionality requirements and the quality of the implementation.
### Hand-in
The result of the assignment can be supplied as a zipped project sources. 
### Set up
Your solution must be written in Java version at least 1.7. Your application must be able to read from standard input and write onto standard output. Feel free to present your ability to use common tools, libs or frameworks (wiring, testing, logging, and building).
### Functionality
The basic requirement is to provide a program that can convert text into either XML formatted data or comma separated (CSV) data. The text is to be parsed, broken into sentences and words and the words have to be sorted.<br>
Create a domain model class Sentence.java, which will be used as a key in a Map. <br><br>
Code should be clean and testable. Unit tests must be provided as a formal verification of functional requirements.<br><br>
Consider huge input when dealing IO operations (entire dataset cannot fit in heap). For testing purposes try running your code against our file large.in with the following JVM argument: -Xmx32m<br><br>
The program must be able to read input text like:<br><br>
“Mary had a little lamb. Peter called for the wolf, and Aesop came.<br>
Cinderella likes shoes.”<br><br>
and parse this text into relevant model classes, and be able to convert the structure to both XML and CSV format.<br><br>
The parsing must break the text into sentences and words. The parser should allow some whitespace around words and delimiters.<br><br>
