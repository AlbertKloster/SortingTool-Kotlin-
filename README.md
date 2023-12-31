# Stage 1/6: Numbers only
## Description
With this project, you will learn how to process numeric and text input, sort it, and output useful information about the data. Your final program will work with numbers, words, and lines. In the first stage, we will stick to integer numbers.

The program should read user input consisting of several lines, each containing integers separated by an arbitrary number of spaces. Then it should count the number of integers in the input, find the greatest one, and identify the number of times this integer appears. Finally, it should print this information to the console.

If you run your program and try to type in the numbers manually, you'll see that this process will go on infinitely. To end the input, the user should type the <a href="https://en.wikipedia.org/wiki/End-of-file">end-of-file</a> symbol, informing the operating system that no more input will be provided. On Linux and Mac, the shortcut for this symbol is Ctrl+D or Cmd+D, and on Windows the combination is Ctrl+Z. You don't need to check specifically for the end-of-file symbols in your program, use scanner.hasNext... instead. This will return false if the end of the input is reached.

## Objectives
Read integers from the console until the end of the input is reached.

Compute the following information:

1. The number of integers in the input (X)
2. The greatest number in the input (Y)
3. How many times the greatest number occurs in the input (Z)

Output it using this template:
```
Total numbers: X.
The greatest number: Y (Z time(s)).
```

## Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.
```
> 1 -2   33 4
> 42
> 1                 1
Total numbers: 7.
The greatest number: 42 (1 time(s)).
```
