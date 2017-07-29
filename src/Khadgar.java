import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Khadgar {

	// Tomasulo's components
	static Memory memory = new Memory();
	static Processor CPU = new Processor();
	static StationBank stationBank = new StationBank();

	static AtomicInteger lineCounter = new AtomicInteger(0);
	static Queue<String> program = new LinkedList<>();
	static AtomicInteger pc = new AtomicInteger(0);
	private boolean stalled;

	public static void main(String[] args) throws IOException {

		try (Stream<String> inputFile = Files.lines(Paths.get(args[0]))) {

			inputFile.forEachOrdered(
					s -> {
						program.add(s);
						lineCounter.getAndIncrement();
					}
			);

			lineCounter.getAndDecrement();
			lineCounter.getAndDecrement();
			lineCounter.getAndDecrement();

		}
		for (String i : program) {

			if (!i.equals("")) {
				Pattern opPattern = Pattern.compile("\\w+");
				Pattern regPattern = Pattern.compile("\\d+");
				Matcher matcher = opPattern.matcher(i);
				Queue<String> operation = new LinkedList<>();
				if (matcher.find())
					operation.add(matcher.group());
				matcher = regPattern.matcher(i);
				while (matcher.find())
					operation.add(matcher.group());
			}
		}

	}

}
