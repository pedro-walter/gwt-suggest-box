package com.gwt.suggest.server;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.suggest.client.SuggestionService;
import com.gwt.suggest.shared.Suggestion;

public class SuggestionServiceImpl extends RemoteServiceServlet implements
		SuggestionService {

	private static final Logger LOG = Logger
			.getLogger(SuggestionServiceImpl.class.getName());
	private static final PersistenceManagerFactory PMF = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	private PersistenceManager getPersistenceManager() {
		return PMF.getPersistenceManager();
	}

	@Override
	public void addSuggestion(Suggestion s) {
		LOG.log(Level.INFO, "addSuggestion");
		PersistenceManager pm = getPersistenceManager();
		try {
			pm.makePersistent(s);
		} finally {
			pm.close();
		}
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		LOG.log(Level.INFO, "getSuggestion -=- ID="+id.toString());
		PersistenceManager pm = getPersistenceManager();
		Suggestion returnedSuggestion = null;
		try {
			Query q = pm.newQuery(Suggestion.class, "id == id");
			q.declareParameters("com.gwt.suggest.shared.Suggestion.id id");
			returnedSuggestion = (Suggestion) q.execute(id);
		} finally {
			pm.close();
		}
		return returnedSuggestion;
	}

	@Override
	public ArrayList<Suggestion> getAllSuggestions() {
		LOG.log(Level.INFO, "getAllSuggestions");
		PersistenceManager pm = getPersistenceManager();
		ArrayList<Suggestion> returnedSuggestions = null;
		try {
			Query q = pm.newQuery(Suggestion.class);
			returnedSuggestions = (ArrayList<Suggestion>) q.execute();
		} finally {
			pm.close();
		}
		return returnedSuggestions;
	}

	@Override
	public void removeSuggestion(Long id) {
		LOG.log(Level.INFO, "removeSuggestion -=- ID="+id.toString());
		PersistenceManager pm = getPersistenceManager();
		try {
			Query q = pm.newQuery(Suggestion.class, "id == id");
			q.declareParameters("com.gwt.suggest.shared.Suggestion.id id");
			pm.deletePersistent((Suggestion) q.execute(id));
		} finally {
			pm.close();
		}
	}

}
