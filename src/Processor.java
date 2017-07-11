public class Processor {

	//General Purpose Registers, using [0] as "zero" register (9)
	private Register[] registers = new Register[9];

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

}
