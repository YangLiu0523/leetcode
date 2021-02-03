## Common Error

### Sliding Window
1. Don't forget the last interval(right is n) [fruit into baskets](https://leetcode.com/problems/fruit-into-baskets/)

### Fenwich Tree
1. FenwichTree's boundary is [1 to n]. During the query process, limit should be (i > 0) instead of (i >= 0)

### Segment Tree
1. The lo and hi boundary is with the original array, so the mid should be calculate using lo and hi instead of i and j

### Compare Integer
using .equals instead of ==
JVM is cacheing Integer, == is used in -128->127

## Common
Arrays.asList() and Arrays.sort() both use Integer[] instead of int[]

public static int binarySearch(Object[] a, Object key)  
index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). 
The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. 

## Big O
http://souravsengupta.com/cds2016/lectures/Complexity_Cheatsheet.pdf


##

-2147483648 ~ 2147483647

### Graph Representation
```
# Unweighted
List<Integer>[] adj = new ArrayList<>();

# Weighted
Map<Integer, List<int[]>> adj = new HashMap<>();
```

Not operation
```
System.out.println(-2); // -2
System.out.println(~2); // -3
System.out.println(-3); // -3
System.out.println(~3); // -4
```

Bit 
n &= (n - 1) // remove the least significant 1-bit

numer = 0, denom