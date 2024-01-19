package energymanagement;

public class Battery extends Component {
   
	    private int capacity;

	    // Constructor
    public Battery(int capacity) {
     this.capacity = capacity;
   }

   // Override getDetails method
   public String getDetails() {
       return "the capacity of the battery is : " + capacity + " kWh";
   }

   // Getter for capacity
   public int getCapacity() {
       return capacity;
   }

}
