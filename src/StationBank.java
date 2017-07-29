public class StationBank {

	//Reserve Stations (20)
	//Sum + Sub Stations
	private ReserveStation[] sumbStations = new ReserveStation[4];
	//Mul + Div Stations
	private ReserveStation[] mulvStations = new ReserveStation[8];
	//Load + Store Stations
	private ReserveStation[] memStations = new ReserveStation[8];

	public void setStation(Memory memory, Registers registers) {

		int emptyId = 0;

		switch (memory.data.poll().poll()) {
			// Div/Sum 3R
			case "add":
			case "ADD":
			case "sub":
			case "SUB":
			case "and":
			case "AND":
			case "or":
			case "OR": {
				boolean emptyStation = true;
				for (int i = 0; i < 4; i++) {
					if (!(emptyStation = getSumbStations(i).isBusy())) break;
					emptyId++;
				}
				if (!emptyStation) {
					String op = memory.data.poll().poll();
					int reg1 = Integer.valueOf(memory.data.poll().poll());
					int reg2 = Integer.valueOf(memory.data.poll().poll());
					int reg3 = Integer.valueOf(memory.data.poll().poll());

					getSumbStations(emptyId).setAll(
							op,
							"-1",
							"-1",
							"-1",
							"-1",
							"-1",
							true
					);

					if (registers.available(reg2)) {
						getSumbStations(emptyId).setVj(registers.getData(reg2));
					} else {
						getSumbStations(emptyId).setQj(Integer.toString(registers.getQi(reg2)));
					}

					if (registers.available(reg3)) {
						getSumbStations(emptyId).setVk(registers.getData(reg3));
					} else {
						getSumbStations(emptyId).setQk(Integer.toString(registers.getQi(reg3)));
					}

					registers.setQi(reg1, emptyId);

				}
			}
			break;
			case "mul":
			case "MUL":
			case "div":
			case "DIV":
			case "addi":
			case "ADDI":
			case "subi":
			case "SUBI": {
				boolean emptyStation = true;
				for (int i = 0; i < 4; i++) {
					if (!(emptyStation = getMulvStations(i).isBusy())) break;
					emptyId++;
				}
				if (!emptyStation) {
					String op = memory.data.poll().poll();
					int reg1 = Integer.valueOf(memory.data.poll().poll());
					int reg2 = Integer.valueOf(memory.data.poll().poll());
					int reg3 = Integer.valueOf(memory.data.poll().poll());

					getMulvStations(emptyId).setAll(
							op,
							"-1",
							"-1",
							"-1",
							"-1",
							"-1",
							true
					);

					if (registers.available(reg2)) {
						getMulvStations(emptyId).setVj(registers.getData(reg2));
					} else {
						getMulvStations(emptyId).setQj(Integer.toString(registers.getQi(reg2)));
					}

					if (registers.available(reg3)) {
						getMulvStations(emptyId).setVk(registers.getData(reg3));
					} else {
						getMulvStations(emptyId).setQk(Integer.toString(registers.getQi(reg3)));
					}

					registers.setQi(reg1, emptyId);
				}
			}
			break;
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
			}
			break;
			default: {
				System.exit(-1);
			}
		}
	}

	public ReserveStation getSumbStations(int id) {
		return sumbStations[id];
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
}
