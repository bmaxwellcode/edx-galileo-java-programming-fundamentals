# GalileoX Java Programming Fundamentals

This repository contains the coursework and final project for the GalileoX Java Programming Fundamentals course. The project is structured to demonstrate fundamental Java programming concepts through weekly assignments and a comprehensive final project.

## Project Structure

The project is organized into weekly modules and a final project:

- `week1/` - Lesson 1: Java Overview
- `week2/` - Lesson 2: Java Basics
- `week3/` - Lesson 3: Java Libraries
- `week4/` - Lessson 4: Functional and Concurrences
- `week5/` - Lesson 5: Communication and Networking
- `finalproject/` - Comprehensive final project

## Prerequisites

- Java 11 or higher
- Maven 3.8.1 or higher
- An IDE that supports Java development (IntelliJ IDEA, Eclipse, or VS Code recommended)

## Dependencies

The project uses the following main dependencies:
- JUnit 5.10.2 for testing
- JSON Processing API for JSON handling
- Hamcrest for testing assertions

## Building and Running

### Using Maven (Recommended)
1. Clone the repository:
```bash
git clone [repository-url]
```

2. Navigate to the project directory:
```bash
cd GalileoX_Java_Programming_Fundamentals
```

3. Build the project using Maven:
```bash
mvn clean install
```

4. Run tests:
```bash
mvn test
```

### Java Compilation and Execution Guide

#### Single File Programs
```bash
# Compile and run in one step (Java 11+)
java HelloWorld.java

# Traditional two-step approach
javac HelloWorld.java    # Compile
java HelloWorld          # Run
```

#### Programs with Packages
```bash
# If your class is in a package (e.g., package org.example;)
# Make sure you're in the correct directory structure:
# src/main/java/org/example/HelloWorld.java

# Using fully qualified name
java org.example.HelloWorld

# Using Maven (recommended for projects)
mvn compile
mvn exec:java -Dexec.mainClass="org.example.HelloWorld"
```

#### Important Notes
- Package names must match directory structure
- Class names are case-sensitive
- Always include the `.java` extension when compiling
- Never include the `.class` extension when running

## Project Features

- Weekly assignments covering Java fundamentals
- JSON processing capabilities
- Object-oriented programming examples
- Data structure implementations
- Final project demonstrating mastery of Java concepts

## Contributing

This is a learning project, and contributions are welcome! Please feel free to:
- Report issues
- Suggest improvements
- Submit pull requests

## License

This project is part of the GalileoX Java Programming Fundamentals course and is intended for educational purposes.

## Acknowledgments

- GalileoX for providing the course materials
- The Java community for their excellent documentation and resources