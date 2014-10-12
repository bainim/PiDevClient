package com.picturenetwork.test.OnetoMany;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.SubjectServicesRemote;

public class CascadePersiste {
	
	public static void main(String[] args) {
		
		CommentServicesRemote proxy = null;

		SubjectServicesRemote proxy1 = null;
		
		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (CommentServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote");

			ctx = new InitialContext();
			proxy1 = (SubjectServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/SubjectServices!com.PictureNetwork.services.SubjectServicesRemote");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		/* Player p5 = new Player(5,"pirlo","midfield",21);
	       Player p6 = new Player(6,"teves","Carlos",10);
	     		       
	       
	       Team t3=new Team(1,"juventus");
	      
	       List<Player> t3Players= new ArrayList<>();
	       t3Players.add(p5);
	       t3Players.add(p6);
	       
	       t3.setPlayers(t3Players);
	       
	      p5.setTeam(t3);
	      p6.setTeam(t3);
	      
	      
	       proxy.createTeam(t3);*/
		}

}
