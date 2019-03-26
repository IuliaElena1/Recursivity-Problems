import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Copyright (c) 2019 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

public class Combinari {

  // {("abc" ,1) -> {a,b,c}
  //   ("abc",2) -> {ab , ac , bc}
  //  ("abc" , 3 -> {abc}

  //("a",1)->{a}

  public static void main(String[] args) {

    String s = "abc";
    Combinari cb = new Combinari();
    //  cb.name(s, 1);
    System.out.println();
    System.out.println(Combinari.getCombination("abcd", 2));

    System.out.println();
    int[] arr = { 3, 4, 1, 5 };

    System.out.println(minimRecursiv(arr));
  }
  // System.out.println(getCombination(s, 2));}

  public static List<String> getCombination(String s, int k) {
    List<String> result = new ArrayList<>();

    if (k == 1) {
      for (char ch : s.toCharArray()) {
        result.add("" + ch);
      }
      return result;
    }

    // abc  0 1 2
    // for (int i = 0; i < s.length(); i++) {
    //    while (k < s.length()) {
    //      String rest = s.substring(0, k - 1) + s.substring(k, s.length());
    //      List<String> list = getCombination(rest, k);
    //      char ch = s.charAt(k - 1);
    //      for (String str : list) {
    //        result.add(ch + str);
    //      }
    //      k++;
    //    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String rest = s.substring(i + 1);
      List<String> list = getCombination(rest, k - 1);

      for (String s2 : list) {
        result.add("" + ch + s2);
      }
    }

    return result;

  }

  public static int minimRecursiv(int[] arr) {

    if (arr.length == 1) {
      return arr[0];
    }

    return Math.min(minimRecursiv(Arrays.copyOfRange(arr, 1, arr.length)), arr[0]);

  }

  public void name(String s, int k) {

    System.out.println(s.substring(k, s.length()));
    System.out.println(s.substring(k - 1, s.length()));
    System.out.println(s.substring(0, k));

  }

}
