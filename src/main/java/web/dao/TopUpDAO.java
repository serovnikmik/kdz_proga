package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Component
public class TopUpDAO {

    private EntityManager em;

    @Autowired
    public TopUpDAO(LocalContainerEntityManagerFactoryBean lcemfb){
        EntityManagerFactory emf = lcemfb.getObject();
        em =emf.createEntityManager();
    }

    public User getUser(int id){
        Query query = em.createQuery(
                "select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        User res = (User) query.getSingleResult();
        return res;
    }

    public void topUp(int id, int quantity){
        try{
            em.getTransaction().begin();
            User userToUpdate = em.find(User.class, id);
            int pastBalance = userToUpdate.getBalance();
            userToUpdate.setBalance(pastBalance + quantity);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
