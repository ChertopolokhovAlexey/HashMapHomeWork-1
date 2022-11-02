//https://github.com/ChertopolokhovAlexey/HashMapHomeWork-1.git

import java.util.*;

public class Main {
    static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
            " incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation" +
            " ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit" +
            " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
            " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        List<Character> max = new ArrayList<>();
        List<Character> min = new ArrayList<>();
        String[] roll = (TEXT.toLowerCase()).split("");
        stringToChar(roll, list);
        listToMap(map, list);
        extremum(max, min, map);
        System.out.println(map);
    }


    public static void stringToChar(String[] roll, List<Character> list) {
        for (String s : roll) {
            char letter = s.charAt(0);
            if (Character.isLetter(letter)) {
                list.add(letter);
            }
        }
    }

    public static void listToMap(Map<Character, Integer> map, List<Character> list) {
        for (Character c : list) {
            if (map.containsKey(c)) {
                int i = map.get(c);
                i++;
                map.put(c, i);
                continue;
            }
            map.put(c, 1);
        }
    }

    private static void extremum(List<Character> max, List<Character> min, Map<Character, Integer> map) {
        int maximum = 0;

        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            int i = kv.getValue();
            if (maximum <= i) {
                maximum = i;
            }
        }
        int minimum = maximum;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            int i = kv.getValue();
            if (minimum >= i) {
                minimum = i;
            }
        }
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() == maximum) {
                max.add(kv.getKey());
            }
            if (kv.getValue() == minimum) {
                min.add(kv.getKey());
            }
        }
        System.out.println("Максимальное число символов: " + max + ", " + maximum + " раз(a).");
        System.out.println("Максимальное число символов: " + min + ", " + minimum + " раз(a).");
    }
}
