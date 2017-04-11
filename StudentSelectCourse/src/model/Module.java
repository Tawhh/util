package model;

import java.util.HashSet;
import java.util.Set;


/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Module module;
     private String mname;
     private String murl;
     private Integer myid;
     private Set roleModules = new HashSet(0);
     private Set modules = new HashSet(0);


    // Constructors

    /** default constructor */
    public Module() {
    }

    
    /** full constructor */
    public Module(Module module, String mname, String murl, Integer myid, Set roleModules, Set modules) {
        this.module = module;
        this.mname = mname;
        this.murl = murl;
        this.myid = myid;
        this.roleModules = roleModules;
        this.modules = modules;
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

    public String getMname() {
        return this.mname;
    }
    
    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMurl() {
        return this.murl;
    }
    
    public void setMurl(String murl) {
        this.murl = murl;
    }

    public Integer getMyid() {
        return this.myid;
    }
    
    public void setMyid(Integer myid) {
        this.myid = myid;
    }

    public Set getRoleModules() {
        return this.roleModules;
    }
    
    public void setRoleModules(Set roleModules) {
        this.roleModules = roleModules;
    }

    public Set getModules() {
        return this.modules;
    }
    
    public void setModules(Set modules) {
        this.modules = modules;
    }
   








}