package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher  implements java.io.Serializable {


    // Fields    

     private Integer tid;
     private String tname;
     private String sex;
     private String sc;
     private String major;
     private Set courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Teacher() {
    }

	/** minimal constructor */
    public Teacher(Integer tid) {
        this.tid = tid;
    }
    
    /** full constructor */
    public Teacher(Integer tid, String tname, String sex, String sc, String major,Set courses) {
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.sc = sc;
        this.major = major;
        this.courses = courses;
    }

   
    // Property accessors

    public Integer getTid() {
        return this.tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return this.tname;
    }
    
    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSc() {
        return this.sc;
    }
    
    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
   








}