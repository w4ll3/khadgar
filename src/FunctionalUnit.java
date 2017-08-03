import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FunctionalUnit {
	int cicles, id, reserveStation, result;
	private int total = 5;

	ArrayList<FunctionalUnit> functionalUnits = new ArrayList<>(total);

	public void init() {
		AtomicInteger i = new AtomicInteger(0);
		this.functionalUnits.forEach(functionalUnit -> {
			id = i.getAndAdd(1);
		});
	}
}
