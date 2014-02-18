package com.gwt.suggest.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.gwt.suggest.shared.Suggestion;

public class SearchPanel extends AbsolutePanel {

	Suggestion su = new Suggestion();

	public SearchPanel() {

		su.setId(20);
		su.setContent("Content de test, nada a declarar hqih uiqwb uiqbwrui bqwiurbqwuib nruiqwbr uibqwuy rbqwuybr ubq r ahwuhidqiwuhdihqwuihduiqhwduihqwiuhd qwudh qiwuh uh wuihdqwuih duiqwh ");
		su.setDepartment("RH");
		su.setStatus("Aberto");
		su.setDate(SuggestPanel.getDateDate());

		ArrayList<Suggestion> arrayData = new ArrayList<Suggestion>();
		arrayData.add(su);

		CellTable<Suggestion> table = new CellTable<Suggestion>();
		SelectionCell statusCell = new SelectionCell(Search.getAllStatus());

		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		
		//coluna de sugestao
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
		//fim da coluna de sugestao
		
		
		
		Column<Suggestion,String> statusColumn = new Column<Suggestion,String>(statusCell) {
			@Override
			public String getValue(Suggestion s) {
				System.out.println(s.getStatus());
				return s.getStatus();
			}
		};
		table.addColumn(statusColumn, "Status");

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

		table.setRowData(arrayData);

		this.add(table);

		// Column<Suggestion, String> firstNameColumn =
		// new Column<Suggestion, String>(new EditTextCell()) {
		// @Override
		// public String getValue(Suggestion object) {
		// return object.getName();
		// }
		// };

	}

}
