import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xuxiang
 * 2020/3/26
 * 面向过程的用户格式文件转换 （其实不完全算，因为已经抽象成一个 Formater 对象了）
 */
public class UserFileFormater {

    public void formatterUserFile(String sourcePath, String targetPath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetPath))) {

            List<User> users = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                users.add(parseToUser(line));
            }

            sortUsers(users);

            for (User user : users) {
                bufferedWriter.write(formatFromUser(user));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("error" + e.toString());
        }
    }

    /**
     * line to User
     * @param line
     * @return
     */
    private User parseToUser(String line) {
        String[] arr = line.split("&");
        if (arr.length != 3) {
            return null;
        }
        User user = new User();
        user.setName(arr[0]);
        user.setAge(Integer.parseInt(arr[1]));
        user.setGender(arr[2]);
        return user;
    }

    /**
     * User to String
     * @param user
     * @return
     */
    private String formatFromUser(User user) {
        if (user == null) {
            return null;
        }
        return user.getName() + "\t" + user.getAge() + "\t" + user.getGender();
    }

    /**
     * sort by user's age
     * @param users
     */
    private void sortUsers(List<User> users) {
        users.sort(Comparator.comparingInt(User::getAge));
    }

    public static void main(String[] args) {
        new UserFileFormater().formatterUserFile("D:\\temp\\sourceUsers.txt", "D:\\temp\\formattedUsers.txt");
    }

}
