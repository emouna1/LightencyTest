package energymanagement;

public class SolarPanel extends Component {
	  private int power;

	    // Constructor
	    public SolarPanel(int power) {
	        this.power = power;
	    }

	    // Override getDetails method
	    public String getDetails() {
	        return " Solar Panel - power is  : " + power + " kW";
	    }

	    //get power
	    public int generatePower() {
	        return power;
	    }
	}
