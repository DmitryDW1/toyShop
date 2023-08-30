package toyShop.view;

import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.model.Toy;

import java.io.FileWriter;
import java.util.List;


public class View {
    public void run(ToyQueue toyQueue, DataIO dataIO, FileWriter fileWriter, List<Toy> prizeToys){
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