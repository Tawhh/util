package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer sid;
     private String sname;
     private Integer sex;
     private String sc;
     private String major;
     private Integer sumClassHour;
     private Integer sumCredit;
     private Set stuCous = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(Integer sid) {
        this.sid = sid;
    }
    
    /** full constructor */
    public Student(Integer sid, String sname, Integer sex, String sc, String major, Integer sumClassHour, Integer sumCredit, Set stuCous) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.sc = sc;
        this.major = major;
        this.sumClassHour = sumClassHour;
        this.sumCredit = sumCredit;
        this.stuCous = stuCous;
    }

   
    // Property accessors

    public Integer getSid() {
        return this.sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
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

    public Integer getSumClassHour() {
        return this.sumClassHour;
    }
    
    public void setSumClassHour(Integer sumClassHour) {
        this.sumClassHour = sumClassHour;
    }

    public Integer getSumCredit() {
        return this.sumCredit;
    }
    
    public void setSumCredit(Integer sumCredit) {
        this.sumCredit = sumCredit;
    }

    public Set getStuCous() {
        return this.stuCous;
    }
    
    public void setStuCous(Set stuCous) {
        this.stuCous = stuCous;
    }
   








}