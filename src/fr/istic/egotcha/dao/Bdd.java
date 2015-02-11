package fr.istic.egotcha.dao;
import java.sql.*;
import java.util.*;
import java.io.*;

public class Bdd 
{

  private Connection conn;

  public Bdd()
  {
  }
  
  public void initialiserConnexion(String fichierConfig) throws Exception
  {
    Properties propBD = new Properties();
    FileInputStream entree = new FileInputStream(fichierConfig);
    try
    {
      //FileInputStream entree = new FileInputStream(fichierConfig);
      propBD.load(entree);
    }
    finally
    {

    
	entree.close();
    }

    Class.forName(propBD.getProperty("com.mysql.jdbc.Driver"));
    conn = DriverManager.getConnection(propBD.getProperty("jdbc:mysql://localhost:3306/egotcha"),
    propBD.getProperty("root"),propBD.getProperty(""));
  }
  
  public void deconnexion() throws Exception
  {
    if(conn != null)
    {
      conn.close();
    }
  }
  public void sauveIMG(String location, String name) throws Exception 
	{
	  File monImage = new File(location);
	  FileInputStream istreamImage = new FileInputStream(monImage);
	  try 
	  {
	    java.sql.PreparedStatement ps =  conn.prepareStatement("insert into image (name, img) values (?,?)");
	    try 
	    {
	        ps.setString(1, name);
	        ps.setBinaryStream(2, istreamImage, (int) monImage.length());
	        ps.executeUpdate();
	    }
	    finally 
	    {
	      ps.close();
	    }
	  } 
	  finally 
	  {
	    istreamImage.close();
	  }
	}
}