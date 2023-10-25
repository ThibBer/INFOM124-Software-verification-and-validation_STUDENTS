# Specification-based Testing - Unique

## 1. Goal, inputs and outputs
- Goal: Get unique value in an array
- Input domain: array of double
- Output domain: array of unique double value

## 2. Explore the program
- Basic test
  - Inputs : [10.1, 40.5, 10.1, 5, 8, 4, 8]
  - Outputs : [40.5, 10.1, 8, 5, 4]
- Null array
  - Inputs : null
  - Outputs : NullPointerException
- Empty array
  - Inputs : []
  - Outputs : []

## 3. Identify input and output partitions

### Input partitions

#### Individual inputs
- null
- empty
- Array length = 1
- Array length > 1
- Double values with NaN
- Double values with Infinite

#### Combinations of input values
 No combination due to 1 arg only

### Output partitions
- Empty
- Array of double
- NullPointerException

## 4. Identify boundaries

## 5. Select test cases