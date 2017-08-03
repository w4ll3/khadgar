public class StationBank {

	//Reserve Stations (20)
	//Sum + Sub Stations
	private ReserveStation[] sumbStations = new ReserveStation[4];
	//Mul + Div Stations
	private ReserveStation[] mulvStations = new ReserveStation[8];
	//Load + Store Stations
	private ReserveStation[] memStations = new ReserveStation[8];

	public boolean setStation(Memory memory, Registers registers) throws Exception {

		int emptyId = 0;
		ReserveStation emptyStation = new ReserveStation();
		String op = memory.data.peek().poll();

		switch (op) {
			// Div/Sum 3R
			case "add":
			case "ADD":
			case "sub":
			case "SUB":
			case "and":
			case "AND":
			case "or":
			case "OR":
				emptyStation = getEmptySumb();
			case "mul":
			case "MUL":
			case "div":
			case "DIV":
			case "addi":
			case "ADDI":
			case "subi":
			case "SUBI": {
				if (emptyStation == null)
					emptyStation = getEmptyMulv();
				if (emptyStation != null) {
					int reg1 = Integer.valueOf(memory.data.peek().poll());
					int reg2 = Integer.valueOf(memory.data.peek().poll());
					int reg3 = Integer.valueOf(memory.data.poll().poll());

					emptyStation.setAll(
							op,
							"-1",
							"-1",
							"-1",
							"-1",
							"-1",
							true
					);

					if (registers.available(reg2)) {
						emptyStation.setVj(registers.getData(reg2));
					} else {
						emptyStation.setQj(Integer.toString(registers.getQi(reg2)));
					}

					if (registers.available(reg3)) {
						emptyStation.setVk(registers.getData(reg3));
					} else {
						emptyStation.setQk(Integer.toString(registers.getQi(reg3)));
					}

					registers.setQi(reg1, emptyStation.id);
				} else return false;
				break;
			}
			case "blt":
			case "BLT":
			case "bgt":
			case "BGT":
			case "beq":
			case "BEQ": {

			}
			break;
			case "not":
			case "NOT": {
			}
			break;
			// Branches
			case "j":
			case "J": {
			}
			// Memory
			case "lw":
			case "LW":
			case "sw":
			case "SW": {
				if ((emptyStation = getEmptyMem()) != null) {
					int reg1 = Integer.valueOf(memory.data.peek().poll());
					int reg2 = Integer.valueOf(memory.data.poll().poll());

					emptyStation.setAll(
							op,
							"-1",
							"-1",
							"-1",
							"-1",
							"-1",
							true
					);

					if (registers.available(reg2)) {
						emptyStation.setVj(registers.getData(reg2));
					} else {
						emptyStation.setQj(Integer.toString(registers.getQi(reg2)));
					}

					registers.setQi(reg1, emptyStation.id);
				} else return false;
			}
			break;
			default: {
				if (memory.instructions.isEmpty()) return false;
				throw new Exception("Invalid instruction " + op + ".");
			}
		}
		return true;
	}

	public ReserveStation getSumbStations(int id) {
		return sumbStations[id];
	}

	public ReserveStation getEmptySumb() {
		for (int i = 0; i < 4; i++)
			if (!(getSumbStations(i).isBusy())) return getSumbStations(i);
		return null;
	}

	public void setSumbStations(int id, ReserveStation sumbStations) {
		this.sumbStations[id] = sumbStations;
	}

	public ReserveStation getMulvStations(int id) {
		return mulvStations[id];
	}

	public void setMulvStations(int id, ReserveStation mulvStations) {
		this.mulvStations[id] = mulvStations;
	}

	public ReserveStation getMemStations(int id) {
		return memStations[id];
	}

	public void setMemStations(int id, ReserveStation memStations) {
		this.memStations[id] = memStations;
	}

	public ReserveStation getEmptyMulv() {
		for (int i = 0; i < 4; i++)
			if (!(getMulvStations(i).isBusy())) return getMulvStations(i);
		return null;
	}

	public ReserveStation getEmptyMem() {
		for (int i = 0; i < 4; i++)
			if (!(getMemStations(i).isBusy())) return getMemStations(i);
		return null;
	}

	public void executeSumb() {
		ReserveStation busy = new ReserveStation();
		for (int i = 0; i < 4; i++) {
			if ((busy = getSumbStations(i)).isBusy()) {
				if (busy.getQj().equals("-1"))
			} else if ((busy = getSumbStations(i)).isBusy()) {
				if (busy.getQk().equals("-1"))
			}
			if (!busy.getQj().equals("-1") || !busy.getQk().equals("-1")) continue;

		}
	}

	public void executeMulv() {
	}

	public void executeMem() {
	}
}
