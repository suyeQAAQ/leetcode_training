//Leetcode 20 Valid Parentheses

// my first solution, 3ms
class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        
        int index = 0;
        
        while(list.size() > 0){
                if(index >= list.size() - 1) {
                    return false;
                }
            
                char c1 = list.get(index);
                char c2 = list.get(index + 1);
                if(c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}') {
                    list.remove(index);
                    list.remove(index);
                    
                    if(list.size() == 0) {
                        return true;
                    }
                    index = index == 0? 0:index - 1;
                } else{
                    index += 1;
                }
        }
        return true;
    }
}

//stack solution, 1ms

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop()!=c) return false;
        }
        return stack.isEmpty();
    }
}