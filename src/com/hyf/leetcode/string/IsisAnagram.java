package com.hyf.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author huyufei on 2020/11/22
 * @Desc: TODO
 */
public class IsisAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        List<Character> SS = new ArrayList<>(charsS.length);
        for (char ss : charsS) {
            SS.add(ss);
        }
        List<Character> TT = new ArrayList<>(charsT.length);
        for (char tt : charsT) {
            TT.add(tt);
        }

        Collections.sort(SS);
        Collections.sort(TT);
        boolean isAnagram = true;
        for (int i = 0; i < SS.size(); i++) {
            if (SS.get(i) != TT.get(i)) {
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }

    public static void main(String[] args) {
        IsisAnagram isisAnagram = new IsisAnagram();
        boolean anagram = isisAnagram.isAnagram("rat", "car");
        System.out.println(anagram);
        System.out.println(isisAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(isisAnagram.isAnagram("ab", "a"));
    }
}
