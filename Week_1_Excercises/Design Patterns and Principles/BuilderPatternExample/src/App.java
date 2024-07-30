public class App {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB", "256GB SSD")
                                    .build();
        System.out.println(basicComputer);

        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB", "1TB SSD")
                                     .setGraphicsCard(true)
                                     .build();
        System.out.println(gamingComputer);

        Computer highEndComputer = new Computer.Builder("Intel i9", "32GB", "2TB SSD")
                                      .setGraphicsCard(true)
                                      .setBluetooth(true)
                                      .build();
        System.out.println(highEndComputer);
    }
}
