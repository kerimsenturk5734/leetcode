

//QUESTION LINK ---> https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,11,15,7};
        twoSum(nums,9);
    }

    public static int[] twoSum(int[] nums,int targetVal){
        int[] indexes=null;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>targetVal)
                continue;

            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>targetVal)
                    continue;
                if(nums[i]+nums[j]==targetVal)
                    indexes=new int[]{i,j};
            }

        }
        System.out.println(indexes[0]+","+indexes[1]);
        return indexes;
    }
}