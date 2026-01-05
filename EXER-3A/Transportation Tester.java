public class TransportationTester {
    public static void main(String[] args) {
        // Instances for Land
        Truck t = new Truck();
        SUV s = new SUV();
        
        // Instances for Air
        Airplane a = new Airplane();
        Helicopter h = new Helicopter();
        
        // Instances for Water
        Ship sh = new Ship();
        Submarine sub = new Submarine();

        System.out.println("Successfully instantiated all transportation categories.");
    }
}
