package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private String description;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;
    
    @OneToMany
    @JoinColumn(name="PROJECT_ID")
    List<Task> tasks = new ArrayList();

    public List<ProjectUser> getProjectUsers() {
        return projectUsers;
    }
    
    public void addUser(ProjectUser pu){
        projectUsers.add(pu);
    }
    
    
    @ManyToMany(mappedBy = "projects")
    @JoinTable(name="PROJECTUSER_PROJECT")
    private List<ProjectUser> projectUsers;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = new Date();
        this.lastModified = new Date();
    }

    public Project() {
    }
    
    
    public void addTask(Task t){
        if(tasks == null){
            tasks = new  ArrayList();
        }
        tasks.add(t);
        t.addProject(this);
    }
    
  
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    

    public Integer getId() {
        return id;
    }

  
    
}
