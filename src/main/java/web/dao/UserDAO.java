package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.*;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

@Component
@SuppressWarnings("unchecked")
public class UserDAO {

    private static int IDCounter = 2;

    private EntityManager em;
//    private EntityManagerFactory emf;

    @Autowired
    public UserDAO(LocalContainerEntityManagerFactoryBean lcemfb){
        EntityManagerFactory emf = lcemfb.getObject();
        em = emf.createEntityManager();
    }

    public List<User> getAllUsers(){
        List<User> results = em
                .createQuery("Select u from User u", User.class)
                .getResultList();
        return results;
    }

    public User getUser(int userID){
        User userToFind = new User();
        try{
            em.getTransaction().begin();
            userToFind = em.find(User.class, userID);
        } catch (Exception e){
            e.printStackTrace();
        }
        return userToFind;
    }

    public void saveUser(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void updateUser(int userID, User user){
        try{
            em.getTransaction().begin();
            User userToUpdate = em.find(User.class, userID);
            userToUpdate.setName(user.getName());
            userToUpdate.setAge(user.getAge());
            userToUpdate.setBalance(user.getBalance());
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveUsers(List<User> list){
        System.out.println("Trying to save users");
        System.out.println("Saving users (DAO)");
        try{
            em.getTransaction().begin();
            for (User user : list){
                em.persist(user);
            }
            em.getTransaction().commit();
        } catch (EntityExistsException e){
            System.out.println("User with id of some users exists");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAllUsers(){
        try {
            em.getTransaction().begin();
            em.createNativeQuery("truncate table user").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
