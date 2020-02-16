package 腾讯笔试;
import java.util.Scanner;

/**
 * @author : Meredith
 * @date : 2019-09-20 20:31
 * @description :
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n=in.nextInt();
        int nums[]=new int [n];
        for(int i=0;i<n;i++)
        {
            nums[i]=in.nextInt()/1024;
        }
        System.out.println(depart(nums)*1024);
    }

    static public  int depart(int[] arr) {

        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }

        int temp[][]=new int[arr.length+1][sum/2+1];//注意开辟数组的行数列数要多1,是从第1行第1列开始保存数据
        for(int i=0;i<arr.length;i++)
            for(int capacity=1;capacity<=sum/2;capacity++)
            {
                temp[i+1][capacity]=temp[i][capacity];
                if(arr[i]<=capacity && temp[i][capacity-arr[i]] +arr[i]>temp[i][capacity]){
                    temp[i+1][capacity]=temp[i][capacity-arr[i]]+arr[i];//可以放，且值比之前要大，则更新
                }
            }
        return Math.max(temp[arr.length][sum/2], sum-temp[arr.length][sum/2]);
    }

}
