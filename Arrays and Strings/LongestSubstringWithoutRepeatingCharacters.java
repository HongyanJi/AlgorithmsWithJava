// leetcode 3. Longest Substring Without Repeating Characters
    // brute force. T: O(n^3)  S: O(min(m, n)) TLE
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    res = Math.max(res, j - i);
                }
             }
        }
        
        return res;
    }
    
    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            
            set.add(ch);
        }
        
        return true;
    }
    
    // sliding window: T: O(n)   S: O(min(m, n))
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        HashSet<Character> window = new HashSet<Character>();

        int left = 0, curLen = 0, maxLen = 0;
        char[] sc = s.toCharArray();
        for (char ch: sc) {
            while (window.contains(ch)) {
                window.remove(sc[left]);
                left ++;
                curLen --;
            }
            window.add(ch);
            curLen ++;
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
