package com.gwt.suggest.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.suggest.shared.Suggestion;

public interface SuggestionServiceAsync {

	void addSuggestion(Suggestion s, AsyncCallback<Void> callback);

	void getAllSuggestions(AsyncCallback<ArrayList<Suggestion>> callback);

	void getSuggestion(Long id, AsyncCallback<Suggestion> callback);

	void removeSuggestion(Long id, AsyncCallback<Void> callback);

}
