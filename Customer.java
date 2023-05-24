import javax.swing.JOptionPane;

public class Customer {
    private static final int MAX = 10;
    private int[] customer_ID = new int[MAX];
    private String[] customer_name = new String[MAX];
    private String[] customer_gender = new String[MAX];
    private int[] customer_age = new int[MAX];
    private int count = 0;

    public static void main(String[] args) {
        CustomerManager cm = new CustomerManager();
        cm.run();
    }

    private void run() {
        String[] menu = {"Add New Customer", "View Customer List", "Search Customer", "Edit Customer", "Delete Customer", "End"};
        while (true) {
            String option = (String) JOptionPane.showInputDialog(
                null,
                "Select an option:",
                "Customer Manager",
                JOptionPane.PLAIN_MESSAGE,
                null,
                menu,
                menu[0]
            );
            if (option == null || option.equals(menu[menu.length - 1])) {
                break;
            }
            switch (option) {
                case "Add New Customer":
                    addCustomer();
                    break;
                case "View Customer List":
                    viewCustomerList();
                    break;
                case "Search Customer":
                    searchCustomer();
                    break;
                case "Edit Customer":
                    editCustomer();
                    break;
                case "Delete Customer":
                    deleteCustomer();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    break;
            }
        }
    }

    private void addCustomer() {
        if (count == MAX) {
            JOptionPane.showMessageDialog(null, "Maximum number of customers reached");
            return;
        }
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID"));
        String name = JOptionPane.showInputDialog("Enter customer name");
        String gender = JOptionPane.showInputDialog("Enter customer gender");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter customer age"));
        customer_ID[count] = id;
        customer_name[count] = name;
        customer_gender[count] = gender;
        customer_age[count] = age;
        count++;
        JOptionPane.showMessageDialog(null, "Customer added");
    }

    private void viewCustomerList() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No customers found");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(String.format(" ID: %d \n Name: %s\n Gender: %s\n Age: %s\n", customer_ID[i], customer_name[i], customer_gender[i], customer_age[i]));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void searchCustomer() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No customers found");
            return;
        }
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID"));
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (customer_ID[i] == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Customer not found");
            return;
        }
        JOptionPane.showMessageDialog(null, String.format(" ID: %d\n Name: %s\n Gender: %s\n Age: %s", customer_ID[index], customer_name[index], customer_gender[index], customer_age[index]));
    }

    private void editCustomer() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No customers found");
            return;
        }
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID"));
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (customer_ID[i] == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Customer not found");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter new customer name");
        String gender = JOptionPane.showInputDialog("Enter ne customer gender");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter new customer age"));
        customer_name[index] = name;
        customer_gender[index] = gender;
        customer_age[index] = age;
        JOptionPane.showMessageDialog(null, "Customer updated");
    }

    private void deleteCustomer() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No customers found");
            return;
        }
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID"));
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (customer_ID[i] == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Customer not found");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            customer_ID[i] = customer_ID[i + 1];
            customer_name[i] = customer_name[i + 1];
            customer_gender[i] = customer_gender[i + 1];
            customer_age[i] = customer_age[i + 1];
        }
        count--;
        JOptionPane.showMessageDialog(null, "Customer deleted");
    }
}
           


