import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> res = new HashSet<>();
        
        if(nums.length == 0) return new ArrayList<>(res);
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2 ; i++) {
            
            int j = i+1;
            int k = nums.length-1;
            
            while(j < k) {
                
                int sum = nums[j]+nums[k];
                
                if(sum == -nums[i]) res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(sum>-nums[i])k--;
                else if(sum<-nums[i])j++;
            
            }
            
        }
        return new ArrayList<>(res);        
    }
}


//1.
// Arrays.sort(nums);
        
//         List<List<Integer>> ans = new ArrayList<>();
        
//         for(int i=0 ; i<nums.length-2 ; i++) {
            
//             int j = i+1;
//             int k = nums.length-1;
            
//             while(j<k) {
                
//                 if( nums[j]+nums[k] + nums[i] >= 0 ) {
//                     k--;
//                 }
//                 else if( nums[j]+nums[k] +nums[i] <= 0 ) {
//                     j++;
//                 }
//                 else if(nums[i]+nums[j]+nums[k]==0) {
//                     ArrayList<Integer> al = new  ArrayList<>();
//                     al.add(nums[i]);
//                     al.add(nums[j]);
//                     al.add(nums[k]);
//                     ans.add(al);
//                 }
//             }  
//         }
//         return ans;

//2.
// Arrays.sort(nums);
        
//         ArrayList<ArrayList<Integer>> ans = new  ArrayList<>();
        
//         for(int i=0 ; i<nums.length-2 ; i++) {
            
//             int j = i+1;
//             int k = nums.length-1;
            
//             while(j<k) {
                
//                 if( nums[j]+nums[k] + nums[i] >= 0 ) {
//                     k--;
//                 }
//                 else if( nums[j]+nums[k] +nums[i] <= 0 ) {
//                     j++;
//                 }
//                 else if(nums[i]+nums[j]+nums[k]==0) {
//                     ArrayList<Integer> al = new  ArrayList<>();
//                     al.add(nums[i]);
//                     al.add(nums[j]);
//                     al.add(nums[k]);
//                     ans.add(al);
//                 }
//             }  
//         }
//         return ans;



// ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//         Arrays.sort(nums);
        
//         for(int i=0 ; i<nums.length-2 ; i++) {
            
//             int j=i+1;
//             int k=nums.length-1;
            
//             while(j<k) {
                
//                 if(nums[i]+nums[j]+nums[k] == 0) {
//                     ArrayList < Integer > al = new ArrayList<>();
//                     al.add(i);
//                     al.add(j);
//                     al.add(k);
                    
//                     ans.add(al);
                    
//                 }
//                 if(nums[i] + nums[j] + nums[k] >= 0) {
//                     k--;
//                 }
//                 else if( nums[i] + nums[j] + nums[k] <= 0) {
//                     j++;
//                 }
//             }
//         }
//         return ans;