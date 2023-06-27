# Stage 6/6: X-files
## Description
Sometimes it's useful to read data that is from a file, rather than from the standard input, and write the result to another file instead of printing it to the console. Add this functionality to your program along with the appropriate command-line argument support.

## Objectives
Update command-line arguments parsing to support the `-inputFile` and `-outputFile` arguments.

If `-inputFile` is provided followed by the file name, read the input data from the file.

If `-outputFile` is provided followed by the file name, output only the error messages to the console and print the results to the file.

## Examples
<b>Example 1:</b> <i>input file is defined</i>
```
java SortingTool -sortingType byCount -inputFile input.txt
```

<b>Example 2:</b> <i>input and output files are defined</i>
```
java SortingTool -sortingType byCount -inputFile data.dat -outputFile out.txt
```
