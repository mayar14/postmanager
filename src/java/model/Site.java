package model;
// Generated May 25, 2017 6:09:16 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Site generated by hbm2java
 */
public class Site  implements java.io.Serializable {


     private Integer id;
     private Region region;
     private Type type;
     private String nom;
     private String zone;
     private Set secteurs = new HashSet(0);
     private Set villes = new HashSet(0);

    public Site() {
    }

	
    public Site(Region region, Type type, String nom, String zone) {
        this.region = region;
        this.type = type;
        this.nom = nom;
        this.zone = zone;
    }
    public Site(Region region, Type type, String nom, String zone, Set secteurs, Set villes) {
       this.region = region;
       this.type = type;
       this.nom = nom;
       this.zone = zone;
       this.secteurs = secteurs;
       this.villes = villes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Region getRegion() {
        return this.region;
    }
    
    public void setRegion(Region region) {
        this.region = region;
    }
    public Type getType() {
        return this.type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getZone() {
        return this.zone;
    }
    
    public void setZone(String zone) {
        this.zone = zone;
    }
    public Set getSecteurs() {
        return this.secteurs;
    }
    
    public void setSecteurs(Set secteurs) {
        this.secteurs = secteurs;
    }
    public Set getVilles() {
        return this.villes;
    }
    
    public void setVilles(Set villes) {
        this.villes = villes;
    }




}


