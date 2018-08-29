package com.stackroute.keepnote.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.keepnote.exception.NoteNotFoundException;
import com.stackroute.keepnote.exception.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with 
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, 
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class ReminderDAOImpl implements ReminderDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public ReminderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Create a new reminder
	 */

	public boolean createReminder(Reminder reminder) {
		reminder.setReminderCreationDate(new Date());

		sessionFactory.getCurrentSession().save(reminder);
		return true;
	}

	/*
	 * Update an existing reminder
	 */

	public boolean updateReminder(Reminder reminder) {
		try {
			if (getReminderById(reminder.getReminderId()) == null) {
				return false;
			} else {
				Date d =new Date();
				reminder.setReminderCreationDate(d);
				sessionFactory.getCurrentSession().update(reminder);
			}
		} catch (ReminderNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	/*
	 * Remove an existing reminder
	 */

	/*
	 * public boolean deleteReminder(int reminderId) { boolean flag = false; try {
	 * if(getReminderById(reminderId)==null) { flag = false; }else {
	 * sessionFactory.getCurrentSession().delete(getReminderById(reminderId)); flag
	 * = true; } } catch (ReminderNotFoundException e) { e.printStackTrace(); }
	 * return flag;
	 * 
	 * }
	 */

	public boolean deleteReminder(int reminderId) {
		boolean status = false;
		Reminder fetchedReminder = sessionFactory.getCurrentSession().get(Reminder.class, reminderId);
		if (fetchedReminder != null) {
			sessionFactory.getCurrentSession().delete(fetchedReminder);
			status = true;
		}
		
	

		return status;

	}

	/*
	 * Retrieve details of a specific reminder
	 */

	public Reminder getReminderById(int reminderId) throws ReminderNotFoundException {
		Reminder reminder = sessionFactory.getCurrentSession().get(Reminder.class, reminderId);
		if (reminder == null) {
			throw new ReminderNotFoundException("ReminderNotFoundException");
		}

		return reminder;
	}

	/*
	 * Retrieve details of all reminders by userId
	 */

	public List<Reminder> getAllReminderByUserId(String userId) {
		List<Reminder> result = sessionFactory.getCurrentSession()
				.createQuery("FROM Reminder where reminderCreatedBy = :userId ").setParameter("userId", userId).list();

		return result;
	}

}