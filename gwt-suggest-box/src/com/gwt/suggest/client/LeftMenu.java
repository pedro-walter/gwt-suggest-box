package com.gwt.suggest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LeftMenu extends VerticalPanel {
	static Button novaS = new Button();
	static Button visualizar = new Button();
	Login l;

	public LeftMenu() {

		// sets
		novaS.setText("Nova Sugestao");
		visualizar.setText("Visualizar Sugestoes");

		// sets de tamanho para dar fit no panel
		novaS.setWidth("100px");
		visualizar.setWidth("100px");

		// actions
		novaS.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Main.midPanel.clear();
				Main.midPanel.add(new SuggestPanel());
				LeftMenu.setEnableLeftMenu(false);

			}

		});

		visualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Window.alert("Clicou em visualizar");

			}

		});

		this.add(novaS);
		this.add(visualizar);

	}

	public static void setEnableLeftMenu(boolean b) {
		novaS.setEnabled(b);
		visualizar.setEnabled(b);
	}

}
