package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Commenti;
import util.Database;

public class CommentiDAO implements CommentiDAO_Interface {

	public static List<Commenti> Comment(int id){
		List<Commenti> comme=new ArrayList<Commenti>();
		try {
			Database.connect();
			ResultSet com=Database.selectRecord("commenti, utente", "commenti.idgioco=" + id + " AND commenti.idutente=utente.id", " commenti.id ASC");
			while(com.next()){
				String nome=com.getString("nome");
				String cognome=com.getString("cognome");
				String titolo=com.getString("titolo");
				String testo=com.getString("testo");
				int valutazione=com.getInt("valutazione");
				int approvato=com.getInt("approvato");
				if (approvato==1){
				Commenti c=new Commenti(nome,cognome,titolo,testo,valutazione,approvato);
				
				comme.add(c);}
				
			}
			Database.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comme;
	}
	
	public static int Media(int id) throws SQLException{
		int avg=0;
		try {
			Database.connect();
			ResultSet media=Database.mediaRecord("commenti", "commenti.idgioco=" + id);
			while(media.next()){
				avg=media.getInt("media");
				
			}
			Database.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return avg;
	}
	
	public static List<Commenti> CApprova(){
		List<Commenti> comment=new ArrayList<Commenti>();
		try {
			Database.connect();
			ResultSet com=Database.selectRecord("commenti,utente,gioco", "commenti.idutente=utente.id AND commenti.idgioco=gioco.id AND commenti.approvato=0");
			while(com.next()){
				int id=com.getInt("commenti.id");
				String nomeu=com.getString("utente.nome");
				String cognomeu=com.getString("utente.cognome");
				String nomeg=com.getString("gioco.nome");
				System.out.println(nomeg + "NOME GIOCOOOOO");
				String titolo=com.getString("titolo");
				String testo=com.getString("testo");
				
				int approvato=com.getInt("approvato");
				if (approvato==0){
				Commenti co=new Commenti(id,nomeu,cognomeu,nomeg,titolo,testo);
				System.out.println(co.getNomeG() + "valore di ritorno");
				comment.add(co);
				}
				
			}
			Database.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}
	
	
	public static void Approva(int id){
	try {
		Database.connect();
		Map<String, Object> agg=new HashMap<String, Object>();
		agg.put("approvato", 1);
		Database.updateRecord("commenti",agg, "commenti.id=" + id);
		System.out.println("aggiornamento andato a buon fine");
		Database.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
