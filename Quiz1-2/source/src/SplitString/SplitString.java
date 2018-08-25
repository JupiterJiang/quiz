package SplitString;

import java.util.Scanner;

/**
 *
 * @author zhenshan
 */
public class SplitString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("请输入为一个字符串和字节数，将输出按字节截取的字符串");

            String str = sc.next();//读取字符串
            int num = sc.nextInt();//读取字节数

            byte[] arr = str.getBytes();//字符串转为字节

            //判断字节数大小是否符合实际
            if (num <= arr.length && num > 0) {
                int times = 0;
                for (int i = 0; i < num; i++) {
                    //汉字被打散后为两个负数
                    if (arr[i] < 0) {
                        times++;
                    }
                }
                if (times % 2 == 1) {
                    num--;
                }
                String result = new String(arr, 0, num);//字节转成字符串
                System.out.println(result);
            } else {
                System.out.println("输入有误");
            }
        }

    }
}
