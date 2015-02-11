package fr.istic.egotcha.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.jdbc.PreparedStatement;

import fr.istic.egotcha.model.PlayerLocation;
import fr.istic.egotcha.model.Player;
import fr.istic.egotcha.util.HibernateUtil;

public class DAO {

	private SessionFactory sessionFactory;

	public DAO() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void addPlayer(Player j) {

		if (!verifPseudo(j.getPseudo())) {
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				session.save(j);
				transaction.commit();
			} catch (HibernateException e) {

				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		else 
		{
			System.out.println("Player already exists");
		}

	}

	public void modifyPlayer(int id, String pseudo, String password,
			String firstname, String lastname, Date birthday, String mail) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Player player = (Player) session.load(Player.class, id);
			if (player != null) {
				player.setFirstname(firstname);
				player.setLastname(lastname);
				player.setPseudo(pseudo);
				player.setBirthday(birthday);
				player.setMail(mail);
				session.update(player);

			}
			transaction.commit();

		} catch (HibernateException e) {

			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deletePlayer(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Player j = (Player) session.load(Player.class, id);
		session.delete(j);
		session.getTransaction().commit();
	}

	public Player getPlayerbyID(int idPlayer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		transaction = session.beginTransaction();

		Player j = (Player) session.load(Player.class, idPlayer);
		Player jt = new Player(j.getPseudo(), j.getPassword(),
				j.getFirstname(), j.getLastname(), j.getBirthday(), j.getMail());

		jt.setId(j.getId());
		jt.setPositions(j.getPositions());

		return jt;

	}

	public Player getPlayerbyPseudo(String pseudo) {
		Player player = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		transaction = session.beginTransaction();
		player = (Player) session.createQuery(
				"from Player where pseudo ='" + pseudo + "'").uniqueResult();
		return player;
	}

	public List<Player> getAllPlayer() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		return session.createQuery("from Player").list();
	}
	public boolean verifPseudo(String pseudo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Iterator<Player> player = session.createQuery( "from Player where pseudo ='" + pseudo + "'").list().iterator();
		if (player.hasNext())
			return true;
		else 
			return false;
		
	}

	/*
	 * public void sauveIMG(String location, String name) throws Exception {
	 * File monImage = new File(location); FileInputStream istreamImage = new
	 * FileInputStream(monImage); try { Connection conn; PreparedStatement ps =
	 * conn.prepareStatement("insert into image (name, img) values (?,?)"); try
	 * { ps.setString(1, name); ps.setBinaryStream(2, istreamImage, (int)
	 * monImage.length()); ps.executeUpdate(); } finally { ps.close(); } }
	 * finally { istreamImage.close(); } }
	 */
}
