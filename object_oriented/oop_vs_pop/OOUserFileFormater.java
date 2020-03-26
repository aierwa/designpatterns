import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xuxiang
 * 2020/3/26
 * 面向对象的用户格式文件转换
 * 相比面向过程，这里的 User 是把 数据 和 方法 绑定在一起了。
 */
public class OOUserFileFormater {

    public void formatterUserFile(String sourcePath, String targetPath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetPath))) {

            List<User> users = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                users.add(User.parseFrom(line));
            }

            sortUsers(users);

            for (User user : users) {
                bufferedWriter.write(user.parseToText());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("error" + e.toString());
        }
    }

    /**
     * sort by user's age
     * @param users
     */
    private void sortUsers(List<User> users) {
        users.sort(Comparator.comparingInt(User::getAge));
    }

    public static void main(String[] args) {
        new OOUserFileFormater().formatterUserFile("D:\\temp\\sourceUsers.txt", "D:\\temp\\formattedUsers.txt");
    }

}
