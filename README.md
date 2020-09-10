---
description: >-
  This repo contains my solutions & notes for Leetcode problems and some
  Interview Questions.
---

# Leetcode-Notes

## **Palindromes**

\*\*\*\*

count/print all palindromic substrings

Approach 1: recursive

* regard every pivot `i`as the  center of the palindromic substring
* for palindromic substring \[i, j\], check \[i-1, j+1\]
* for odds substrings, start from \[i, i\]
* for even substrings, start from \[i, i+1\]
* should be O\(n^2\) complexity, cuz there are at most n^2 substrings
* if print, use a set, could cost O\(n^3\) complexity due to `substring()` 

```text
public int countSubstrings(String s) {
    if(s.length() == 0) return 0;
    int n = s.length();
    int[] res = new int[1];
    res[0] = 0;
    for(int i = 0; i < n; i++){
        helper(s, i, i, res);
        helper(s, i, i+1, res);
    }
    return res[0];
}

private void helper(String s, int i, int j, int[] res){
    while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
        res[0] += 1;
        i--;
        j++;
    }
}
```

Approach 2: DP

* dp\[i\]\[j\] represent substring\[i, j\] is palindromic or not

```text
public int countSubstrings(String s) {
    if(s.length() == 0) return 0;
    int n = s.length(), res = 0;
    boolean[][] dp = new boolean[n][n];
    for(int i = n - 1; i >= 0; i--){
        for(int j = i; j < n; j++){
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1]);
            if(dp[i][j]) res++;
        }
    }
    return res;
}  
```





