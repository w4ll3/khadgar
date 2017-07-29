public class Registers {

	//General Purpose Registers, using [0] as "zero" register (9)
	Registers[] register = new Registers[9];

	int qi = -1;
	String data;

	public boolean available(int id) {
		return register[id].qi == -1;
	}

	public void setAvailability(int id, int qi) {
		this.register[id].qi = qi;
	}

	public String getData(int id) {
		return register[id].data;
	}

	public void setData(int id, String data) {
		this.register[id].data = data;
	}

	public Registers getRegister(int id) {
		return register[id];
	}

	public int getQi(int id) {
		return register[id].qi;
	}

	public void setQi(int id, int qi) {
		this.register[id].qi = qi;
	}
}
