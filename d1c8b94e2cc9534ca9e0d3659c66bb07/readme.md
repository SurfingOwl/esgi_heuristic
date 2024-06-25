Create an app that calculates an operations on a CSV

This program takes a file name as argument and an operation (limited to + and *): 
`calc 'numbers.csv' '+'`

if csv contains:
```
1
2
3
``` 

and operation is `+'

then it should produce : 

```
        1
        +2 (=3)
        +3 (=6)
        -------
total = 6 (addition)
```


You must implement this is in a simple and modular style:
- it should be open to change
- you must have separation of concerns (input, output, calculations)
- it should respect the desired output
- the core should be tested
