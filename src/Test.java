import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.istic.egotcha.dao.Bdd;
import fr.istic.egotcha.dao.DAO;
import fr.istic.egotcha.model.Player;


public class Test {

	public static void main(String[] args) throws Exception {
		 DAO d =new DAO();
		/*Ajouter des joueurs*/
		/*Player p1 = new Player("Alaeddine", "123456", "Alaeddie", "Baghadadi", new Date());
		Player p2 = new Player("Hicham", "123456", "Hicham", "Nounou", new Date());
		d.addPlayer(p1);
	    d.addPlayer(p2);*/
		/*Modifier des joueurs par son ID*/
      //  d.modifyPlayer(2, "Hochhoch", "5678910", "Hicham","Nounou", new Date());       
	//d.deletePlayer(2);
	//	Bdd b = new Bdd();
	//b.sauveIMG("Alaeddine.jpg", "Alaeddine");
		 //Get joueur by ID
	//Player p=d.getPlayerbyID(1);
	//System.out.println(p.toString());
		 //Get player by Pseudo
		Player p= d.getPlayerbyPseudo("Alaeddine");
		System.out.println(p.toString());
	//Get all Player
	/*Set<Player> playerF=new HashSet<Player>();
	Iterator<Player> pleyer=d.getAllPlayer().iterator();
	while(pleyer.hasNext())
	{
		Player p=new Player();
		p=pleyer.next();
		System.out.println(p.toString());
		
	}*/
	
	}

}
