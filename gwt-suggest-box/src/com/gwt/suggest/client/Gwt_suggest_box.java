package com.gwt.suggest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.gwt.suggest.shared.Suggestion;

public class Gwt_suggest_box implements EntryPoint {

	AbsolutePanel rootPanel = new AbsolutePanel();

	public void onModuleLoad() {

		System.out.println("Moduleload");

		loadSetup();

		// loadLogin();

	}

	private void loadSetup() {
		
		System.out.println("loadmain");

		//rootPanel.add(new Main());

		RootLayoutPanel.get().add(new Main());

		testGet();
	}
	
	private void testCreate(){
		SuggestionServiceAsync ssa = GWT.create(SuggestionService.class);
		Suggestion s = new Suggestion();
		s.setId(Long.valueOf("1"));
		s.setSubject("Test Suggestion");
		s.setContent("This is a test suggestion, it doesn't mean anything!");
		ssa.addSuggestion(s, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				System.out.println("Suggestion creation was succesful. Congratulations!");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Suggestion creation was not succesful, you better fix this, jerk!");
			}
		});
	}
	
	
	
	private void testGet(){
		SuggestionServiceAsync ssa = GWT.create(SuggestionService.class);
		ssa.getSuggestion(Long.valueOf(1), new AsyncCallback<Suggestion>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Suggestion getting was not succesful, you better fix this, jerk!");
			}

			@Override
			public void onSuccess(Suggestion result) {
				System.out.println("Suggestion getting was succesful. Congratulations!");
			}
		});
	}
}
