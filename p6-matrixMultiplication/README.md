# Project 6: Matrix Multiplication
## Due Date: July 29, 2021 11:59 PM
## Assignment Type: Closed [(see policy)](http://www.cs.umd.edu/class/summer2019/cmsc132/openClosedPolicy.shtml)

# Introduction

Matrices _(singluar: matrix)_ are rectangular arrays of numbers (or sometimes symbols) arranged in rows or columns. For example, the matrix below is a 2x3 (two-by-three) array.

<img src="https://latex.codecogs.com/png.latex?%5Cbg_white%20%5Cbegin%7Bbmatrix%7D%201%20%26%202%20%26%2034%20%5C%5C%2032%20%26%205%20%26%2094%20%5Cend%7Bbmatrix%7D" />

Matrices have a lot of uses. They can represent vectors in n-dimensions, define transformations between dimensional spaces, efficiently solve systems of linear equations, describe position as well as orientation in far more compact ways, describe rotations, show sets of probabilities, represent the derivative operation, and much more.

Matrix multiplication is a useful concept in Computer Science. For example, GPUs are essentially powerful parallel matrix multipliers. If you do not know how to multiply matrices https://mathworld.wolfram.com/matrixMultiplication.html may be a useful link for you.
Multiplication of matrices are however simply a series of arithmetic operations which computers are fairly fast at. However, the sheer number of operations means that as matrices get larger and larger, they start to suffer from performance issues. We will multithread the operation to see what kind of speedups are possible for this type of problem.

# Objectives
The goal of this project is to learn basic multithreading through implementing matrix multiplication and demonstrate the potential speedup gains that multithreading offers.

# Grading
* Public Tests (20%)
* Release Tests (40%)
* Secret Tests (30%)
* Style (10%)

# Code Distribution
The code distribution provides the following:
- `Matrix` package - matrix helper functions should be defined here as well as `multiply()`
- `Tests` package - contains public tests

# Specifications
- Implement all of the public methods which have headers given.
- You are responsible for implementing a **multithreaded implementation** of `multiply()`. 
- Return null instead of 0 sized arrays

# Requirements
- Verify your project passes tests 
- Follow the style guidelines for this course
- If you have issues with your code and go to office hours for assistance, ensure that you have student tests illustrating your issue

# Testing
It is recommended that you test your own code using student tests.

# Submission
To submit your project, zip the project folder and upload the zipped file to gradescope.

# Academic Integrity
Please make sure you read the academic integrity section of the syllabus so you understand what is permissible in our programming projects. We want to remind you that we check your project against other students' projects and any case of academic dishonesty will be referred to the Office of Student Conduct. 
