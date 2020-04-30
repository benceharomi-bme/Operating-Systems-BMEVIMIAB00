
public class Frame {
    // Name of the frame
    public String name;
    // Used flag indicating if the frame is in use
    public boolean used;
    // Second chance flag indicating that the page has a second chance
    public boolean sc;
    // The number of the page which is in the frame
    public int page;

    // Initializing the arguments
    public Frame(String name) {
        this.name = name;
        this.used = false;
        this.sc = false;
        this.page = 0;
    }
}