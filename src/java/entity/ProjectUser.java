package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author lam
 */
@Entity
@Table(name="PROJECT_USER")
public class ProjectUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String email;
    
    @ManyToMany
    @JoinTable(name="PROJECTUSER_PROJECT")
    List<Project> projects = new ArrayList();
    
    
    public void addProject(Project p){
        this.projects.add(p);
    }
    
      public List<Project> getProjects(){
        return projects;
        
    }
   

    public ProjectUser(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.created = new Date();
    }

    public ProjectUser() {
    }
    
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    

    public Integer getId() {
        return id;
    }


  
    
}
