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

public class LoginPanel extends VerticalPanel{
	Login l;
		
	public LoginPanel(){
		AbsolutePanel botoes = new AbsolutePanel();
		Label user = new Label();
		Label pass = new Label();
		final TextBox userT = new TextBox();
		final PasswordTextBox passT = new PasswordTextBox();
		Button enviar = new Button();
		Button cancelar = new Button();
		
		//sets
		user.setText("Usuario");
		pass.setText("Senha");
		enviar.setText("Enviar");
		cancelar.setText("Cancelar");
		
		enviar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				l=Gwt_suggest_box.getLogin();
				System.out.println(l);
				if(l==null){
					Window.alert("caiu no if");
				}else{
					Window.alert("caiu no else");
				}
//				if(l.isLogged(userT.getText(),passT.getText())){
//					Window.alert("Acertou o user e a senha");
//				}else{
//					Window.alert("errou o login ou a senha");
//				}

			}

		});
		
		cancelar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Window.alert("Clicou cancelar");
				Main.midPanel.clear();
				LeftMenu.setEnableLeftMenu(true);

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
