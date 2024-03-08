import java.awt.*;

public class Giant extends Critter {
    private int step; // Current step of the Giant's movement cycle

    // Giant class's constructor 
    public Giant() {
        this.step = 0;
    }

    // If there's an enemy in front, it infects; if the front is empty, it hops; otherwise, it turns right
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    // Returns the color of the Giant, which is gray
    public Color getColor() {
        return Color.GRAY;
    }

    // Returns the appearance of the Giant based on its movement cycle
    // The appearance changes every 6 steps, cycling through "fee", "fie", "foe", and "fum"
    //   String - "fee" for steps 0-5, "fie" for steps 6-11, "foe" for steps 12-17, "fum" for steps 18-22
    public String toString() {
        if (step < 6) {
            step++;
            return "fee";
        } else if (step < 12) {
            step++;
            return "fie";
        } else if (step < 18) {
            step++;
            return "foe";
        } else if (step < 23) {
            step++;
            return "fum";
        } else {
            step = 0;
            return "fum";
        }
    }
}
