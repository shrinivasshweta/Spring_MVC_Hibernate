package com.stackroute.keepnote.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.exception.NoteNotFoundException;
import com.stackroute.keepnote.model.Note;

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
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public NoteDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Create a new note
	 */

	public boolean createNote(Note note) {
		note.setNoteCreatedAt(new Date());
		sessionFactory.getCurrentSession().save(note);
		return true;

	}

	/*
	 * Remove an existing note
	 */

	public boolean deleteNote(int noteId) {
	try {
		sessionFactory.getCurrentSession().delete(getNoteById(noteId));
	} catch (NoteNotFoundException e) {
		e.printStackTrace();
	}
	return true;
	}

	/*
	 * Retrieve details of all notes by userId
	 */

	public List<Note> getAllNotesByUserId(String userId) {
	List<Note> list = sessionFactory.getCurrentSession().createQuery("FROM Note where createdBy= :userId").setParameter("userId", userId).list();
	return list;
	}

	/*
	 * Retrieve details of a specific note
	 */

	public Note getNoteById(int noteId) throws NoteNotFoundException {
		Note note = sessionFactory.getCurrentSession().get(Note.class,noteId);
		if(note==null)
			throw new NoteNotFoundException("NoteNotFoundException");
		else
		return note;

	}

	/*
	 * Update an existing note
	 */

	public boolean UpdateNote(Note note) {
		sessionFactory.getCurrentSession().update(note);
		return true;

	}

}
