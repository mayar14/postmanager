/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Quartier;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import orm.HibernateUtil;

/**
 *
 * @author Rabab
 */
@RequestScoped
@Named("QuartierService")
public class QuartierService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public QuartierService () {
    }
        
        
        
    public ArrayList<Quartier> getAllQuartier(){
        ArrayList<Quartier> allQuartier = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Quartier q order by q.nom");
            allQuartier= (ArrayList<Quartier>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllQuartier\n"+e);
		}
        return allQuartier;
    }
    
    
    
    
 
    
    
    
    public int deleteQuartier(Quartier QuartierToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Quartier q where q.id=?";
            Query req = session.createQuery(strReq).setInteger(0, QuartierToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Quartier supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteQuartier\n"+e);
		}
		return result;
	}
	
	public int updateQuartier(Quartier QuartierToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(QuartierToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Quartier etait  ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateQuartier\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param QuartierToUpdate
     * @return
     */
    public int addQuartier(Quartier QuartierToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(QuartierToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Quartier  Ajouté avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println(e+"Erreur dans addQuartier\n");
            session.close();
		}
		return result;
	}
}


