import java.io.*;
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phone = new HashSet<>();
        for(String number:phone_book){
            phone.add(number);   
        }
        
        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                String temp = phone_book[i].substring(0, j);
                if(phone.contains(temp)){
                    return false;
                }
            }
        }
        
        
        return true;
    }
}