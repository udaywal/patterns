package patterns._3_slow_and_fast_pointers;

import java.util.*;

public class HappyNumber {

  public static void main(String[] args) {
    // Input#1: 23 | true
    int num = 23;
    // Input#2: 12 | false
    // num = 12;
    // System.out.println("✅ Is number happy? " + isHappyNumber(num));
    System.out.println("✅ Is number happy? " + isHappyNumberUsingPointers(num));
  }
  
  /* With the map */
  public static boolean isHappyNumber(int num) {
    boolean ans = false;
    Map<Integer, Integer> mp = new HashMap<>();
    while (num > 0) {
      num = sumOfSquareOfDigits(num);
      // System.out.println(num);
      if (num == 1) {
        return true;
      }
      if (!mp.containsKey(num)) {
        mp.put(num, 1);
      } else {
        return false;
      }
    }
    return ans;
  }
  
  /* With slow and fast pointers */
  public static boolean isHappyNumberUsingPointers(int num) {
    int slow = num, fast = num;
    do {
      slow = sumOfSquareOfDigits(slow); // move one step
      fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast)); // move two steps
      // System.out.println(slow + " | " + fast);
      if (fast == 1) {
        return true;
      }
    } while (slow != fast); // found cycle
    return false;
  }

  public static int sumOfSquareOfDigits(int num) {
    int newNum = 0;
    while (num > 0) {
      int digit = num % 10;
      // System.out.println("digit: " + digit);
      newNum += digit*digit;
      num = num / 10;
      // System.out.println("num: " + num);
    }
    return newNum;
  }


  
}