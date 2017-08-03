import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Processor {

	//Registers
	Registers registers;

	//Reserve Stations
	StationBank stations;

	//Functional Units
	FunctionalUnit functionalUnits;

	public Processor() {
	}

	public void fetch(LinkedList<String> operation, Memory memory, AtomicInteger pc, AtomicInteger ic) {
		if (ic.equals(new AtomicInteger(0))) System.out.println("Reached end of the program");
		else memory.data.add(operation);
		pc.getAndIncrement();
		ic.getAndDecrement();
	}

	public void issue(Memory memory, boolean stalled) throws Exception {
		while (stations.setStation(memory, registers));
	}

	public void execute(ArrayList<String> operation) {

	}

}
