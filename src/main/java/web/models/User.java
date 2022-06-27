package web.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "user")
public class User{

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="balance")
    private int balance;

    @Column(name="ip")
    private String ip;

    @Column(name="chatId")
    private int chatId;

    @Column(name="date")
    private int date;

    public User(){

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, int balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public User(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.Id = id;
    }

    public User(int id, String name, int age, int balance) {
        this.name = name;
        this.age = age;
        this.Id = id;
        this.balance = balance;
    }

    public User(int id, String name, int age,
                String login, String password, int balance,
                String ip, int chatId, int date) {
        Id = id;
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.ip = ip;
        this.chatId = chatId;
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getIp() {
        return ip;
    }

    public int getChatId() {
        return chatId;
    }

    public int getDate() {
        return date;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
