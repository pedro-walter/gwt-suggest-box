package com.gwt.suggest.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.suggest.shared.Suggestion;

@RemoteServiceRelativePath("suggestion")
public interface SuggestionService extends RemoteService {
	public void addSuggestion(Suggestion s);
	public Suggestion getSuggestion(Long id);
	public void removeSuggestion(Long id);
	public ArrayList<Suggestion> getAllSuggestions();
}
