package ca.uwo.csd.cs2212.team10;

public class Accolade_Node {
	private String description; 
	private String title;
	private boolean check;
	
	public Accolade_Node(){
		this.title=" "
		this.description=" ";
		this.check=false;
	}
	public Accolade_Node(String title,String description, boolean check){
		this.title=title;
		this.description=description; 
		this.check=false;
	}
	public String getTitle(){
		return this.title; 
	}
	public boolean getCheck(){
		return this.check;
	}
	public boolean getDescription(){
		return this.description;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public void setCheck(boolean check){
		this.check=check;
	}
	public void setDescription(String description){
		this.description=description;
	}
}
