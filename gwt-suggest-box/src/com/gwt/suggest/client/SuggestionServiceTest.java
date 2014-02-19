package com.gwt.suggest.client;

import java.util.ArrayList;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.suggest.shared.Suggestion;

public class SuggestionServiceTest {
	
	public SuggestionServiceTest(){
		testGetAll();
	}
	
	private void testCreate() {
		SuggestionServiceAsync ssa = GWT.create(SuggestionService.class);
		final Suggestion s = new Suggestion();
		// s.setId(Long.valueOf("1"));
		s.setSubject("Test Suggestion");
		s.setContent("This is a test suggestion, it doesn't mean anything!");
		ssa.addSuggestion(s, new AsyncCallback<Long>() {

			@Override
			public void onSuccess(Long result) {
				System.out
						.println("Suggestion creation was succesful. Congratulations!");
				System.out.println("Suggestion=" + result);
				if (result == null) {
					System.out.println("Returned suggestion is null!");
				} else {
					System.out.println("Suggestion ID=" + result);
					testGet(result);
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				System.out
						.println("Suggestion creation was not succesful, you better fix this, jerk!");
			}
		});
	}

	private void testGet(Long id) {
		SuggestionServiceAsync ssa = GWT.create(SuggestionService.class);
		ssa.getSuggestion(id, new AsyncCallback<Suggestion>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out
						.println("Suggestion getting was not succesful, you better fix this, jerk!");
			}

			@Override
			public void onSuccess(Suggestion result) {
				System.out
						.println("Suggestion getting was succesful. Congratulations!");
				System.out.println("Suggestion subject = '"
						+ result.getSubject() + "'");
				System.out.println("Suggestion content = '"
						+ result.getContent() + "'");
				testRemove(result.getId());
			}
		});
	}

	private void testRemove(Long id) {
		SuggestionServiceAsync ssa = GWT.create(SuggestionService.class);
		ssa.removeSuggestion(id, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out
						.println("Suggestion removal was not succesful, you better fix this, jerk!");
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("Suggestion removal was succesful. Congratulations!");
			}
		});
	}

	private void testGetAll() {
		SuggestionServiceAsync ssa = GWT.create(SuggestionService.class);
		ssa.getAllSuggestions(new AsyncCallback<ArrayList<Suggestion>>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Suggestion RETRIEVAL was not succesful, you better fix this, jerk!");
				
			}

			@Override
			public void onSuccess(ArrayList<Suggestion> result) {
				System.out.println("Suggestion RETRIEVAL was succesful. Congratulations!");
			}
		});
	}
}
