package fr.istic.egotcha.model;

import java.util.Date;

public class PlayerLocation {
	int id;
	double x;
	double y;
	Date date;
	
	
	public PlayerLocation() {
		this.x = 0.0;
		this.y = 0.0;
		this.date = new Date();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "PlayerLocation [id=" + id + ", x=" + x + ", y=" + y + ", date="
				+ date + "]";
	}

	
	


	
}
