package com.gwt.suggest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

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

	}

}
