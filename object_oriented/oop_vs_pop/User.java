/**
 * @author xuxiang
 * 2020/3/26
 */
public class User {
    private String name;
    private int age;
    private String gender;

    public User(){}

    public User(String name, int age, String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public static User parseFrom(String userString){
        String[] arr = userString.split("&");
        if (arr.length != 3) {
            return null;
        }
        return new User(arr[0], Integer.parseInt(arr[1]), arr[2]);
    }

    public String parseToText() {
        return this.name + "\t" + this.age + "\t" +this.gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
