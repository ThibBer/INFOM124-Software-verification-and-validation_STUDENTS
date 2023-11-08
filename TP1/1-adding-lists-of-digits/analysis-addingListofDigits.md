<<<<<<< HEAD
# Specification-based Testing - Adding lists of digits

## 1. Goal, inputs and outputs
- Goal: Sum 2 numbers, each formatted as a list where each digits of number is in 1 table cell
- Input domain: The method receive 2 parameters :
  - left : array of digits which represent the integer number in range [0-9]
  - right : array of digits which represent the integer number in range [0-9]
- Output domain: An array of digits produced by the sum of both inputs

## 2. Explore the program
### Add - same size
- Inputs :
  - [2, 3]
  - [4, 2]
- Outputs :
  - [6, 5]
### Add - different size
- Inputs
  - [2, 3]
  - [1, 4, 2]
- Outputs
  - [1, 6, 5]
### Add - result > 9
- Inputs
  - [6, 4]
  - [6, 2]
- Outputs
  - [1, 2, 6]
=======
# Specification-based Testing - [NOM EXERCICE]

## 1. Goal, inputs and outputs
- Goal:
- Input domain:
- Output domain:

## 2. Explore the program
>>>>>>> 4e4838a (TP1)

## 3. Identify input and output partitions

### Input partitions

#### Individual inputs
<<<<<<< HEAD
- _left_ parameter category : it seems the array can contains any values. I see the specs mentionned empty & null cases. Here are the partitions :
  - null
  - empty
  - length = 1
  - length > 1
  - start with at least one 0
- _right_ parameter category : same for _left_
  - null
  - empty
  - length = 1
  - length > 1
  - length != length of _right_
  - at least one value > 9
  - start with at least one 0

#### Combinations of input values
- left & right are null
- left & right are empty
- left is null and right isn't
- right is null and left isn't
- right is empty and left isn't
- left is empty and right isn't
- left & right length 1
- left length 1 & right length > 1
- right length 1 & left length > 1
- right & left length > 1

### Output partitions
- Array of integers
  - null
  - empty
  - Array of length 1
  - Array of length > 1
- Reports
  - Sum without reports
  - Sum with reports
    - Multiple reports
    - Report at the end
    - Report anywhere else

## 4. Identify boundaries
1. The report of number when sum of elements is > 9

## 5. Select test cases
Test cases to execute only once and not combine them
- T1 : _left_ is null
- T2 : _right_ is null
- T3 : _left_ is empty
- T4 : _right_ is empty


=======

#### Combinations of input values

### Output partitions

## 4. Identify boundaries

## 5. Select test cases
>>>>>>> 4e4838a (TP1)
