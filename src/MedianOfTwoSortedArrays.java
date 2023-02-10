import java.util.*;

//QUESTION --> https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,3,4};
        int[] nums2={4,5,6};
        System.out.println(findMedianOfSortedTwoArrays(nums1,nums2));
    }
    public static double findMedianOfSortedTwoArrays(int[] nums1,int[] nums2){
        ArrayList<Integer> nums=arrayToList(nums1);
        nums.addAll(arrayToList(nums2));
        Collections.sort(nums);
        printList(nums);
        return getMedianOfSortedArray(nums);
    }
    public static double getMedianOfSortedArray(ArrayList<Integer> arrSorted){
        int length=arrSorted.size();
        if(length%2==0){
            return (double) (arrSorted.get((length/2)-1)+arrSorted.get(length/2))/2;
        }

        return arrSorted.get(length/2);
    }

    public static void printList(List list){
        for(Object a:list)
            System.out.println(a);
    }

    public static ArrayList<Integer> arrayToList(int[] nums){
        ArrayList<Integer> arr=new ArrayList<>();
        for (int num : nums) arr.add(num);
        return arr;
    }
}
