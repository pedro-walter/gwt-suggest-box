package com.gwt.suggest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends VerticalPanel{
		
	public Login(){
		AbsolutePanel botoes = new AbsolutePanel();
		Label user = new Label();
		Label pass = new Label();
		TextBox userT = new TextBox();
		PasswordTextBox passT = new PasswordTextBox();
		Button enviar = new Button();
		Button cancelar = new Button();
		
		//sets
		user.setText("Usuario");
		pass.setText("Senha");
		enviar.setText("Enviar");
		cancelar.setText("Cancelar");
		
		enviar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.alert("Clicou enviar");

			}

		});
		
		cancelar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Window.alert("Clicou cancelar");
				Main.midPanel.clear();
				MenuEsquerda.habilitaMenu(true);

			}

		});
		
		botoes.add(enviar);
		botoes.add(cancelar);
		
		//adds
		this.add(user);
		this.add(userT);
		this.add(pass);
		this.add(passT);
		this.add(botoes);
		
		System.out.println("construtor");
	}	
	
}
