import java.util.Scanner;
//segment tree
import java.util.*;
public class Tree {
    int[] segTree;
    //finding minimum for the parent and root node
    public int max1(int a , int b){
       
        return Math.max(a,b);
    }
    // finding middle of the range
    public int findMid(int low , int high){
        int mid = (int)low+(high-low)/2;
        return mid;
    }
    //creating segment tree array
    void createST(int[] a , int n){
        int s = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        int size = 2*(int)Math.pow(2, s)-1;
        segTree=new int[size];
        Utility(a,0,n-1,0);
    }
    int Utility(int[] a , int left , int right , int sIndex){
        if(left == right){
            segTree[sIndex]=a[left];
            return a[left];
        }
        int mid = findMid(left, right);
        segTree[sIndex]=max1(Utility(a, left, mid, sIndex *2+1),Utility(a, mid+1, right, sIndex*2+2));
        return segTree[sIndex];
    }
    //for the range query 
    int queryST(int n,int left , int right){
        if(left < 0 || right > n-1 || left > right){
            System.out.println("invalid query");
            return -1;
        }
        return queryUtility(0,n-1,left,right,0);

    }
    //finding minimum 
    int queryUtility(int sL,int sR,int left , int right , int sIndex){
        if(left <= sL && right >= sR){
            return segTree[sIndex];
        }
        if(sR < left || sL > right){
            return Integer.MIN_VALUE;
        }
        int mid = findMid(sL,sR);
        return (max1(queryUtility(sL, mid, left, right, 2*sIndex+1),queryUtility(mid+1, sR, left, right, sIndex*2+2)));
    }

   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter length of array : ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            System.out.print("enter elements :");
            arr[i] = scan.nextInt();
        }
        System.out.println("\n");
        Tree tree = new Tree();
        tree.createST(arr, n);
        System.out.println("enter number of queries : ");
        int q = scan.nextInt();
        for(int i=0;i<q;i++){
            System.out.println("enter query");
            int left=scan.nextInt();
            int right = scan.nextInt();
            System.out.println(tree.queryST(n,left,right));
        }


   } 
}
