package Estructuras;

public class Domain implements Comparable<Domain>{

	private String URL;
	private String description;
	private String name;

	public Domain(String u, String n) {
		URL=u;
		name=n;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Domain d=(Domain)obj;
		return name.equals(d.getName());
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Domain o) {
		return name.compareTo(o.getName());
	}
}