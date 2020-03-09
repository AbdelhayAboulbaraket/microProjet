package myBusinessLayer;

public class Panier {
	Article article;
	int quantite;
	
	
	public Panier() {
		super();
	}
	
	public Panier(Article article, int quantite) {
		super();
		this.article = article;
		this.quantite = quantite;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
