package com.bj.principle.ocp;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public ArrayList<ArrayList<Integer>> getSetOfSum(int[] nums, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return res;
        Arrays.sort(nums);
        getSetOfSum(nums,res,new ArrayList<Integer>(),target,0);
        return res;
    }
    public void getSetOfSum(int[] nums,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> tempList,int target,int index){
        if(target==0){
            res.add(new ArrayList<Integer>(tempList));
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(target-nums[i]<0)
                return;
            tempList.add(nums[i]);
            getSetOfSum(nums,res,tempList,target-nums[i],i);
            tempList.remove(tempList.size()-1);

        }

    }
    public static void main(String[] args){
        int[] arr = new int[]{3,2,6,7};
        System.out.println(new Main().getSetOfSum(arr,7));
    }
}