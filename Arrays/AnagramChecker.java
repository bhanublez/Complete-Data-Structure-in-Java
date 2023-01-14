
import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
  public static boolean isAnagram(String s1, String s2) {

    s1 = s1.replaceAll("\\s", "").toLowerCase();
    s2 = s2.replaceAll("\\s", "").toLowerCase();

    if (s1.length() != s2.length()) return false;

    Map<Character, Integer> map = new HashMap<>();

    for (Character character : s1.toCharArray())
      if (map.containsKey(character)) map.put(character, map.get(character) + 1);
      else map.put(character, 1);

    for (Character character : s2.toCharArray())
      if (map.containsKey(character)) map.put(character, map.get(character) - 1);
      else return false;

    for (Character character : s1.toCharArray()) if (map.get(character) != 0) return false;

    return true;
  }
  public static void main(String[] args) {

    // should be true
    System.out.println(AnagramChecker.isAnagram("public relations", "crap built on lies"));

    // should be true
    System.out.println(AnagramChecker.isAnagram("d og", "dog"));

    // should be true
    System.out.println(AnagramChecker.isAnagram("d og", "god"));

    // should be true
    System.out.println(AnagramChecker.isAnagram("clint eastwood", "old west action"));

    // should be false
    System.out.println(AnagramChecker.isAnagram("qq", "bb"));

    // should be false
    System.out.println(AnagramChecker.isAnagram("eh yo !", "yo ho!"));
  }
}