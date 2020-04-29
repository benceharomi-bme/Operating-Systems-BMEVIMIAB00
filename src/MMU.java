import java.util.LinkedList;

public class MMU {
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    LinkedList<Frame> frames = new LinkedList<Frame>();
    String output = "";
    public int numOfErrors = 0;

    public MMU(LinkedList<Integer> numbers) {
        this.numbers = numbers;
        for (char i = 'A'; i <= 'D'; i++) {
            frames.add(new Frame(String.valueOf(i)));
        }
    }

    public String start() {
        boolean end = false;
        while (!end) {
            boolean contains = false;
            for (Frame frame : frames) {
                if (frame.page == numbers.getFirst()) {
                    output += "-";
                    Frame tempFrame = frame;
                    frames.remove(frame);
                    frames.add(tempFrame);
                    numbers.removeFirst();
                    frame.used++;
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                boolean hasFree = false;
                for (Frame frame : frames) {
                    if (frame.used == 0) {
                        output += frame.name;
                        numOfErrors++;
                        frame.page = numbers.getFirst();
                        numbers.removeFirst();
                        frame.used++;
                        hasFree = true;
                        break;
                    }
                }
                if (!hasFree) {
                    boolean releaseable = false;
                    for (Frame frame : frames) {
                        if (frame.used == 1) {
                            output += frame.name;
                            numOfErrors++;
                            frame.page = numbers.getFirst();
                            numbers.removeFirst();
                            releaseable = true;
                            break;
                        }
                    }
                    if (!releaseable) {
                        output += "*";
                    }
                }
            }
            if (numbers.size() == 0)
                end = true;
        }
        return output;
    }
}