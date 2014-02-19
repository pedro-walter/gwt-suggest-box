package com.gwt.suggest.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
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
	public long addSuggestion(Suggestion s) {
		LOG.log(Level.INFO, "addSuggestion");
		PersistenceManager pm = getPersistenceManager();
		try {
			pm.makePersistent(s);
		} finally {
			pm.close();
		}
		return s.getId();
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		LOG.log(Level.INFO, "getSuggestion -=- ID="+id.toString());
		PersistenceManager pm = getPersistenceManager();
		try {
			Key k = KeyFactory.createKey(Suggestion.class.getSimpleName(), id);
			return pm.getObjectById(Suggestion.class,k);
		} finally {
			pm.close();
		}
	}

	@Override
	public ArrayList<Suggestion> getAllSuggestions() {
		LOG.log(Level.INFO, "getAllSuggestions");
		PersistenceManager pm = getPersistenceManager();
		ArrayList<Suggestion> returnedSuggestions = new ArrayList<Suggestion>();
		try {
			Query q = pm.newQuery(Suggestion.class, "content != foo");
			q.declareParameters("String foo");
			System.out.println("query created");
			returnedSuggestions = (ArrayList<Suggestion>) q.execute("");
			System.out.println("query executed");
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
			Key k = KeyFactory.createKey(Suggestion.class.getSimpleName(), id);
			pm.deletePersistent(pm.getObjectById(Suggestion.class,k));
		} finally {
			pm.close();
		}
	}

}
