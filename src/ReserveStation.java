public class ReserveStation {

	String op, qj, qk, vj, vk, a, id;
	boolean busy = false;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getQj() {
		return qj;
	}

	public void setQj(String qj) {
		this.qj = qj;
	}

	public String getQk() {
		return qk;
	}

	public void setQk(String qk) {
		this.qk = qk;
	}

	public String getVj() {
		return vj;
	}

	public void setVj(String vj) {
		this.vj = vj;
	}

	public String getVk() {
		return vk;
	}

	public void setVk(String vk) {
		this.vk = vk;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public void setAll(String op, String qj, String qk, String vj, String vk, String a, boolean busy) {
		this.op = op;
		this.qj = qj;
		this.qk = qk;
		this.vj = vj;
		this.vk = vk;
		this.a = a;
		this.busy = busy;
	}
}
