import java.util.LinkedList;

public class SC {
    // Linked list for the storing of the input
    LinkedList<Integer> input;
    // Linked list for the fifo of the frames
    LinkedList<Frame> frames;
    // Counting the num of the page errors
    private int numOfPageFaults;
    // Output string
    String output;

    // Initializing the arguments
    public SC(LinkedList<Integer> input) {
        this.input = input;
        this.frames = new LinkedList<Frame>();
        // Setting up 4 frames
        for (char i = 'A'; i <= 'D'; i++) {
            frames.add(new Frame(String.valueOf(i)));
        }
        this.numOfPageFaults = 0;
        this.output = "";
    }

    public String start() {
        // Flag for the sequence to know when to quit
        boolean end = false;
        while (!end) {
            boolean contains = false;
            for (Frame frame : frames) {
                // If the page is found in any of the frames setting the second chance flag
                if (frame.page == input.getFirst()) {
                    // Indicating on the output that there were no page errors
                    output += "-";
                    // Removing the input page number from the input which was processed
                    input.removeFirst();
                    // Setting the sc flag which indicates that the page has a second chance
                    frame.sc = true;
                    // Setting the contains flag which indicates that the input has been processed
                    // and the following chesks are unnecessary
                    contains = true;
                    break;
                }
            }
            // If the page was not found in any of the frames we continue the processing
            if (!contains) {
                boolean hasFree = false;
                for (Frame frame : frames) {
                    // If an empty frame is found putting the page into it
                    if (!frame.used) {
                        // Adding the frame name to the output string
                        output += frame.name;
                        // Incrementing the page faults counter
                        numOfPageFaults++;
                        // Setting the page number to the frame
                        frame.page = input.getFirst();
                        // Removing the input page number from the input which was processed
                        input.removeFirst();
                        // Indicating that the frame is used by setting the used frame
                        frame.used = true;
                        // Sending the frame to the end
                        Frame tempFrame = frame;
                        frames.remove(frame);
                        frames.add(tempFrame);
                        // Setting the hasFree flag which indicates that the input has been processed
                        // and the following chesks unnecessary
                        hasFree = true;
                        break;
                    }
                }
                // If there were no empty frames we continue the processing
                if (!hasFree) {
                    boolean releaseable = false;
                    // Creating a temporary linked list which stores the changes of the frames order
                    LinkedList<Frame> temp = new LinkedList<Frame>();
                    for (Frame frame : frames) {
                        // If the page has a second chance
                        if (frame.sc) {
                            // Resetting the second chance flag
                            frame.sc = false;
                            // Sending it to the end by adding it to the temporary list
                            temp.add(frame);
                        }
                        // If a releaseable page is found
                        else if (frame.used) {
                            // Adding the frame name to the output string
                            output += frame.name;
                            // Incrementing the page errors counter
                            numOfPageFaults++;
                            // Setting the page number to the frame
                            frame.page = input.getFirst();
                            // Removing the input page number from the input which was processed
                            input.removeFirst();
                            // Sending it to the end by adding it to the temporary list
                            temp.add(frame);
                            // Setting the releasable flag which indicates that the input has been processed
                            // and the following chesks unnecessary
                            releaseable = true;
                            break;
                        }
                    }
                    // Sending the frame to the end
                    for (Frame frame : temp) {
                        frames.remove(frame);
                        frames.add(frame);
                    }
                    // If there were no pages releaseable indicating it in the output
                    if (!releaseable) {
                        output += "*";
                    }
                }
            }
            // If the input is empty quit the sequence
            if (input.size() == 0)
                end = true;
        }
        return output;
    }

    public String toString() {
        return output + "\n" + numOfPageFaults;
    }
}
