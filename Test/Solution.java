import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    boolean isLeaf;
    HashMap<String, Node> hm;
    Node(boolean isLeaf){
        this.isLeaf = isLeaf;
        hm = new HashMap<>();
    }
}

class WordTrie{
    Node root;
    WordTrie(){
        root = new Node(false);
    }
    void addWord(String word){
        Node p = root;
        int len = word.length();
        int i;
        for(i = 0; i < len; i++){
            String str = String.valueOf(word.charAt(i));
            if(p.hm.containsKey(str)){
                //Old node present
                if(i == len - 1)
                    p.isLeaf = true;
                p = p.hm.get(str);
            }
            else{
                Node temp;
                if(i == len - 1)
                    temp = new Node(true);
                else
                    temp = new Node(false);
                p.hm.put(str, temp);
                p = temp;
            }
        }//end of for
    }
    Node searchPartial(String word){
        Node p = root;
        Node n = null;
        int len = word.length();
        int i;
        for(i = 0; i < len; i++){
            String str = String.valueOf(word.charAt(i));
            if(p.hm.containsKey(str)){
                p = p.hm.get(str);
            }
            else 
                return n;
        }//end of for
        return p;
    }
    int findNumOfPaths(Node p){
        if(p == null)
            return 0;
        else if(p.hm.isEmpty() && p.isLeaf)
            return 1;
        int totalPaths = 0;
        for(String s:p.hm.keySet()){
            Node q = p.hm.get(s);
            totalPaths = totalPaths + findNumOfPaths(q);
        }
        if(p.isLeaf)
            totalPaths++;
        return totalPaths;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input[][] = new String[n][2];
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            input[a0][0] = op;
            input[a0][1] = contact;
        }
        WordTrie t = new WordTrie();
        for(int i = 0; i < n; i++){
            if(("add").equals(input[i][0])){
                t.addWord(input[i][1]);
            }
            else if (("find").equals(input[i][0])){
                System.out.println(t.findNumOfPaths(t.searchPartial(input[i][1])));
            }
        }//end of for
    }
}
