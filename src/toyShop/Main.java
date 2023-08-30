package toyShop;

import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.model.Toy;
import toyShop.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        ToyQueue toyQueue = new ToyQueue();
        toyQueue.addToy(new Toy("1", "doll", 2));
        toyQueue.addToy(new Toy("2", "robot", 2));
        toyQueue.addToy(new Toy("3", "car", 6));
        List<Toy> prizeToys = toyQueue.getAllPrizeToys();
        View view = new View();
        File file = new File("src/prize_toys.txt");
        FileWriter fileWriter = new FileWriter(file);
        DataIO dataIO = new DataIO();
        view.run(toyQueue, dataIO, fileWriter, prizeToys);
    }
}
