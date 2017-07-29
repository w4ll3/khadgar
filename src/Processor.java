import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Processor {

	//Registers
	Registers registers;

	//Reserve Stations
	private StationBank stations;


	//Functional Units (5)
	//Memory Unit
	private FunctionalUnit memUnit = new FunctionalUnit();
	//Sum + Sub Unit
	private FunctionalUnit[] sumbUnit = new FunctionalUnit[2];
	//Mul + Div Unit
	private FunctionalUnit[] mulvUnit = new FunctionalUnit[2];

	public Processor() {
	}

	public void fetch(LinkedList<String> program, Memory memory, AtomicInteger pc) {
		if (program == null) System.out.println("Reached end of the program");
		else memory.data.add(program);
		pc.getAndIncrement();
	}

	public void issue(LinkedList<String> program, boolean stalled, Memory memory) {
		if (!stalled && program.poll() != null) System.out.println("Ended decoding");
		else {
		}
	}

	public void execute(ArrayList<String> operation) {
		switch (operation.get(0)) {
			// Arithmetic
			case "add":
			case "ADD": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "addi":
			case "ADDI": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "sub":
			case "SUB": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			case "subi":
			case "SUBI": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "mul":
			case "MUL": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "div":
			case "DIV": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			// Logic
			break;
			case "and":
			case "AND": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "or":
			case "OR": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "not":
			case "NOT": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			// Branches
			case "blt":
			case "BLT": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "bgt":
			case "BGT": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "beq":
			case "BEQ": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "j":
			case "J": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			// Memory
			case "lw":
			case "LW": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			case "sw":
			case "SW": {
				System.out.println(operation.get(0) + " " + operation.get(1) + " " + operation.get(2) + " " + operation.get(3));
			}
			break;
			default: {
//				System.out.println(operation.get(0) + " in line " + lineCounter + " is not a valid instruction.");
				System.exit(-1);
			}
		}
	}

}
