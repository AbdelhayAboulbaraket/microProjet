package myDb;

import java.sql.*;

public class DBConnect {
	private static DBConnect instance=null;
	Connection conn=null;
	
	public Connection getConn() 
	{
		return conn;
	}

	public void setConn(Connection conn) 
	{
		this.conn = conn;
	}

	 public DBConnect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception ex)
		//catch (ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
		
		try 
		{
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306?allowMultiQueries=true","root","samirlayl123");
			Statement req = conn.createStatement();
			String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='micro_projet'";
			ResultSet rs = req.executeQuery(query);                  
			rs.next();
			boolean exists = rs.getInt("COUNT(*)") > 0;
			if(!exists) 
			{	
				String sql="create database micro_projet;" + 
						"use micro_projet;" + 
						"create table client( id int(10) AUTO_INCREMENT, email  varchar(50), nom varchar(30), prenom varchar(30), adresse varchar(30),code_postal varchar(30),ville varchar(30),tel varchar(30),mot_de_passe varchar(100), primary key(id));" + 
						"create table commande( num_commande int(10), id_client int(10),date_commande date, primary key(num_commande), foreign key(id_client) references client(id) );" +
						"create table categorie(ref_cat int(10),cat varchar(30),primary key(ref_cat));" + 
						"create table article(code_article int(10),designation varchar(100),prix float,stock int(10),categorie int(10),image BLOB,primary key(code_article),foreign key(categorie) references categorie(ref_cat));" +
						"create table lignes_commande(num_commande int(10),code_article int(10),qte_cde int(10),foreign key(num_commande) references commande(num_commande),foreign key(code_article) references article(code_article),primary key(num_commande,code_article));";
				req.executeUpdate(sql);
				System.out.println("DB crée");
				
				//conn.close();
				
				
			}
			else
			{
				String sql="use micro_projet;";
				req.executeUpdate(sql);
			}
			
				
			
			
		}
		
		catch(SQLException ex)
		{
			System.out.println("SQLException : "+ ex.getMessage());
			System.out.println("SQLState : "+ ex.getSQLState());
			System.out.println("VendorError : "+ ex.getErrorCode());
			
		}
	}
	
	public static DBConnect getInstance()
	{
		if(instance == null)
		{
			instance= new DBConnect();
		}
		
		return instance;
	}

}
