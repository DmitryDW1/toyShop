package toyShop.view;

import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.model.Toy;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class View {
    public void run(ToyQueue toyQueue, DataIO dataIO, FileWriter fileWriter){
        toyQueue.addToy(new Toy("1", "doll", 2));
        toyQueue.addToy(new Toy("2", "robot", 2));
        toyQueue.addToy(new Toy("3", "car", 6));
        List<Toy> prizeToys = toyQueue.getAllPrizeToys();
        for (int i = 0; i < 10; i++) {
            if (toyQueue.givePrizeToy()) {
                System.out.printf("Prize toy %d given\n", i + 1);
            } else {
                System.out.println("No prize toy available");
            }
        }
        dataIO.writePrizeToy(fileWriter, prizeToys);
    }
}