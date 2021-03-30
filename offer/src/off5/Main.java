package off5;

import java.util.Scanner;

class Solution {
    public String replaceSpace(String s) {
        int length = s.length(), size = 0;
        char[] t = new char[length*3];
        for(int i=0;i<length;i++){
            if(s.charAt(i) == ' '){
                t[size++] = '%';
                t[size++] = '2';
                t[size++] = '0';
            }else{
                t[size++] = s.charAt(i);
            }
        }
        return new String(t, 0, size);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.trim();
        System.out.println(new Solution().replaceSpace(s));
    }
}
