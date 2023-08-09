import java.util.HashSet;

public class containDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0){
            return false;
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i:nums){
            if(!hset.add(i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        containDuplicate obj=new containDuplicate();
        int[] nums={1,2,3,1};
        System.out.println(obj.containsDuplicate(nums));
    }
}
