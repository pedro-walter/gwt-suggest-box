package com.gwt.suggest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Hyperlink;

public class Main extends AbsolutePanel{
	final static AbsolutePanel midPanel = new AbsolutePanel();
	
	@SuppressWarnings("deprecation")
	public Main() {
		
		AbsolutePanel northPanel = new AbsolutePanel();
		AbsolutePanel botPanel = new AbsolutePanel();
		AbsolutePanel rootPanel = new AbsolutePanel();
		AbsolutePanel westPanel = new AbsolutePanel();
		Hyperlink login = new Hyperlink();
		
		// debug
		System.out.println("construtor");
		
		// estilos
		northPanel.setStyleName("header");
		midPanel.setStyleName("dockPanel");
		botPanel.setStyleName("dockPanel");
		westPanel.setStyleName("dockPanel");
		rootPanel.setStyleName("rootPanel");

		// tamanhos
		rootPanel.setSize("1024px", "1024px");
		northPanel.setSize("1000px", "200px");
		midPanel.setSize("893px", "586px");
		botPanel.setSize("1000px", "100px");
		westPanel.setSize("100px", "586px");
		
		login.setText("Login");
		login.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Window.alert("Clicou em link");
				midPanel.clear();
				midPanel.add(new LoginPanel());
				LeftMenu.setEnableLeftMenu(false);
				
			}

		});
		
		// add nos paineis
		westPanel.add(new LeftMenu());
		botPanel.add(login);
		
		
		//add os paineis
		rootPanel.add(northPanel, 0, 0);
		rootPanel.add(botPanel, 0, 800);
		rootPanel.add(midPanel, 107, 207);
		rootPanel.add(westPanel, 0, 207);
		
		this.add(rootPanel);
				
	}

}
