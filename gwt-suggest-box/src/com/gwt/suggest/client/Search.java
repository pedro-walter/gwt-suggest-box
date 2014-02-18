package com.gwt.suggest.client;
import java.util.ArrayList;



public class Search {
	
	public Search(){
		
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList getAllStatus(){
		ArrayList<String> status = new ArrayList<>();
		
		status.add("Novo");
		status.add("Aberto");
		status.add("Fechado");
		status.add("Aceito");
		status.add("Recusado");
		
		return status;
		
	}
	
//	public static Grid populaGridGeral(){
//		Grid grid = new Grid(0,2);
//		int i=0;
//		int size=0;
//		
//		for(Cliente cli:Cadastro.arrayClientes){
//			size=grid.getRowCount()+1;
//			grid.resizeRows(size);
//    		grid.setText(i, 0, cli.getNome());
//    		grid.setText(i, 1, cli.getRg());
//    		i++;
//    		//size=arrayClientes.size()+1;
//			//grid.resizeRows(size);
//    		//System.out.println(i);
//    	}
//		grid.setCellPadding(2);
//		grid.setCellSpacing(2);
//		grid.setBorderWidth(2);
//		grid.getElement().getStyle().setProperty("border", "3px solid #000000");
//		
//		
//    	return grid;
//	}

}
