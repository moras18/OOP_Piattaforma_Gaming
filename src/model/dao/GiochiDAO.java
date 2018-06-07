package model.dao;

import model.Gioco;
import util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiochiDAO implements GiochiDao_Interface {

	
	public static List<Gioco> returnListaGiochi() throws Exception{
		Database.connect();
		ResultSet g=Database.selectRecord2("gioco");
		List<Gioco> giochi=new ArrayList<Gioco>();
		while(g.next()){
			String nome=g.getString("nome");
			String logo=g.getString("logo");
			int id=g.getInt("id");
			System.out.println(id);
			Gioco gio=new Gioco(id,nome,logo);
			giochi.add(gio);
		}
		Database.close();
		return giochi;
	}
	
	
	public static List<Gioco> dettGioco(int id){
		List<Gioco> giochi=null;
		try {
			Database.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet g=Database.selectRecord("gioco", "gioco.id=" + id);
			giochi=new ArrayList<Gioco>();
			
			while(g.next()){
				String nome=g.getString("nome");
				String descrizione=g.getString("descrizione");
				String logo=g.getString("logo");
				
				
				Gioco gio=new Gioco(id,nome,logo,descrizione);
				giochi.add(gio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			Database.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return giochi;
	}
	
}
