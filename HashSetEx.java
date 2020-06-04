package HashSetEx;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetEx {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 0 || nums.length ==1 ){
            return false;
        }

        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        if(set.size() != nums.length){
            return true;
        }
        return false;
    }
    public static int distributeCandies(int[] candies) {
        HashSet<Integer> candy = new HashSet<>();

        for(int i = 0; i< candies.length; i++){
            candy.add(candies[i]);
        }

        return Math.min(candy.size(), candies.length / 2);
    }

    public static ArrayList<String> findWords(String[] words) {

        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();
//Inserting the first row from the keyboard
        row1.add('Q');
        row1.add('W');
        row1.add('E');
        row1.add('R');
        row1.add('T');
        row1.add('Y');
        row1.add('U');
        row1.add('I');
        row1.add('O');
        row1.add('P');
//Inserting the second row from the keyboard
        row2.add('A');
        row2.add('S');
        row2.add('D');
        row2.add('F');
        row2.add('G');
        row2.add('H');
        row2.add('J');
        row2.add('K');
        row2.add('L');
//Inserting the third row from the keyboard
        row3.add('Z');
        row3.add('X');
        row3.add('C');
        row3.add('V');
        row3.add('B');
        row3.add('N');
        row3.add('M');

        ArrayList<String> result = new ArrayList<>();


        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i].toUpperCase(), row1) || isValid(words[i].toUpperCase(), row2) || isValid(words[i].toUpperCase(), row3)) {
                result.add(words[i]);
            }
        }
        return result;
    }

    public static boolean isValid(String word, HashSet<Character> row) {
        for (int i = 0; i < word.length(); i++) {
            if (!row.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static HashSet<Integer> intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            intersection.add(nums1[i]);
            if (!set.contains(nums1[i])) {
                intersection.remove(nums1[i]);

            }

        }

        return intersection;
    }

    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                counter++;
            }
        }
        return counter;
    }

    public static int singleNumber(int[] nums) {

        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!numbers.remove(nums[i])) {
                numbers.add(nums[i]);
            }
        }
        return numbers.iterator().next();

    }

    public static void main(String[] args) {
        //Single number - LeetCode
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));


        //Jewels and Stones

        String jewels = "aA";
        String stones = "aAABB";
        System.out.println(numJewelsInStones(jewels, stones));

        //Intersection of Two Arrays

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(intersection(nums1, nums2));

        //Keyboard Row

        String[] input = {"Alaska", "Hello", "Dad", "Peace"};
        System.out.println(findWords(input));

        //Distribute candies

        int [] candies = {1,1,2,2,3,3};
        System.out.println(distributeCandies(candies));

        //Contains Duplicate
        int [] nums3 = {1,2,3,1};

        System.out.println(containsDuplicate(nums3));
    }

}
