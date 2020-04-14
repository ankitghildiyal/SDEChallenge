The moving average interface calculates the average of last N elements
in a stream. For example, moving average of 3 elements with stream of 5 elements will be calculated as below
Stream  -   12 -> 23 -> 3 -> 78 -> 4  then average calculated when each element is added is
Step 1 - Element 12 Average - 12/3 = 4.0
Step 2 - Element 23 Average - 12+23/3 = 8.3333
Step 3 - Element 3 Average - 12+23+3/3 = 12.6667
Step 4 - Element 78 Average - 23+3+78/3  81.0
Note that since we only want average of last 3 elements we have removed
the first element when calculating the average
Step 5 - Element 4 Average - 3+78+4/3 = 28.3333

The interface has below 3 methods:
List<Double> getAllElements() - This method will return list of all elements
                           received from the stream till date.

void addElement(double streamElement) - Method used to add elements to calculator.

double getAverage() returns the average of last N elements added to the elements list.
The average is rounded up (RoundingMode.HALF_UP) to 4 decimal places by default however the number of decimal places
can be specified when instantiating the calculator using the constructor MovingAverageImpl(int averageSize, int decimalPointsInAverage).


