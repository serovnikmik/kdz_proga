package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.TopUpDAO;
import web.models.User;

@Component
public class TopUpService {

    private TopUpDAO topUpDAO;

    @Autowired
    public TopUpService(TopUpDAO topUpDAO){
        this.topUpDAO = topUpDAO;
    }

    public User getUser(int id) {
        return topUpDAO.getUser(id);
    }

    public void topUp(int id, int quantity){
        topUpDAO.topUp(id, quantity);
    }

}
