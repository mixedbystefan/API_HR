package filmservice;

public class Apartment
{
	
	int id;
	

	int house_number;
	double size;
	int rooms;
	boolean balcony;
	int floor;
	double bofond;
	double rent;
	String fridge;
	String freezer;
	String stove;
	String a_notes;
	
	public Apartment() {}

	public Apartment(int id, int house_number, double size, int rooms, boolean balcony, int floor, double bofond,
			double rent, String fridge, String freezer, String stove, String a_notes) {
		super();
		this.id = id;
		this.house_number = house_number;
		this.size = size;
		this.rooms = rooms;
		this.balcony = balcony;
		this.floor = floor;
		this.bofond = bofond;
		this.rent = rent;
		this.fridge = fridge;
		this.freezer = freezer;
		this.stove = stove;
		this.a_notes = a_notes;
	}
	
	
	
	public Apartment(int id, String a_notes) {
		
		this.id = id;
		this.a_notes = a_notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouse_number() {
		return house_number;
	}

	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public double getBofond() {
		return bofond;
	}

	public void setBofond(double bofond) {
		this.bofond = bofond;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getFridge() {
		return fridge;
	}

	public void setFridge(String fridge) {
		this.fridge = fridge;
	}

	public String getFreezer() {
		return freezer;
	}

	public void setFreezer(String freezer) {
		this.freezer = freezer;
	}

	public String getStove() {
		return stove;
	}

	public void setStove(String stove) {
		this.stove = stove;
	}

	public String getA_notes() {
		return a_notes;
	}

	public void setA_notes(String a_notes) {
		this.a_notes = a_notes;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", house_number=" + house_number + ", size=" + size + ", rooms=" + rooms
				+ ", balcony=" + balcony + ", floor=" + floor + ", bofond=" + bofond + ", rent=" + rent + ", fridge="
				+ fridge + ", freezer=" + freezer + ", stove=" + stove + ", a_notes=" + a_notes + "]";
	}



	




	
	
	
	

}
