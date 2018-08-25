package FileTraversal;

import java.io.File;
import java.util.Scanner;

/*
 * @author zhenshan
 */
public class FileTraversal {

    public static void main(String[] args) {
        File dir = getDir();
        fileTraversal(dir, 1);

    }

    public static File getDir() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径：");

        while (true) {
            //将键盘录入对象的结果存储并封装成File对象            
            String line = sc.nextLine();
            File dir = new File(line);
            if (!dir.exists()) {
                System.out.println("录入文件夹不存在，请输入一个文件夹路径");
            } else if (dir.isFile()) {
                System.out.println("您录入的文件路径，请输入文件夹路径");
            } else {
                return dir;
            }
        }
    }

    public static void fileTraversal(File dir, int depth) {

        int thedepth = depth;

        //获取该文件夹下所有文价和文件夹
        File[] subFiles = dir.listFiles();
        //遍历
        System.out.println(dir.getName());
        for (File subFile : subFiles) {
            if (subFile.isFile()) {
                for (int i = 0; i < thedepth; i++) {
                    System.out.print(" ");
                }
                System.out.println(subFile.getName());
            } else {
                //如果是文件夹
                for (int i = 0; i < thedepth; i++) {
                    System.out.print(" ");
                }
                thedepth++;//进文件夹层数+1
                fileTraversal(subFile, thedepth);
                thedepth--;//出文件夹层数-1
            }
        }

    }
}
