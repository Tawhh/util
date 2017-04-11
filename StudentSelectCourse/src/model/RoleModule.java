package model;



/**
 * RoleModule entity. @author MyEclipse Persistence Tools
 */

public class RoleModule  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Module module;
     private Role role;


    // Constructors

    /** default constructor */
    public RoleModule() {
    }

    
    /** full constructor */
    public RoleModule(Module module, Role role) {
        this.module = module;
        this.role = role;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
   








}