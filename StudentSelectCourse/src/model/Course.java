package model;

import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private Integer cid;
     private Teacher teacher;
     private String cname;
     private String classTime;
     private Integer credit;
     private Integer classHour;
     private Integer classType;
     private String classAddr;
     private Integer classProperty;
     private Set stuCous = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

	/** minimal constructor */
    public Course(Integer cid, Integer classType) {
        this.cid = cid;
        this.classType = classType;
    }
    
    /** full constructor */
    public Course(Integer cid, Teacher teacher, String cname, String classTime, Integer credit, Integer classHour, Integer classType, String classAddr, Integer classProperty, Set stuCous) {
        this.cid = cid;
        this.teacher = teacher;
        this.cname = cname;
        this.classTime = classTime;
        this.credit = credit;
        this.classHour = classHour;
        this.classType = classType;
        this.classAddr = classAddr;
        this.classProperty = classProperty;
        this.stuCous = stuCous;
    }

   
    // Property accessors

    public Integer getCid() {
        return this.cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCname() {
        return this.cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getClassTime() {
        return this.classTime;
    }
    
    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public Integer getCredit() {
        return this.credit;
    }
    
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getClassHour() {
        return this.classHour;
    }
    
    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getClassType() {
        return this.classType;
    }
    
    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public String getClassAddr() {
        return this.classAddr;
    }
    
    public void setClassAddr(String classAddr) {
        this.classAddr = classAddr;
    }

    public Integer getClassProperty() {
        return this.classProperty;
    }
    
    public void setClassProperty(Integer classProperty) {
        this.classProperty = classProperty;
    }

    public Set getStuCous() {
        return this.stuCous;
    }
    
    public void setStuCous(Set stuCous) {
        this.stuCous = stuCous;
    }
   








}