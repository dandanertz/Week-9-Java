import javax.swing.JOptionPane;

public class PetArrayProgram {
    public static void main(String[] args) {
        String[] pet = new String[10]; // Array to store pet names
        int petCount = 0; // Counter to keep track of number of pets added

        // Loop to input pet names
        for (int i = 0; i < 10; i++) {
            String input = JOptionPane.showInputDialog("Enter pet name #" + (i + 1) + " (or 'q' to quit):");
            if (input.equalsIgnoreCase("q")) {
                break; // Break the loop if user enters 'q'
            }
            pet[i] = input;
            petCount++;
        }

        String searchPet = JOptionPane.showInputDialog("Enter pet name to search:");
        boolean found = false;
        int petIndex = -1;
        for (int i = 0; i < petCount; i++) {
            if (pet[i].equalsIgnoreCase(searchPet)) {
                found = true;
                petIndex = i;
                break; // Exit loop once pet is found
            }
        }

        if (found) {
            String[] options = {"Modify Pet Name", "Delete Pet", "Exit"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Choose an action:", "Pet Management", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (selectedOption == 0) {
                // Modify pet name
                String newPetName = JOptionPane.showInputDialog("Enter new name for pet:");
                pet[petIndex] = newPetName;
                JOptionPane.showMessageDialog(null, "Pet name updated successfully.");
            } else if (selectedOption == 1) {
                // Delete pet
                pet[petIndex] = null; // Remove pet by setting its value to null
                JOptionPane.showMessageDialog(null, "Pet removed successfully.");
            } else if (selectedOption == 2) {
                // Exit program
                JOptionPane.showMessageDialog(null, "Exiting Pet Management.");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pet not found.");
        }

        // Display all pets
        String allPets = "";
        for (int i = 0; i < petCount; i++) {
            if (pet[i] != null) {
                allPets += pet[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "All Pets:\n" + allPets);
    }
}
//CS A121 - DANIEL JOHN HENRICK D. SANCHEZ
