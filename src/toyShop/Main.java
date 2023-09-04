package toyShop;

import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.model.Toy;
import toyShop.view.View;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        ToyQueue toyQueue = new ToyQueue();
        View view = new View();
        File prizeToys = new File("src/prize_toys.txt");
        FileWriter fileWriter = new FileWriter(prizeToys);
        DataIO dataIO = new DataIO();
        view.run(toyQueue, dataIO, fileWriter);
    }
}
