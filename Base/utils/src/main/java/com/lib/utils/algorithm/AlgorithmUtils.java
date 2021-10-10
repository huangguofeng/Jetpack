package com.lib.utils.algorithm;

public class AlgorithmUtils {

    /**
     * 普通查找
     * @param array 数组
     * @param value 目标元素
     * @return 目标元素的索引，找不到返回-1
     */
    public static int search(int[] array, int value) {
        if(array==null || array.length == 0){
            return -1;
        }
        for (int i = 0, length = array.length; i < length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    /**
     * 二分查找
     * @param array 数组
     * @param value 目标元素
     * @return 目标元素的索引，找不到返回-1
     */
    public static int binarySearch(int[] array, int value) {
        if(array==null || array.length == 0){
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (value == array[middle]) {
                return middle;
            }
            if (value > array[middle]) {
                low = middle + 1;
            }
            if (value < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 差值查找
     * @param array 数组
     * @param value 目标元素
     * @return 目标元素的索引，找不到返回-1
     */
    public static int insertSearch(int[] array, int value) {
        if(array == null || array.length == 0){
            return -1;
        }
        return search2(array, value, 0, array.length - 1);
    }
    private static int search2(int array[], int value, int left, int right) {
        if (left > right)
            return -1;
        if (array[right] == array[left]) {
            if (array[right] == value)
                return right;
            else return -1;
        }
        int mid = left + (value - array[left]) / (array[right] - array[left]) * (right - left);
        if (array[mid] == value)
            return mid;
        if (array[mid] > value)
            return search2(array, value, left, mid - 1);
        return search2(array, value, mid + 1, right);
    }

    /**
     * 冒泡排序
     * @param array 待排序的数组
     * @return 排序后的数据
     */
    public static int[] bubbleSort(int[] array) {
        if(array == null || array.length < 2){
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    changeLocation(array, j, j+1);
                    flag = true;
                }
            }

            if (!flag) {
                // 没有发生交互，证明排序已经完成
                break;
            }
        }
        return array;
    }

    /**
     * 选择排序
     * @param array 待排序的数组
     * @return 排序后的数据
     */
    public static int[] selectSort(int[] array) {
        if(array == null || array.length < 2){
            return array;
        }
        // 数组长度
        int len = array.length;
        // 外层循环表示选择次数 进行选择的数组范围是left~right 没次选出一个最大值和最小值
        for (int left = 0, right = len - 1; left < right; left++, right--) {
            // 纪录最小和最大元素的索引 默认为待排序元素的首位和末位元素的索引
            int min = left;
            int max = right;
            // 内层循环排序 遍历待排序元素
            for (int i = left; i <= right; i++) {
                // 如果待排序中的某元素小于指定的最小元素
                if (array[i] < array[min]){
                    // 则该元素的的索引就是最小值索引
                    min = i;
                }
                // 如果待排序中的某元素大于指定的最大元素
                if (array[i] > array[max]){
                    // 则该元素的的索引就是最大值索引
                    max = i;
                }
            }
            // 如果待排序元素首位索引left和最小元素的索引min相等
            if(left == min){
                //表示待排序元素首位就是最小值，不需要进行交换
            }else{
                // 首位不是最小值，交换首位和最小值的位置
                changeLocation(array, left, min);
            }
            // 如果待排序元素首位的索引left和最大元素的索引max相等
            if(left == max){
                // 如果首位是最大值，上面一步已经最大值和最小值进行了交换，
                // 首位索引left对应的是最小值，最大值对应的索引是min，所以此时最大值的的索引max应该改为min
                max = min;
            }
            // 如果待排序元素末位索引right和最大元素的索引max相等
            if(right == max){
                //表示待排序元素末位就是最大值，不需要进行交换
            }else{
                //末位不是最大值，交换末位和最大值的位置
                changeLocation(array,right,max);
            }
        }
        return array;
    }
    // 位置互换
    private static void changeLocation(int[] array,int a,int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    /**
     * 插入排序
     * @param array 待排序的数组
     * @return 排序后的数组
     */
    public static int[] insertSort(int[] array) {
        if(array == null || array.length < 2){
            return array;
        }
        // 外层循环为插入的次数 从第二位元素开始算次数
        for (int i = 0; i < array.length - 1; i++) {
            // 把准备插入的元素记为临时变量 array[0]不参与排序，从第二位array[1]开始算 i+1就是要插入的元素的索引
            int temp = array[i + 1];
            // 首次比较的是要插入元素和该元素的前一位，i就是前一位元素的的索引
            int preIndex = i;
            // 比较要插入的元素和前一位元素，如果准备插入的元素小于前一位的元素
            while (preIndex >= 0 && temp < array[preIndex]) {
                // 前一位元素向后移动一位 索引变成要插入元素原来的位置
                array[preIndex + 1] = array[preIndex];
                // 索引自减1，继续循环向更前一位比较
                preIndex--;
            }
            // 一直比较到要插入元素大于某一个元素或者索引preIndex为负数，没有元素可以比较，把要插入元素放在要比较元素索引后面，要比较的元素索引为preIndex，所以插入元素最终的位置就是preIndex+1
            array[preIndex + 1] = temp;
        }
        return array;
    }

    /**
     * 快速排序
     * @param array 待排序的数组
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] array,int begin,int end) {
        if(array == null || array.length < 2){
            return array;
        }

        //如果区间不只一个数
        if(begin < end) {
            int temp = array[begin]; //将区间的第一个数作为基准数
            int i = begin; //从左到右进行查找时的“指针”，指示当前左位置
            int j = end; //从右到左进行查找时的“指针”，指示当前右位置
            //不重复遍历
            while(i < j) {
                //当右边的数大于基准数时，略过，继续向左查找
                //不满足条件时跳出循环，此时的j对应的元素是小于基准元素的
                while(i<j && array[j] > temp){
                    j--;
                }
                //将右边小于等于基准元素的数填入左边相应位置
                array[i] = array[j];
                //当左边的数小于等于基准数时，略过，继续向右查找
                //(重复的基准元素集合到左区间)
                //不满足条件时跳出循环，此时的i对应的元素是大于等于基准元素的
                while(i<j && array[i] <= temp){
                    i++;
                }
                //将左边大于基准元素的数填入右边相应位置
                array[j] = array[i];
            }
            //将基准元素填入相应位置
            array[i] = temp;
            //此时的i即为基准元素的位置
            //对基准元素的左边子区间进行相似的快速排序
            quickSort(array,begin,i-1);
            //对基准元素的右边子区间进行相似的快速排序
            quickSort(array,i+1,end);
        }
        //如果区间只有一个数，则返回
        return array;
    }
}
