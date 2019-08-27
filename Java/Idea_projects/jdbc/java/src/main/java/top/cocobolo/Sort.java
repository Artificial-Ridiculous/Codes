package top.cocobolo;

import java.util.Arrays;

public class Sort {
    public static void swap(int[] arr ,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubble(int[] arr){
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 -j; i++) {
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }

            }
        }
    }

    public static void choose(int[] l){
        for (int i = 0; i < l.length-1; i++) {
            int index = 0;
            for (int j = 0; j < l.length-i; j++) {
                if(l[j]>l[index]){
                    index = j;
                }
            }
            swap(l,index,l.length-i-1);
        }
    }

    public static void insert(int[] l) {
        for (int i = 1; i < l.length; i++) {
            int val = l[i];
            int index = i-1;
            while(index >=0 && val<l[index]){
                l[index+1] = l[index];
                index--;
            }
            l[index+1] = val;
        }
    }

    public static void shell(int[] l){
        int len = l.length;
        int step = len;
        int val = 0;
        int index = 0;
        //最后一步步长为1   1/2==0
        while((step /= 2) > 0){
//            System.out.println(step);
            //一共有step组 每组有一个内循环来处理
            for (int i = step; i < len; i++) {  // 这里i从step开始 不是从length-step开始   类比插入排序
                //内层循环  每个循环解决一组
                for (int j = i-step; j >=0 ; j-=step) {
                    if(l[j]>l[j+step]){
                        swap(l,j,j+step);
                    }
                }

            }
            System.out.println("step = " + step);
            System.out.println("l="+ Arrays.toString(l));
        }
    }

    public static void fast(int[] l){
        int len = l.length;
        fast(l,0,len-1);

    }

    private static void fast(int[] l, int i,int j){
        if(j<=i){
            return;
        }
//        if(j==i+1){
//            if(l[i]>l[j]){
//                swap(l,i,j);
//            }
//            return;
//        }
        int target = l[i];
        int left = i; // 是i不是i+1!!!
        int right = j;
        while(left != right){
            while (right!=left && l[right]>= target){//停止条件是相遇 或者遇到比target小的元素
                right--;
            }
            while(left!=right && l[left]<=target){//停止条件是相遇 或者遇到比target大的元素
                left++;
            }
            swap(l,right,left);
        }
        swap(l,right,i);

        fast(l,i,right-1);
        fast(l,right+1,j);
    }

    public static void mergeSort(int[] l){
        int len = l.length;
        int[] tmp = new int[len];
        mergeSort(l,tmp,0,len-1);
    }

    private static void mergeSort(int[] l , int [] tmp,int i,int j){
        if(i>=j){
            return;
        }else{
//            System.out.println("xxx");
            int mid = (i+j)/2;
            mergeSort(l,tmp,i,mid);
            mergeSort(l,tmp,mid+1,j);
            merge2SortedList(l,i,mid,j,tmp);
        }
    }

    private static void merge2SortedList(int[] l ,int left, int mid, int right, int[] tmp){
        System.out.println("归并下标"+left+"到"+right);
        int index = left;
        int i = left;
        int j = mid+1;
        while(i<= mid && j<=right){
            if(l[i]<=l[j]){
                tmp[index] = l[i];
                i++;
                index++;
            }else{
                tmp[index]=l[j];
                j++;
                index++;
            }
        }
        //有一边已经全部拷完了
        while(i<=mid){
            tmp[index] = l[i];
            index++;
            i++;
        }
        while(j<=right){
            tmp[index] = l[j];
            index++;
            j++;
        }
        //往原始数组拷
        for (int k = left; k <= right; k++) {  // 是<=不是<
            l[k] = tmp[k];
        }
    }

    public static int find(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            System.out.println("mid = " + mid);
            if(target == arr[mid]){
                return mid;
            }else if(target < arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]  = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*16);
        }

        int arr1[]  = new int[]{1,2,3,4,5,6,7,8};

        System.out.println("arr="+ Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("arr="+ Arrays.toString(arr));
        System.out.println(find(arr1,4));

    }
}
