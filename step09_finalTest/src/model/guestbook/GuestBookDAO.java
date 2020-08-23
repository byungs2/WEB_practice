package model.guestbook;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.DataSourceManager;

public class GuestBookDAO {
	
	public static boolean writeContent(GuestBookBean vo) throws SQLException{
		Date time = null;
		SimpleDateFormat simpleformat = null;
		EntityManager em = DataSourceManager.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		try {
			tx.begin();
			time = new Date();
			simpleformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			GuestBookBean gbb = new GuestBookBean(vo.getTitle(),vo.getAuthor(),vo.getEmail(),vo.getContent(),vo.getPassword(), simpleformat.format(time));
			em.persist(gbb);
			tx.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			em.close();
		}
		return result;		
	}
	
	public static GuestBookBean getContent(int num, boolean flag) throws SQLException{		
		EntityManager em = DataSourceManager.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		GuestBookBean vo  = null;
		try {
			if(flag){
				tx.begin();
				GuestBookBean gbb = em.find(GuestBookBean.class, num);
				gbb.setReadnum(gbb.getReadnum() + 1);
				tx.commit();
			}
			vo = (GuestBookBean) em.createNamedQuery("GuestBookBean.FindBynum").setParameter("num", num).getSingleResult();
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			em.close();
		}
		return vo;
	}
	
	public  static boolean deleteContent(int num, String password) throws SQLException{
		EntityManager em = DataSourceManager.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		try {
			tx.begin();
			em.remove((GuestBookBean) em.createNamedQuery("GuestBookBean.FindBynumPass").setParameter("num", num).setParameter("password", password).getSingleResult());
			tx.commit();
			result = true;
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			em.close();
		}
		return result;
	}
	
	public  static boolean updateContent(GuestBookBean vo) throws SQLException{
		EntityManager em = DataSourceManager.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		try {
			tx.begin();
			GuestBookBean gbb = (GuestBookBean) em.createNamedQuery("GuestBookBean.FindBynumPass").setParameter("num", vo.getNum()).setParameter("password", vo.getPassword()).getSingleResult();
			gbb.setAuthor(vo.getAuthor());
			gbb.setContent(vo.getContent());
			gbb.setEmail(vo.getEmail());
			gbb.setPassword(vo.getPassword());
			gbb.setTitle(vo.getTitle());
			tx.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			em.close();
		}
		return result;
	}
	public static ArrayList<GuestBookBean> getAllContents() throws SQLException{
		EntityManager em = DataSourceManager.getEntityManger();
		ArrayList<GuestBookBean> alist = null;
		try {
			alist = (ArrayList<GuestBookBean>) em.createNamedQuery("GuestBookBean.FindAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			em.close();
		}
		return alist;
	}
}
