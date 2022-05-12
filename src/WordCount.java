import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class WordCount {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String inputFile = "";// 定义待读取文件目录
        int charnum = 0; // 字符数
        int wordnum = 0; // 单词数
        boolean flag = true;
        while(flag){
            System.out.println(" -c  + 文件路径  返回文件的字符数");
            System.out.println(" -w  + 文件路径  返回文件词的数目");
            System.out.println("退出请输入exit");

            System.out.println("请输入指令:");
            InputStream iStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(iStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = bufferedReader.readLine();
            String[] strings = str.split("\\s");
            /**
             *  获取文件目录名
             */
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].endsWith(".txt"))
                    inputFile = strings[i];
            }
            /**
             * 字符数统计
             */
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals("-c")) { // -c对应字符个数统计
                    BufferedReader bff = new BufferedReader(new FileReader(inputFile));
                    String str1;
                    String str2 = bff.readLine();
                    while ((str1 = str2) != null) {
                        charnum = charnum + str1.length();
                        charnum++;
                        if ((str2 = bff.readLine()) == null){
                            charnum--;
                        }

                    }
                    bff.close();
                    String file = inputFile;
                    file = file.substring(file.lastIndexOf("\\") + 1, file.length());
                    System.out.println(file + ",字符个数:" + charnum);
                }
            }

            /**
             *  单词数统计
             */
            for (int i = 0; i < strings.length; i++){
                if (strings[i].equals("-w")) { // -w对应字符个数统计

                    BufferedReader bff = new BufferedReader(new FileReader(inputFile));
                    StringBuffer sBuffer = new StringBuffer();
                    String str1;
                    while ((str1 = bff.readLine()) != null)
                        sBuffer = sBuffer.append(str1 + " ");
                    str1 = sBuffer.toString();
                    /**
                     *  把中英文标点符号都替换为“ ”
                     */
                    String str2 = str1.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", " ");
                    String[] str3 = str2.split("\\s+");
                    wordnum = str3.length;
                    bff.close();
                    String file = inputFile;
                    file = file.substring(file.lastIndexOf("\\") + 1, file.length());
                    System.out.println(file + "单词个数:" + wordnum);
                }
            }
            /**
             * 设置一个循环退出flag
             */

            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals("exit")) {
                    flag =false;

                }
            }
        }
    }
}
