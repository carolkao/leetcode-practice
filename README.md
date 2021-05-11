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
