package cw04_5026251147_Aryansyah_Achmad_Fathi_Robbani;

/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2024-2025
 * Coursework   : 04
 * Student ID   : 5026251147
 * Full Name    : Aryansyah Achmad Fathi Robbani
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Problem Test Case 1:");
        Integer [] a = {1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1};
        ArrayList<Integer> v = new ArrayList<Integer> (Arrays.asList(a));
        System.out.println(twice(v));
        
        System.out.println("Problem Test Case 2:");
        String [] fNames ={"Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal"};
        String [] lNames ={"Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins"};
        String [] lNamesX ={"Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins"};
        
        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m1.put(fNames[i],lNames[i]);
        }
        
        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m2.put(fNames[i],lNamesX[i]);
        }
        
        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));
        
        System.out.println("Problem Test Case 3:");
        Integer d1 [] = {3, 8, 17, 9, 17, 8, 3};
        Integer d2 [] = {3, 8, 17, 9, 4, 17, 8, 3};
        
        Queue<Integer> q1 = new LinkedList<Integer> (Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer> (Arrays.asList(d2));
        
        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));
        
        
        
    }
    
    public static Set<Integer> twice(List<Integer> l){
        Set<Integer> s = new TreeSet<Integer>();
        Set<Integer> once = new HashSet<Integer>();  
        Set<Integer> more = new HashSet<Integer>();  
        
        for (int n : l) {
            if (more.contains(n)) {
                continue;                 
            } else if (s.contains(n)) {
                s.remove(n);              
                more.add(n);
            } else if (once.contains(n)) {
                once.remove(n);           
                s.add(n);
            } else {
                once.add(n);              
            }
        }
        return s;
    }
    
    public static boolean  hasDuplicateValue(Map<String,String> m){
        boolean s=false;
        Set<String> seen = new HashSet<String>();
        for (String value : m.values()) {
            if (!seen.add(value)) {     
            return true;
            }
        }
        return s;
    }
    
    public static boolean isPalindrome(Queue<Integer> q){
        boolean s=true;
        Stack<Integer> stack = new Stack<Integer>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int n = q.remove();
            stack.push(n);
            q.add(n);
        }
        
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            int top = stack.pop();
            if (n != top) {
                s = false;
        }
        q.add(n);
    }
        
    return s;
    }
}

