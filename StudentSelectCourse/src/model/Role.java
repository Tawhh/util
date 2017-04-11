package model;

import java.util.HashSet;
import java.util.Set;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer rid;
     private String rname;
     private Set roleModules = new HashSet(0);
     private Set users = new HashSet(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

    
    /** full constructor */
    public Role(String rname, Set roleModules, Set users) {
        this.rname = rname;
        this.roleModules = roleModules;
        this.users = users;
    }

   
    // Property accessors

    public Integer getRid() {
        return this.rid;
    }
    
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return this.rname;
    }
    
    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set getRoleModules() {
        return this.roleModules;
    }
    
    public void setRoleModules(Set roleModules) {
        this.roleModules = roleModules;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }
   








}