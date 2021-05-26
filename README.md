# leetcode-practice

## Java Note
### [StringBuilder]
Backtracking 時可能會用到, 比String + 效率好
```java
StringBuilder sb = new StringBuilder();
sb.append("123");
sb.deleteCharAt(sb.length() - 1);
```
### [List <-> Array]
```java
//List to Array
String[] strarray = list.toArray(new String[list.size()]);

// Array to List
List<String> list = Arrays.asList(strarray);
List<String> list = Arrays.asList(strarray[i], strarray[j], strarray[k]);
```

### [填滿Array]
```java
Arrays.fill(array, value)
```

## TO Review List
### Array
### String
### Binary Search
```java
// input: int[] nums

int left = 0, right = nums.length - 1, mid;

while (left < right) {
    // not use (left + right) / 2 to avoid overflow
    mid = left + (right - left) / 2;

    // some specific condition
    // xxx

    // choose left-half or right-half
    if (meet right-half condition) {
        left = mid + 1; //or left = mid  (by different situation)
    } else {
        right = mid - 1; //or right = mid (by different situation)
    }
}
```
### BFS
### DFS / Backtracking
```java 
// Backtracking Sample

void dfs(List<List<Integer>> result, List<Integer> current, int startIdx, int[] nums) {
    if (meet criteria) {
        result.add(new ArrayList<>(current);
        return;
    }

    for (int i = startIdx; i < nums.length; i++) {
        current.add(nums[i]);
        dfs(result, current, i+1, nums);
        current.remove(current.size() - 1);
    }
}
```
### DP
### Two Pointer
### Sliding Window
### Tree
### Stack
### Queue
### Heap

## History
### 2021-05-09
Happy Monther's Day, begin this project
