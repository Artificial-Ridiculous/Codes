package top.cocobolo;

import java.util.Arrays;

public class Sort {
    public static void swap(int[] arr ,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubble(int[] arr){
        System.out.println("冒泡排序");
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 -j; i++) {
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }

            }
        }
    }

    public static void choose(int[] l){
        System.out.println("简单选择排序");
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
        System.out.println("简单插入排序");
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
        System.out.println("希尔排序");
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
//                for (int j = i-step; j >=0 ; j-=step) {
//                    if(l[j]>l[j+step]){
//                        swap(l,j,j+step);
//                    }
//                }
                val = l[i];
                index = i-step;
                while(index>=0 && val < l[index]){
                    l[index+step] = l[index];
                    index-=step;
                }
                l[index+step]=val;
//                l[index+step]=val;
//                for (int i = 1; i < l.length; i++) {
//                    int val = l[i];
//                    int index = i-1;
//                    while(index >=0 && val<l[index]){
//                        l[index+1] = l[index];
//                        index--;
//                    }
//                    l[index+1] = val;
//                }
            }
//            System.out.println("step = " + step);
//            System.out.println("l="+ Arrays.toString(l));
        }
    }

    public static void fast(int[] l){
        System.out.println("快速排序");
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
        System.out.println("归并排序");
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

    public static void heapSort(int[] arr){
        System.out.println("堆排序");
        // n个数,进行n-1次[构建大顶堆,并将堆顶元素与堆最后一个元素互换]的操作
        // i是堆的最后一个元素下标

        int lastIndex = arr.length-1;
        //(arr.length-2)/2 是最后一个有子节点的节点下标
        for (int index = (arr.length-2)/2; index >= 0 ; index--) {
            // 构建初始的全局大顶堆  大概是nlogn的时间复杂度
            heapify(arr,index,lastIndex);

        }
        for(;lastIndex>=1;lastIndex--){
            // 将堆顶元素与堆最后一个元素互换
            swap(arr,0,lastIndex);
            // 将堆的size-1   重新构建大顶堆
            //大约logn的时间复杂度
            heapify(arr,0,lastIndex-1);
        }
    }
    private static void heapify(int[] arr,int root,int lastIndex){ // 根据last,调整使之成为大顶堆
        int current = root;
        int left = 2*current+1;
        int right = 2*current+2;
        // 连左孩子都没有  直接无需调整
        if(left>lastIndex){
            return;
        // 如果有左孩子但没右孩子
        } else if(right>lastIndex){
            //如果左孩子比自己大
            if(arr[left]>arr[current]){
                //交换
                swap(arr,left,current);
                //交换后要重新以左孩子为起点 向下adjust堆
                heapify(arr,left,lastIndex);
            }
        //既有左孩子又有右孩子
        }else{
            //先找最大的孩子
            if(arr[right]> arr[left]){
                //如果左孩子大 再跟current比
                if(arr[right]>arr[current]){
                    swap(arr,right,current);
                    //交换后要重新以右孩子为起点 向下adjust堆
                    heapify(arr,right,lastIndex);
                }
            }else{
                if(arr[left]>arr[current]){
                    //如果右孩子大 再跟current比
                    swap(arr,left,current);
                    //交换后要重新以左孩子为起点 向下adjust堆
                    heapify(arr,left,lastIndex);
                }
            }
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
        //排序800w个[0,800w]的数据
        //用堆排序或快排大约4s左右
        //shell排序大约15s
        int i;
        int arr[]  = new int[8000000];
        for (i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }


//        int arr1[]  = new int[]{1,2,3,4,5,6,7,8};

//        fast(arr);
//        System.out.println("arr="+ Arrays.toString(arr));


        long startTime;
        long endTime;
        long usedTime;
        int j;
        int k;

        for (k = 0; k < 3; k++) {
            if(k==0){
                for (j = 0; j < 8000000; j++) {
//                    arr[j] = (int)(Math.random()*9999999);
                    arr[j] = j;
                }
                startTime =  System.currentTimeMillis();
                heapSort(arr);
                endTime =  System.currentTimeMillis();
                usedTime = (endTime-startTime);

                System.out.println("堆排序800w个元素耗时"+usedTime+"ms");
                int[] heapRes = java.util.Arrays.copyOf(arr,100);
                System.out.println("arr="+ Arrays.toString(heapRes));
                System.out.println("----------");
            }else if(k==1){
                for (j = 0; j < 8000000; j++) {
                    arr[j] = (int)(Math.random()*9999999);
//                    arr[j] = j;
                }
                startTime =  System.currentTimeMillis();
                fast(arr);
                endTime =  System.currentTimeMillis();
                usedTime = (endTime-startTime);
                System.out.println("快速排序800w个元素耗时"+usedTime+"ms");
                int[] fastRes = java.util.Arrays.copyOf(arr,100);
                System.out.println("arr="+ Arrays.toString(fastRes));
                System.out.println("----------");
            }else{
                for (j = 0; j < 8000000; j++) {
//                    arr[j] = (int)(Math.random()*9999999);
                    arr[j] = j;
                }
                startTime =  System.currentTimeMillis();
                shell(arr);
                endTime =  System.currentTimeMillis();
                usedTime = (endTime-startTime);
                System.out.println("shell排序800w个元素耗时"+usedTime+"ms");
                int[] shellRes = java.util.Arrays.copyOf(arr,100);
                System.out.println("arr="+ Arrays.toString(shellRes));

            }
        }
    }
}
