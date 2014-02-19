package com.gwt.suggest.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.gwt.suggest.shared.Suggestion;

public class SearchPanel extends AbsolutePanel {

	Suggestion su = new Suggestion();
	Login l = new Login();

	public SearchPanel() {

		su.setId(20);
		su.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su.setDepartment("RH");
		su.setStatus("Fechado");
		su.setDate(SuggestPanel.getDateDate());
		
		if(l.isLogged){
			this.add(tableIsLogged());
		}else{
			this.add(tableNotLogged());
		}
		
		this.add(closeButton());

	}

	private ArrayList<String> getAllStatus() {
		ArrayList<String> status = new ArrayList<>();

		status.add("Novo");
		status.add("Aberto");
		status.add("Fechado");
		status.add("Aceito");
		status.add("Recusado");

		return status;

	}

	private Button closeButton() {
		Button close = new Button();

		close.setText("Sair");
		close.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (Window.confirm("Tem certeza que deseja sair?")) {
					Main.midPanel.clear();
					LeftMenu.setEnableLeftMenu(true);

				}

			}

		});
		return close;
	}

	private CellTable<Suggestion> tableIsLogged() {

		CellTable<Suggestion> table = new CellTable<Suggestion>();
		SelectionCell statusCell = new SelectionCell(getAllStatus());
		ArrayList<Suggestion> arrayData = new ArrayList<Suggestion>();

		arrayData.add(su);

		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// coluna de sugestao
		Column<Suggestion, String> contentColumn = new Column<Suggestion, String>(
				new EditTextCell()) {
			@Override
			public String getValue(Suggestion s) {
				System.out.println(s.getContent());
				return s.getContent();
			}
		};

		contentColumn.setFieldUpdater(new FieldUpdater<Suggestion, String>() {

			@Override
			public void update(int index, Suggestion s, String value) {
				s.setContent(value);

			}
		});

		table.addColumn(contentColumn, "Sugestao");
		// fim da coluna de sugestao

		// inicio coluna status
		Column<Suggestion, String> statusColumn = new Column<Suggestion, String>(
				statusCell) {
			@Override
			public String getValue(Suggestion s) {
				System.out.println(s.getStatus());
				return s.getStatus();
			}
		};

		statusColumn.setFieldUpdater(new FieldUpdater<Suggestion, String>() {
			@Override
			public void update(int index, Suggestion s, String value) {
				s.setStatus(value);

			}

		});

		table.addColumn(statusColumn, "Status");
		// fim coluna status

		// inicio coluna data
		DateCell dateCell = new DateCell();
		Column<Suggestion, Date> dateColumn = new Column<Suggestion, Date>(
				dateCell) {
			@Override
			public Date getValue(Suggestion s) {
				System.out.println(s.getDate());
				return s.getDate();
			}
		};
		table.addColumn(dateColumn, "Data");
		// fim coluna data

		table.setRowData(arrayData);

		return table;
	}

	private CellTable<Suggestion> tableNotLogged() {

		CellTable<Suggestion> table = new CellTable<Suggestion>();
		ArrayList<Suggestion> arrayData = new ArrayList<Suggestion>();

		arrayData.add(su);

		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// coluna de sugestao
		Column<Suggestion, String> contentColumn = new Column<Suggestion, String>(
				new TextCell()) {
			@Override
			public String getValue(Suggestion s) {
				System.out.println(s.getContent());
				return s.getContent();
			}
		};

		table.addColumn(contentColumn, "Sugestao");
		// fim da coluna de sugestao

		// inicio coluna status
		Column<Suggestion, String> statusColumn = new Column<Suggestion, String>(
				new TextCell()) {
			@Override
			public String getValue(Suggestion s) {
				System.out.println(s.getStatus());
				return s.getStatus();
			}
		};

		table.addColumn(statusColumn, "Status");
		// fim coluna status

		// inicio coluna data
		DateCell dateCell = new DateCell();
		Column<Suggestion, Date> dateColumn = new Column<Suggestion, Date>(
				dateCell) {
			@Override
			public Date getValue(Suggestion s) {
				System.out.println(s.getDate());
				return s.getDate();
			}
		};
		table.addColumn(dateColumn, "Data");
		// fim coluna data

		table.setRowData(arrayData);

		return table;
	}

}
