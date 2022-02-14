# MatrixLauncher

Summary

A 3 by 3 matrix serves as a grid containing a pseudorandom dispersal of numbers 1, 2, or 3. A player can pass in a row and column to "launch" at the matrix. The number at that position (a tuple) will be considered popped by way of transforming into a 0, along with any of the same number in its immediate North/South/East/West direction. The valid nonzero numbers then shift downward and the zero numbers shift upwards, finishing a successful launch.

Design

The design must account for checking the neighboring locations of the target cell while staying within the bounds of the matrix. The bounds must be checked first to ensure that the addition/subtraction to the current row/column does not exceed the established lengths or become negative values. If this new value is beyond the bounds of the matrix, the program will not check for the new tuple and avoid an out of bounds exception. Should the check be within the bounds of the matrix, the neighboring tuple is checked and if the same number as the main tuple, it is transformed to a 0.

The shift method uses a temporary swap variable to hold reference to a value that need be shifted while copying over the value from one tuple to another. The conditions for shifting include zeros in the last and/or middle tuples, as a zero in the top requires no shifts.

A display method shows the matrix values to the player.

A reset method creates reference to a new matrix populated with pseudorandom values between 1 and 3, inclusive.
