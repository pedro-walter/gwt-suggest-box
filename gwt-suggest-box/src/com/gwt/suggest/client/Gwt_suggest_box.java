package com.gwt.suggest.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.gwt.suggest.shared.Suggestion;

public class Gwt_suggest_box implements EntryPoint {

	AbsolutePanel rootPanel = new AbsolutePanel();
	static Login login;
	
	public void onModuleLoad() {

		System.out.println("Moduleload");

		loadSetup();

		// loadLogin();

	}

	private void loadSetup() {

		System.out.println("loadmain");

		// rootPanel.add(new Main());

		RootLayoutPanel.get().add(new Main());
		SuggestionServiceTest sst = new SuggestionServiceTest();
	}

	
	
	public static Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
		
}
