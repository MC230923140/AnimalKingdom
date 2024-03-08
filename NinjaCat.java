import java.awt.*;

public class NinjaCat extends Critter {
    private int step; // Current step count

    // Constructor for NinjaCat class
    public NinjaCat() {
        this.step = 0;
    }

    // If there's an enemy in front, it infects; if there's a wall in front, it turns right;
    // if there's another NinjaCat in front, it performs a U-turn by turning left twice;
    // otherwise, it hops forward
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;  // Infect if there's an enemy in front
        } else if (info.getFront() == Neighbor.WALL) {
            return Action.RIGHT;   // Turn right if there's a wall in front
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.LEFT;    // Perform a U-turn by turning left twice if there's another NinjaCat
        } else {
            return Action.HOP;     // Hop forward if none of the above conditions are met
        }
    }

    // Returns the color of the NinjaCat, which is orange
    public Color getColor() {
        return new Color(0xFFA500); // Orange color
    }

    // Returns a string representation of the NinjaCat
    // The string changes every 3 steps between "NinjaCat" and "Meow~≽^•⩊•^≼"
    public String toString() {
        if (step < 3) {
            step++;
            return "NinjaCat";
        } else if (step < 6) {
            step++;
            return "Meow~≽^•⩊•^≼";
        } else {
            step = 0; // Reset step count after cycling through both strings
            return "Meow~≽^•⩊•^≼";
        }  
    }
}