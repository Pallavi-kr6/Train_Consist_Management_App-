import java.util.regex.*;

// 🔹 Main App
public class TrainConsistManagementApp {

    // 🔸 Validate Train ID
    public static boolean validateTrainID(String trainId) {
        if (trainId == null) return false;

        String trainPattern = "TRN-\\d{4}"; // TRN-1234
        Pattern pattern = Pattern.compile(trainPattern);
        Matcher matcher = pattern.matcher(trainId);

        return matcher.matches();
    }

    // 🔸 Validate Cargo Code
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;

        String cargoPattern = "PET-[A-Z]{2}"; // PET-AB
        Pattern pattern = Pattern.compile(cargoPattern);
        Matcher matcher = pattern.matcher(cargoCode);

        return matcher.matches();
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // 🔸 Sample Inputs
        String trainId1 = "TRN-1234";
        String trainId2 = "TRAIN12";

        String cargo1 = "PET-AB";
        String cargo2 = "PET-ab";

        // 🔸 Validate Train IDs
        System.out.println("Train ID " + trainId1 + " valid: " + validateTrainID(trainId1));
        System.out.println("Train ID " + trainId2 + " valid: " + validateTrainID(trainId2));

        // 🔸 Validate Cargo Codes
        System.out.println("Cargo Code " + cargo1 + " valid: " + validateCargoCode(cargo1));
        System.out.println("Cargo Code " + cargo2 + " valid: " + validateCargoCode(cargo2));

        // 🔸 Edge Cases
        System.out.println("Empty Train ID valid: " + validateTrainID(""));
        System.out.println("Null Cargo Code valid: " + validateCargoCode(null));
    }
}
