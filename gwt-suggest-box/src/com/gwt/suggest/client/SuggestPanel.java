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
import com.gwt.suggest.shared.Suggestion;

public class SuggestPanel extends AbsolutePanel {

	Label name = new Label();
	Label email = new Label();
	Label date = new Label();
	Label subject = new Label();
	Label sector = new Label();
	Label suggest = new Label();
	TextBox nameT = new TextBox();
	TextBox emailT = new TextBox();
	TextBox dateT = new TextBox();
	TextBox subjectT = new TextBox();
	ListBox sectorL = new ListBox();
	TextArea suggestT = new TextArea();
	Button clean = new Button();
	Button cancel = new Button();
	Button send = new Button();
	AbsolutePanel p = new AbsolutePanel();
	
	Suggestion s = new Suggestion();

	public SuggestPanel() {

		// sets labels
		name.setText("Nome: ");
		email.setText("Email: ");
		date.setText("Data: ");
		subject.setText("Assunto: ");
		sector.setText("Setor: ");
		suggest.setText("Sugestao: ");
		clean.setText("Limpar");
		cancel.setText("Cancelar");
		send.setText("Enviar");

		// set
		subjectT.setWidth("530px");
		dateT.setText(getDate());
		dateT.setEnabled(false);
		sectorL.addItem("---");
		sectorL.addItem("RH");
		sectorL.addItem("Infra");
		sectorL.addItem("Higiene");
		sectorL.addItem("Diversos");
		suggestT.setSize("600px", "250px");
		this.setSize("900px", "500px");

		// click listener
		clean.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (Window.confirm("Tem certeza que deseja limpar?")) {
					limpar();
					nameT.setFocus(true);
				} else {

				}

			}

		});

		cancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (Window.confirm("Tem certeza que deseja sair?")) {
					Main.midPanel.clear();
					LeftMenu.setEnableLeftMenu(true);
				} else {
					suggestT.setFocus(true);
				}

			}

		});
		
		send.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if (sectorL.getSelectedIndex()==0){
					Window.alert("O campo Setor deve ser selecionado corretamente");
					sectorL.setFocus(true);				
					
				} else if (subjectT.getText().equals("")) {
					Window.alert("O campo Assunto deve ser preenchido");
					subjectT.setFocus(true);
					
				}else if (suggestT.getText().equals("")){
					Window.alert("O campo Sugestao deve ser preenchido");
					suggestT.setFocus(true);
					
				}else {
					if(Window.confirm("Tem certeza que deseja enviar?")){
						System.out.println("Enviado");
						limpar();
					}
				}

			}

			

		});

		this.add(name, 10, 14);
		this.add(nameT, 70, 10);
		this.add(email, 10, 54);
		this.add(emailT, 70, 50);
		this.add(date, 10, 94);
		this.add(dateT, 70, 90);
		this.add(sector, 260, 94);
		this.add(sectorL, 310, 93);
		this.add(subject, 10, 134);
		this.add(subjectT, 70, 130);
		this.add(suggest, 10, 170);
		this.add(suggestT, 10, 190);
		this.add(clean, 10, 460);
		this.add(cancel, 490, 460);
		this.add(send, 570, 460);

	}

	public static String getDate() {
		String dateS;
		Date date = new Date();
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy - HH:mm:ss");
		dateS = (dtf.format(date, TimeZone.createTimeZone(180)));
		return dateS;
	}

	private void limpar() {
		nameT.setText("");
		emailT.setText("");
		subjectT.setText("");
		sectorL.setSelectedIndex(0);
		suggestT.setText("");
	}

}
