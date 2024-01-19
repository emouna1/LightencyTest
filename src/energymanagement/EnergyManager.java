package energymanagement;

import java.util.ArrayList;
import java.util.List;

public class EnergyManager {
	private List<Component> components;

    // Constructor
    public EnergyManager() {
        components = new ArrayList<>();
    }

    // Add a component to the manager
    public void addComponent(Component component) {
        components.add(component);
    }
 // Remove a component from the manager by index
    public void removeComponentAtIndex(int index) {
        if (index >= 0 && index < components.size()) {
            components.remove(index);
        } else {
            System.out.println("Invalid index. No component removed.");
        }
    }
    // Remove a component from the manager
    public void removeComponent(Component component) {
        components.remove(component);
    }

    // Calculate the total capacity of all batteries managed
    public int calculateTotalCapacity() {
        int totalCapacity = 0;

        for (Component component : components) {
            if (component instanceof Battery) {
                totalCapacity += ((Battery) component).getCapacity();
            }
        }

        return totalCapacity;
    }

		public int getComponentsSize() {
	        return components.size();
	    
	}

		public List<Component> getComponents() {
			// TODO Auto-generated method stub
			return components;
		}

}
