package toyShop;

import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.view.View;
import java.io.File;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) throws Exception{
        ToyQueue toyQueue = new ToyQueue();
        View view = new View();
        File prize = new File("src/prize_toys.txt");
        FileWriter fileWriter = new FileWriter(prize);
        DataIO dataIO = new DataIO();
        view.run(toyQueue,dataIO, fileWriter);
    }
}
