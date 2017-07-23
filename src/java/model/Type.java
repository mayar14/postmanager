package model;
// Generated May 25, 2017 6:09:16 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Type generated by hbm2java
 */
public class Type  implements java.io.Serializable {


     private Integer id;
     private String libelle;
     private Set sites = new HashSet(0);

    public Type() {
    }

	
    public Type(String libelle) {
        this.libelle = libelle;
    }
    public Type(String libelle, Set sites) {
       this.libelle = libelle;
       this.sites = sites;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Set getSites() {
        return this.sites;
    }
    
    public void setSites(Set sites) {
        this.sites = sites;
    }




}


