package com.threework.binarysearch;

public class BinSearch {
    public static int commonSearch(int[] nums, int tgt){
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == tgt) return mid;
            else if(nums[mid] < tgt) left = mid +1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int leftMarginSearch(int[] nums, int tgt){
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] == tgt) right = mid;
            else if(nums[mid] < tgt) left = mid + 1;
            else right = mid;
        }
        if(left == nums.length) return - 1;
        return  nums[left] == tgt ? left: -1;
    }

    public static int rightMarginSearch(int[] nums, int tgt){
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] == tgt) left = mid + 1;
            else if(nums[mid] < tgt) left = mid + 1;
            else right = mid;
        }
        if(left == 0) return -1;
        return nums[left - 1] == tgt ? left - 1: -1 ;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,2,2,5,7};
        System.out.println(commonSearch(nums, 0));
        System.out.println(leftMarginSearch(nums, 0));
        System.out.println(rightMarginSearch(nums, 0));
    }
}
