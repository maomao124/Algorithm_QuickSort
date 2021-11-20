/**
 * Project name(项目名称)：算法_快速排序
 * Package(包名): PACKAGE_NAME
 * Class(类名): QuickSort
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 14:18
 * Version(版本): 1.0
 * Description(描述)：
 * 快速排序算法是在分治算法基础上设计出来的一种排序算法，和其它排序算法相比，快速排序算法具有效率高、耗费资源少、容易实现等优点。
 * 快速排序算法的实现思路是：
 * 从待排序序列中任选一个元素（假设为 pivot）作为中间元素，将所有比 pivot 小的元素移动到它的左边，所有比 pivot 大的元素移动到它的右边；
 * pivot 左右两边的子序列看作是两个待排序序列，各自重复执行第一步。直至所有的子序列都不可再分（仅包含 1 个元素或者不包含任何元素），整个序列就变成了一个有序序列。
 */

public class QuickSort
{
    public static void sort(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
            print(arr);
        }
    }

    private static int getIndex(int[] arr, int low, int high)
    {
        // 基准数据
        int tmp = arr[low];
        while (low < high)
        {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp)
            {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp)
            {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    private static void print(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
