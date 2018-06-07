package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Utente;
import util.DataUtil;
import util.Database;
import util.SecurityLayer;

public class UtenteDAO {

	public static List<Utente> returnProfilo(int id){
		String nome=null;
		String cognome=null;
		String immini=null;
		String immfin=null;
		int esperienza=0;
		int progresso=0;
		int cont=1;
		int gruppo=0;
		List<Utente> dettProfilo=new ArrayList<Utente>();
		try {
			Database.connect();
			ResultSet profilo=Database.selectRecord("utente", "utente.id=" + id);
			while(profilo.next()){
				nome=profilo.getString("nome");
				cognome=profilo.getString("cognome");
				esperienza=profilo.getInt("esperienza");
				gruppo=profilo.getInt("idgruppo");
				System.out.println(gruppo);
			}
			
			if(esperienza>=0 && esperienza<100){
				progresso=esperienza;
			} else if(esperienza>=100 && esperienza<200){
				progresso=esperienza-100;
			} else if(esperienza>=200 && esperienza<300){
				progresso=esperienza-200;
			} else if(esperienza>=300 && esperienza<400){
				progresso=esperienza-300;
			} else if(esperienza>=400 && esperienza<500){
				progresso=esperienza-400;
			}
			
			ResultSet livello=Database.selectRecord2("trofei");
			while(livello.next()){
				if(esperienza>=livello.getInt("espmax")){
					cont++;
				}
			}
			
			if(cont==1){
				immini="Template/image/liv1.jpg";
						immfin="Template/image/liv2.jpg";
			}
			
			if(cont==2){
				immini="Template/image/liv2.jpg";
						immfin="Template/image/liv3.jpg";
			}
			
			if(cont==3){
				immini="Template/image/liv3.jpg";
						immfin="Template/image/liv4.jpg";
			}
			
			if(cont==4){
				immini="Template/image/liv4.jpg";
						immfin="Template/image/liv5.jpg";
			}
			
			if(cont==5){
				immini="Template/image/liv2.jpg";
						immfin="Template/image/livfin.jpg";
			}
			
			Utente prof=new Utente(nome, cognome, esperienza, cont, progresso, gruppo);
			
			dettProfilo.add(prof);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dettProfilo;
	}
	
	
	public static void Registrazione(String email, String password, String nome, String cognome, int esperienza, int gruppo){
		try {
			Map data= new HashMap<String, Object>();
			Database.connect();
			data.put("email", email);
			data.put("password", DataUtil.crypt(password));
			data.put("nome", nome);
			data.put("cognome", cognome);
			data.put("esperienza", esperienza);
			data.put("idgruppo", gruppo);
			
			Database.insertRecord("utente", data);
			System.out.println("INSERIMENTO RIUSCITO, GRANDEEEEEEE");
			Database.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int checkGroup(int id){
		int group=0;
		try {
			Database.connect();
			ResultSet ut=Database.selectRecord("utente","id=" + id);
			while(ut.next()){
				group=ut.getInt("idgruppo");
				System.out.println(group +" non c'hai mai fatto");
			}
			Database.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return group;
	}
	
	public static List<Utente> Promo(int gruppo){
		List<Utente> ute=new ArrayList<Utente>();
		if (gruppo==2){
			try {
				Database.connect();
				ResultSet utenti=Database.selectRecord("utente","idgruppo=1");
				while(utenti.next()){
					int id=utenti.getInt("id");
					String nome=utenti.getString("nome");
					String cognome=utenti.getString("cognome");
					int gruppou=utenti.getInt("idgruppo");
					Utente lista=new Utente (id, nome, cognome, gruppou);
					ute.add(lista);
				}
				Database.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} else {
		try {
			System.out.println("vuoi entrare qui o no?");
			Database.connect();
			ResultSet utenti=Database.selectRecord("utente","idgruppo=1 OR idgruppo=2");
			while(utenti.next()){
				int id=utenti.getInt("id");
				String nome=utenti.getString("nome");
				String cognome=utenti.getString("cognome");
				int gruppou=utenti.getInt("idgruppo");
				Utente lista=new Utente (id, nome, cognome, gruppou);
				ute.add(lista);
			}
			Database.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		return ute;
	}
	
	
	public static void Promozione(int id, String decisione) throws Exception{
		Map pro=new HashMap<String,Object>();
		
		
		System.out.println(decisione + " cosa hai scelto?");
		if(decisione.equals("promuovi")){
			try {
				Database.connect();
				pro.put("idgruppo", 2);
				Database.updateRecord("utente", pro, "utente.id=" + id);
				Database.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			try{
			Database.connect();
			pro.put("idgruppo", 1);
			Database.updateRecord("utente", pro, "utente.id=" + id);
			Database.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void aggExp(int id) throws Exception{
		Map data=new HashMap<String, Object>();
		int exp=0;
			Database.connect();
			ResultSet ute=Database.selectRecord("utente", "utente.id=" + id);
			while(ute.next()){
				exp=ute.getInt("esperienza");
			}
			exp=exp+20;
			data.put("esperienza", exp);
			Database.updateRecord("Utente", data, "utente.id=" + id);
			Database.close();
			
		}
}

