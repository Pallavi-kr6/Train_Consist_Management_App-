// 🔹 Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// 🔹 Goods Bogie Class
class GoodsBogie {
    private String type;   // Cylindrical, Rectangular
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) {
        try {
            // 🔸 Safety Validation
            if (type.equalsIgnoreCase("Rectangular") &&
                cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe: Petroleum cannot be assigned to Rectangular bogie"
                );
            }

            // 🔸 Safe assignment
            this.cargo = cargo;
            System.out.println("Cargo '" + cargo + "' assigned to " + type + " bogie");

        } catch (CargoSafetyException e) {
            // 🔸 Handle exception gracefully
            System.out.println("Error: " + e.getMessage());

        } finally {
            // 🔸 Always executes
            System.out.println("Assignment attempt completed for " + type + " bogie\n");
        }
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Cargo: " + (cargo == null ? "None" : cargo);
    }
}

// 🔹 Main Application
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // 🔸 Create bogies
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // 🔸 Test Case 1: Safe assignment
        b1.assignCargo("Petroleum");

        // 🔸 Test Case 2: Unsafe assignment
        b2.assignCargo("Petroleum");

        // 🔸 Test Case 3: Another safe assignment
        b2.assignCargo("Coal");

        // 🔸 Verify final state
        System.out.println("Final Bogie States:");
        System.out.println(b1);
        System.out.println(b2);

        // 🔸 Program continues safely
        System.out.println("\nProgram execution continues...");
    }
}
