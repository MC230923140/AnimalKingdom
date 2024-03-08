import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean infected; // Flag to track if the WhiteTiger is infected

    // Constructor for WhiteTiger class
    public WhiteTiger() {
        this.infected = false;
    }

    // If there's an enemy in front, it infects and sets the infected flag to true;
    // if there's a wall in front or to the right, it turns left;
    // if there's another WhiteTiger in front, it turns right;
    // otherwise, it hops forward
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            infected = true; // Mark the WhiteTiger as infected
            return Action.INFECT; // Infect if there's an enemy in front
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT; // Turn left if there's a wall in front or to the right
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT; // Turn right if there's another WhiteTiger in front
        } else {
            return Action.HOP; // Hop forward if none of the above conditions are met
        }
    }

    // Returns the color of the WhiteTiger, which is white
    public Color getColor() {
        return Color.WHITE;
    }

    // Returns a string representation of the WhiteTiger
    // The string is "tgr" if the WhiteTiger is not infected, and "TGR" if it is infected
    public String toString() {
        if (infected) {
            return "TGR"; // Return "TGR" if the WhiteTiger is infected
        } else {
            return "tgr"; // Return "tgr" if the WhiteTiger is not infected
        }
    }
}
