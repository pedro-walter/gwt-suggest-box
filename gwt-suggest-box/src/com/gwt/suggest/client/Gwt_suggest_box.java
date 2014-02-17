package com.gwt.suggest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Gwt_suggest_box implements EntryPoint {
	AbsolutePanel rootPanel = new AbsolutePanel();
	
	public void onModuleLoad() {
		
		System.out.println("Moduleload");
		
		loadLogin();
	
	}

	private void loadLogin() {
		
		System.out.println("loadlogin");
		
		rootPanel.add(new Login());
		
		RootLayoutPanel.get().add(rootPanel);
		
	}
}
