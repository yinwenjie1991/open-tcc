package org.ywj.opentcc.common.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public class ArrayUtil extends ArrayUtils{
    /**
     * 递归地比较两个数组是否相同，支持多维数组。
     *
     * <p>
     * 如果比较的对象不是数组，则此方法的结果同<code>ObjectUtil.equals</code>。
     * </p>
     *
     * @param array1 数组1
     * @param array2 数组2
     *
     * @return 如果相等, 则返回<code>true</code>
     */
    @SuppressWarnings("rawtypes")
    public static boolean equals(Object array1, Object array2) {
        if (array1 == array2) {
            return true;
        }

        if ((array1 == null) || (array2 == null)) {
            return false;
        }

        Class clazz = array1.getClass();

        if (!clazz.equals(array2.getClass())) {
            return false;
        }

        if (!clazz.isArray()) {
            return array1.equals(array2);
        }

        // array1和array2为同类型的数组
        if (array1 instanceof long[]) {
            long[] longArray1 = (long[]) array1;
            long[] longArray2 = (long[]) array2;

            if (longArray1.length != longArray2.length) {
                return false;
            }

            for (int i = 0; i < longArray1.length; i++) {
                if (longArray1[i] != longArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof int[]) {
            int[] intArray1 = (int[]) array1;
            int[] intArray2 = (int[]) array2;

            if (intArray1.length != intArray2.length) {
                return false;
            }

            for (int i = 0; i < intArray1.length; i++) {
                if (intArray1[i] != intArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof short[]) {
            short[] shortArray1 = (short[]) array1;
            short[] shortArray2 = (short[]) array2;

            if (shortArray1.length != shortArray2.length) {
                return false;
            }

            for (int i = 0; i < shortArray1.length; i++) {
                if (shortArray1[i] != shortArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof byte[]) {
            byte[] byteArray1 = (byte[]) array1;
            byte[] byteArray2 = (byte[]) array2;

            if (byteArray1.length != byteArray2.length) {
                return false;
            }

            for (int i = 0; i < byteArray1.length; i++) {
                if (byteArray1[i] != byteArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof double[]) {
            double[] doubleArray1 = (double[]) array1;
            double[] doubleArray2 = (double[]) array2;

            if (doubleArray1.length != doubleArray2.length) {
                return false;
            }

            for (int i = 0; i < doubleArray1.length; i++) {
                if (Double.doubleToLongBits(doubleArray1[i]) != Double
                        .doubleToLongBits(doubleArray2[i])) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof float[]) {
            float[] floatArray1 = (float[]) array1;
            float[] floatArray2 = (float[]) array2;

            if (floatArray1.length != floatArray2.length) {
                return false;
            }

            for (int i = 0; i < floatArray1.length; i++) {
                if (Float.floatToIntBits(floatArray1[i]) != Float.floatToIntBits(floatArray2[i])) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof boolean[]) {
            boolean[] booleanArray1 = (boolean[]) array1;
            boolean[] booleanArray2 = (boolean[]) array2;

            if (booleanArray1.length != booleanArray2.length) {
                return false;
            }

            for (int i = 0; i < booleanArray1.length; i++) {
                if (booleanArray1[i] != booleanArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof char[]) {
            char[] charArray1 = (char[]) array1;
            char[] charArray2 = (char[]) array2;

            if (charArray1.length != charArray2.length) {
                return false;
            }

            for (int i = 0; i < charArray1.length; i++) {
                if (charArray1[i] != charArray2[i]) {
                    return false;
                }
            }

            return true;
        } else {
            Object[] objectArray1 = (Object[]) array1;
            Object[] objectArray2 = (Object[]) array2;

            if (objectArray1.length != objectArray2.length) {
                return false;
            }

            for (int i = 0; i < objectArray1.length; i++) {
                if (!equals(objectArray1[i], objectArray2[i])) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * 从字符串中截取字符串数组
     *
     * @param str
     * @param splitor
     * @return
     */
    public static String getRandomStrBySplitor(String str, String splitor) {
        return getRandomStr(str.split(splitor));
    }

    /**
     * 从数组中随机选取一个字符串 vm代码示例： #set($opIdArray=["002","008"])
     * #set($opId=$arrayUtil.getRandomStringFromList($opIdArray))
     *
     * @param array
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String getRandomStringFromList(List array) {
        return String.valueOf(array.get(RandomUtils.nextInt(array.size())));
    }

    /**
     * 生成只包含正整数，且每个数字唯一，顺序随机的数组 例如：getUniqueRandomArray(10) =
     * [5,0,3,2,6,4,7,9,1,8]
     *
     * @param size
     *            数组大小
     * @return
     */
    public static int[] getUniqueRandomArray(int size) {
        int[] result = new int[size];

        // 首先使用顺序填充，从0开始
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }

        // 使用Fisher–Yates shuffle算法进行随机排序
        for (int i = 0; i < size; i++) {
            int r = i + RandomUtils.nextInt(size - i);
            int swap = result[r];
            result[r] = result[i];
            result[i] = swap;
        }

        return result;

    }

    /**
     * 获取数组指定位置的值，用于解决Velocity中不支持原生[]语法的问题
     *
     * @param array
     * @param index
     * @return
     */
    public static String getStringByIndex(Object[] array, int index) {
        if (array == null || array[index] == null) {
            return null;
        }
        return String.valueOf(array[index]);
    }

    /**
     * 将字符串按分隔符切割后，返回LinkedList
     *
     * @param input
     * @param splitor
     * @return
     */
    public static LinkedList<String> getSplitList(String input, String splitor) {
        LinkedList<String> result = new LinkedList<String>();
        String[] array = input.split(splitor);
        Collections.addAll(result, array);

        return result;
    }

    /**
     * 对字符串列表进行排序
     *
     * @param list
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void sortList(List list) {
        Collections.sort(list);
    }

    /**
     * 获取随机数组中的任意一个值
     *
     * @param strArray
     * @return
     */
    private static String getRandomStr(String... strArray) {
        return strArray[(int) (Math.random() * strArray.length)];
    }

}
