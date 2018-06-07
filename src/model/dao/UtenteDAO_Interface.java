package model.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Utente;
import util.Database;

public interface UtenteDAO_Interface {

	public static List<Utente> returnProfilo(){
		return null;
	}
	
	public static void Registrazione(String email, String password, String nome, String cognome, int esperienza, int gruppo){
		
	}
	
public static void aggExp(int id) throws Exception{
	
	}
	
	public static int checkGroup(int id){
		return 0;
	}

}
