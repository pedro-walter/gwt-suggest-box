package com.gwt.suggest.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class Sugestao extends AbsolutePanel{
	
	Label nome = new Label();
	Label email = new Label();
	Label data = new Label();
	Label assunto = new Label();
	Label setor = new Label();
	Label sugestao = new Label();
	TextBox nomeT = new TextBox();
	TextBox emailT = new TextBox();
	TextBox dataT = new TextBox();
	TextBox assuntoT = new TextBox();
	ListBox setorL = new ListBox();
	TextArea sugestaoT = new TextArea();
	Button limpar = new Button();
	Button cancelar = new Button();
	Button enviar = new Button();
	AbsolutePanel p = new AbsolutePanel();

	
	public Sugestao(){
		
		//sets labels
		nome.setText("Nome: ");
		email.setText("Email: ");
		data.setText("Data: ");
		assunto.setText("Assunto: ");
		setor.setText("Setor: ");
		sugestao.setText("Sugestao: ");
		limpar.setText("Limpar");
		cancelar.setText("Cancelar");
		enviar.setText("Enviar");
		
		//set
		assuntoT.setWidth("530px");
		dataT.setText(getDate());
		dataT.setEnabled(false);
		setorL.addItem("---");
		setorL.addItem("RH");
		setorL.addItem("Infra");
		setorL.addItem("Higiene");
		setorL.addItem("Diversos");
		sugestaoT.setSize("600px", "250px");
		this.setSize("900px", "500px");
		
		//click listener
		limpar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(Window.confirm("Tem certeza que deseja limpar?")){
					limpar();
					nomeT.setFocus(true);
				}else{
					
				}
				
								
			}

		});
		
		cancelar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(Window.confirm("Tem certeza que deseja sair?")){
					Main.midPanel.clear();
					MenuEsquerda.habilitaMenu(true);
				}else{
					sugestaoT.setFocus(true);
				}
				
								
			}

		});
		
		this.add(nome,10,14);
		this.add(nomeT,70,10);
		this.add(email,10,54);
		this.add(emailT,70,50);
		this.add(data,10,94);
		this.add(dataT,70,90);
		this.add(setor,260,94);
		this.add(setorL,310,93);
		this.add(assunto,10,134);
		this.add(assuntoT,70,130);
		this.add(sugestao,10,170);
		this.add(sugestaoT,10,190);
		this.add(limpar,10,460);
		this.add(cancelar,490,460);
		this.add(enviar,570,460);
		
		
		
	}
	
	public static String getDate(){
		String data;
		Date date = new Date();
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy - HH:mm:ss");
		data=(dtf.format(date, TimeZone.createTimeZone(180)));
		return data;
	}
	
	private void limpar(){
		nomeT.setText("");
		emailT.setText("");
		assuntoT.setText("");
		setorL.setSelectedIndex(0);
		sugestaoT.setText("");
	}

}
