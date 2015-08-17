/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ProjectUser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lam
 */
public class dbFacade {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa1PU");
     
  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
  
  public ProjectUser getUser(int id){
       EntityManager em = getEntityManager();
    ProjectUser user = em.find(ProjectUser.class, id);
    em.close();
    return user;
  }
}
