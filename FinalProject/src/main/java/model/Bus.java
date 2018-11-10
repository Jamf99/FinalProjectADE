package model;

import structures.PriorityQueue;

public class Bus {
	private PriorityQueue<Boolean, Person> users;
	private int totalofPasangers;
	public static int MAX_PASANGERS = 50;

	public Bus() {
		super();
		this.users = null;
		this.totalofPasangers = 0;
	}

	public void addUsers(Person p) {
		if (users.isEmpty()) {
			users = new PriorityQueue();
			users.insert(p.isDiscapacitado(), p);
		} else if(users.getWeight()<MAX_PASANGERS) {
			users.insert(p.isDiscapacitado(), p);
		}else {
			
		}
	}

	public PriorityQueue getUsers() {
		return users;
	}

	public void setUsers(PriorityQueue users) {
		this.users = users;
	}

	public int getTotalofPasangers() {
		return totalofPasangers;
	}

	public void setTotalofPasangers(int totalofPasangers) {
		this.totalofPasangers = totalofPasangers;
	}

}
