package energymanagement;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnergyManager energyManager = new EnergyManager();

        while (true) {
            try {
                System.out.println("\n=== Energy Management System Menu ===");
                System.out.println("1). Add Battery");
                System.out.println("2). Add Solar Panel");
                System.out.println("3). Remove Component");
                System.out.println("4). Display Total Capacity");
                System.out.println("0). Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter battery capacity (kWh): ");
                        int batteryCapacity = scanner.nextInt();
                        if (batteryCapacity < 0) {
                            System.out.println("Error: Capacity cannot be negative. Battery not added.");
                        } else {
                            energyManager.addComponent(new Battery(batteryCapacity));
                            System.out.println("Battery added successfully!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter solar panel power (kW): ");
                        int solarPanelPower = scanner.nextInt();
                        if (solarPanelPower < 0) {
                            System.out.println("Error: Power cannot be negative. Solar panel not added.");
                        } else {
                            energyManager.addComponent(new SolarPanel(solarPanelPower));
                            System.out.println("Solar panel added successfully!");
                        }
                        break;

                    case 3:
                        // Get type of the component to remove
                        System.out.print("Enter type of component to remove (1. Battery, 2. Solar Panel): ");
                        int componentType = scanner.nextInt();

                        // Get details of the component to remove
                        System.out.print("Enter details of the component to remove: ");
                        int componentDetails = scanner.nextInt();

                        // Search for the component and remove it
                        boolean componentRemoved = false;
                        List<Component> components = energyManager.getComponents();
                        for (Component component : components) {
                            if (componentType == 1 && component instanceof Battery && ((Battery) component).getCapacity() == componentDetails) {
                                energyManager.removeComponent(component);
                                componentRemoved = true;
                                System.out.println("Battery removed successfully!");
                                break;
                            } else if (componentType == 2 && component instanceof SolarPanel && ((SolarPanel) component).generatePower() == componentDetails) {
                                energyManager.removeComponent(component);
                                componentRemoved = true;
                                System.out.println("Solar panel removed successfully!");
                                break;
                            }
                        }

                        // If the component wasn't found
                        if (!componentRemoved) {
                            System.out.println("Error: Component not found or invalid details. No component removed.");
                        }
                        break;
                    case 4:
                        int totalCapacity = energyManager.calculateTotalCapacity();
                        System.out.println("Total Capacity of Batteries: " + totalCapacity + " kWh");
                        break;

                    case 0:
                        System.out.println("Exiting the Energy Management System. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Error: Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.nextLine();  // Consume the invalid input to avoid an infinite loop
            }
        }
    }
}


