# Stage 5/6: Error!
## Description
There is always a possibility that someone will run your program the wrong way. It shouldn't just silently crash, but instead, it should print a message that informs the user of the mistake they made.

In this stage, let's implement error handling for various exceptional situations the user might encounter.

## Objectives
Add exception handling for possible errors and output error messages to the console:

- if the `-sortingType` argument is provided but the type is not, print a message `No sorting type defined!`

- if the `-dataType` argument is provided but the type is not, print `No data type defined!`

- if unknown command-line arguments are provided, print `"-arg" is not a valid parameter. It will be skipped.` for each unknown argument `-arg`;

- if there are strings in the input, but the data type is defined as `long`, print `"abc" is not a long. It will be skipped.` for each string `abc` from the input.

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>sorting numbers naturally without errors</i>
```
$> java SortingTool -sortingType natural -dataType long
> 1 -2   33 4
> 42
> 1                 1
Total numbers: 7.
Sorted data: -2 1 1 1 4 33 42
```

<b>Example 2:</b> <i>sorting numbers by count without errors</i>
```
$> java SortingTool -sortingType byCount -dataType long
> 1 -2   33 4
> 42
> 1                 1
Total numbers: 7.
-2: 1 time(s), 14%
4: 1 time(s), 14%
33: 1 time(s), 14%
42: 1 time(s), 14%
1: 3 time(s), 43%
```

<b>Example 3:</b> <i>missing sorting type</i>
```
$> java SortingTool -sortingType
No sorting type defined!
```

<b>Example 4:</b> <i>missing data type</i>
```
$> java SortingTool -dataType
No data type defined!
```

<b>Example 5:</b> <i>invalid arguments and input value</i>
```
$> java SortingTool -dataType long -sortingType natural -abc -def
"-abc" is not a valid parameter. It will be skipped.
"-def" isn not a valid parameter. It will be skipped.
> a 2 -42
"a" is not a long. It will be skipped.
Total numbers: 2.
Sorted data: -42 2
```
