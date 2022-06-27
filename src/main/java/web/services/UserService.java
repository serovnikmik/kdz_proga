package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import web.dao.UserDAO;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public void saveExampleUsers(){
        System.out.println("Trying to save users examples...");
        List<User> usersListExample = new ArrayList<>();

        User exampleUser1 = new User();
        User exampleUser2 = new User();
        User exampleUser3 = new User();

        exampleUser1.setLogin("filipp6860");
        exampleUser1.setPassword("#41286148d");
        exampleUser1.setBalance(1000);
        exampleUser1.setIp("1.11.1");
        exampleUser1.setChatId(0);
        exampleUser1.setDate(1);
        exampleUser1.setName("Name1");
        exampleUser1.setAge(11);

        exampleUser2.setLogin("serafima06071978");
        exampleUser2.setPassword("#0623f9925");
        exampleUser2.setBalance(50);
        exampleUser2.setIp("2.2.2.2");
        exampleUser2.setChatId(0);
        exampleUser2.setDate(11);
        exampleUser2.setName("Name2");
        exampleUser2.setAge(22);

        exampleUser3.setLogin("mark.poleshko");
        exampleUser3.setPassword("#bdd7ef563");
        exampleUser3.setBalance(1500);
        exampleUser3.setIp("1.2.3.1");
        exampleUser3.setChatId(1189485120);
        exampleUser3.setDate(27);
        exampleUser3.setName("Name3");
        exampleUser3.setAge(33);

        usersListExample.add(exampleUser1);
        usersListExample.add(exampleUser2);
        usersListExample.add(exampleUser3);

        userDAO.saveUsers(usersListExample);
    }

    public void deleteAllUsers(){
        userDAO.deleteAllUsers();
    }

}
