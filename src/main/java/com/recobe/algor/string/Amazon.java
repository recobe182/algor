package com.recobe.algor.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Amazon {

    public static List<String> aa(String str, int num) {
        int asciiIndex = 97;
        Set<String> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int[] tables = new int[26];
            int count = 0;
            for (int j = i; j < str.length(); j++) {
                char val = str.charAt(j);
                if (tables[val - asciiIndex] != 0) {
                    break;
                } else {
                    tables[val - asciiIndex] = 1;
                    count++;
                }
                if (count == num) {
                    String newStr = str.substring(i, i + num);
                    result.add(newStr);
                }
            }
        }
        return new ArrayList<>(result);
    }

}
