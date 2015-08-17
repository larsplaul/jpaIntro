package test;

import entity.Project;
import entity.ProjectUser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Project p = em.find(Project.class, 1);
        System.out.println("Project Name: "+p.getName());
        System.out.println("Participants: ");
        for(ProjectUser user : p.getProjectUsers()){
            System.out.println(user.getUserName());
        }
        ProjectUser user1 = new ProjectUser("snls","snls.cphbusiness.dk");
        p.addUser(user1);
        user1.addProject(p);
        try{
            
            em.persist(user1);
            em.merge(p);
            em.getTransaction().commit();
            
        }finally{
            em.close();
        }
        
        
        
    }
}
