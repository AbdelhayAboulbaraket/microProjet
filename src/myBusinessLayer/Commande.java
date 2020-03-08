package myBusinessLayer;

import java.util.Date;

public class Commande {
	private int numCommande;
	private Client client;
	private Date dateCommande;
	
	
	
	public Commande() {
		super();
	}
	public Commande(Client client, Date dateCommande) {
		super();
		this.client = client;
		this.dateCommande = dateCommande;
	}
	public Commande(int numCommande, Client client, Date dateCommande) {
		super();
		this.numCommande = numCommande;
		this.client = client;
		this.dateCommande = dateCommande;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	

}
