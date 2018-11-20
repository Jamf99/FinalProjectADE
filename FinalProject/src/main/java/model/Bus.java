//package model;
//
//import exceptions.IsFullException;
//import structures.PriorityQueue;
//
//public class Bus {
//	
//	private Person person;
//	
//	private PriorityQueue<Boolean, Person> users;
//	private int totalofPasangers;
//	public static int MAX_PASANGERS = 50;
//
//	public Bus() {
//		this.users = null;
//		this.totalofPasangers = 0;
//	}
//
//	public void addUsers(Person p) throws IsFullException{
//		if (users.isEmpty()) {
//			users = new PriorityQueue();
//			users.insert(p.isDiscapacitado(), p);
//		} else if(users.getWeight()<MAX_PASANGERS) {
//			users.insert(p.isDiscapacitado(), p);
//		}else {
//			throw new  IsFullException();
//		}
//	}
//
//	public PriorityQueue getUsers() {
//		return users;
//	}
//
//	public void setUsers(PriorityQueue users) {
//		this.users = users;
//	}
//
//	public int getTotalofPasangers() {
//		return totalofPasangers;
//	}
//
//	public void setTotalofPasangers(int totalofPasangers) {
//		this.totalofPasangers = totalofPasangers;
//	}
//
//}
