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
                    numbers.removeFirst();
                    frame.used = 2;
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
                        frame.used = 1;
                        Frame tempFrame = frame;
                        frames.remove(frame);
                        frames.add(tempFrame);
                        hasFree = true;
                        break;
                    }
                }
                if (!hasFree) {
                    boolean releaseable = false;
                    LinkedList<Frame> temp = new LinkedList<Frame>();
                    for (Frame frame : frames) {
                        if (frame.used == 2) {
                            frame.used = 1;
                            temp.add(frame);
                        } else if (frame.used == 1) {
                            output += frame.name;
                            numOfErrors++;
                            frame.page = numbers.getFirst();
                            numbers.removeFirst();
                            temp.add(frame);
                            releaseable = true;
                            break;
                        }
                    }
                    for (Frame frame : temp) {
                        frames.remove(frame);
                        frames.add(frame);
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