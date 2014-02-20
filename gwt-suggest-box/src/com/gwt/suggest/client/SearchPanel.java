package com.gwt.suggest.client;

import java.util.ArrayList;
import java.util.Comparator;
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
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.gwt.suggest.shared.Suggestion;

public class SearchPanel extends AbsolutePanel {

	HorizontalPanel aux1 = new HorizontalPanel();
	FlowPanel aux2 = new FlowPanel();
	AbsolutePanel aux3 = new AbsolutePanel();
	Label filter = new Label();
	ListBox listFilter = new ListBox();
	TextBox txtFilter = new TextBox();
	Button btnFilter = new Button();

	//SimplePager pager;
	

	Suggestion su1 = new Suggestion();
	Suggestion su2 = new Suggestion();
	Suggestion su3 = new Suggestion();
	Suggestion su4 = new Suggestion();
	Suggestion su5 = new Suggestion();
	Suggestion su6 = new Suggestion();
	Suggestion su7 = new Suggestion();

	Login l = new Login();

	public SearchPanel() {
		
		//SimplePager.Resources pagerResources = GWT
				//.create(SimplePager.Resources.class);
		//pager = new SimplePager();

		fillSuggestions();

		filter.setText("Filter:");
		btnFilter.setText("OK");
		txtFilter.setWidth("150px");
		listFilter.addItem("All");
		listFilter.addItem("Suggestion");
		listFilter.addItem("Status");
		listFilter.addItem("Date");

		aux1.setSize("890px", "40px");
		
		aux1.add(filter);
		aux1.add(listFilter);
		aux1.add(txtFilter);
		aux1.add(btnFilter);
		
		aux3.setSize("890px", "30px");
								
		if (l.isLogged) {
			aux2.add(tableIsLogged());
		} else {
			aux2.add(tableNotLogged());
		}
		
		aux3.add(closeButton(),855,0);
		

		this.add(aux1);
		this.add(aux2);
		this.add(aux3);

	}

	private void fillSuggestions() {
		su1.setId(20);
		su1.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su1.setDepartment("RH");
		su1.setStatus("Fechado");
		su1.setDate(SuggestPanel.getDateDate());

		su2.setId(21);
		su2.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su2.setDepartment("RH");
		su2.setStatus("Fechado");
		su2.setDate(SuggestPanel.getDateDate());

		su3.setId(22);
		su3.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su3.setDepartment("RH");
		su3.setStatus("Fechado");
		su3.setDate(SuggestPanel.getDateDate());

		su4.setId(23);
		su4.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su4.setDepartment("RH");
		su4.setStatus("Fechado");
		su4.setDate(SuggestPanel.getDateDate());

		su5.setId(24);
		su5.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su5.setDepartment("RH");
		su5.setStatus("Fechado");
		su5.setDate(SuggestPanel.getDateDate());

		su6.setId(25);
		su6.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su6.setDepartment("RH");
		su6.setStatus("Fechado");
		su6.setDate(SuggestPanel.getDateDate());

		su7.setId(26);
		su7.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su7.setDepartment("RH");
		su7.setStatus("Fechado");
		su7.setDate(SuggestPanel.getDateDate());

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
		
		System.out.println("close");
		
		close.setStyleName("btnSearchClose");
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

	private ScrollPanel tableIsLogged() {
		
		System.out.println("ScrollPanel");
		
		ScrollPanel aux = new ScrollPanel();
		
		aux.setHeight("495px");
		aux.setStyleName("dockPanel");

		CellTable<Suggestion> table = new CellTable<Suggestion>();
		SelectionCell statusCell = new SelectionCell(getAllStatus());
		ArrayList<Suggestion> arrayData = new ArrayList<Suggestion>();
		ListHandler<Suggestion> sortHandler = new ListHandler<Suggestion>(
				arrayData);


		

		table.addColumnSortHandler(sortHandler);

		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);
		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);
		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);
		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);

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

		dateColumn.setSortable(true);
		sortHandler.setComparator(dateColumn, new Comparator<Suggestion>() {
			@Override
			public int compare(Suggestion s1, Suggestion s2) {
				return s1.getDate().compareTo(s2.getDate());
			}
		});

		table.addColumn(dateColumn, "Data");
		// fim coluna data

		table.setRowData(arrayData);
		
		//pager.setDisplay(table);
		
		aux.add(table);

		return aux;
	}

	private CellTable<Suggestion> tableNotLogged() {

		CellTable<Suggestion> table = new CellTable<Suggestion>();
		ArrayList<Suggestion> arrayData = new ArrayList<Suggestion>();

		
		

		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);
		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);
		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);
		arrayData.add(su1);
		arrayData.add(su2);
		arrayData.add(su3);
		arrayData.add(su4);
		arrayData.add(su5);
		arrayData.add(su6);
		arrayData.add(su7);

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
		
		//pager.setDisplay(table);

		return table;
	}

}
