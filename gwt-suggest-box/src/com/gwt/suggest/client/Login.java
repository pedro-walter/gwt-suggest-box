package com.gwt.suggest.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class Login extends AbsolutePanel{
	AbsolutePanel aux = new AbsolutePanel();
	
	public Login(){
		Label user = new Label();
		Label pass = new Label();
		TextBox userT = new TextBox();
		PasswordTextBox passT = new PasswordTextBox();
		Button enviar = new Button();
		
		//sets
		user.setText("Usuario");
		pass.setText("Senha");
		enviar.setText("Enviar");
		
		//adds
		this.add(user);
		this.add(userT);
		this.add(pass);
		this.add(passT);
		this.add(enviar);
		
		System.out.println("construtor");
	}	
	
}
