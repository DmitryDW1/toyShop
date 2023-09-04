package toyShop.view;

import org.apache.commons.math3.util.Precision;
import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.model.Toy;

import java.io.FileWriter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class View {
    public void run(ToyQueue toyQueue, DataIO dataIO, FileWriter fileWriter){

        toyQueue.addToy(new Toy("1", "кукла", ThreadLocalRandom.current().nextInt(0, 100)));
        toyQueue.addToy(new Toy("2", "робот", ThreadLocalRandom.current().nextInt(0, 100)));
        toyQueue.addToy(new Toy("3", "машинка", ThreadLocalRandom.current().nextInt(0, 100)));
        System.out.println("");
        List<Toy> prizeToys = toyQueue.getAllPrizeToys();
        for (int i = 0; i < 10; i++) {
            Object userPrize = toyQueue.givePrizeToy();
            if (userPrize != null && userPrize != "0") {
                System.out.printf("Призовая игрушка " + "\"" + userPrize + "\"" + " разыграна\n", i + 1);
            }else if(userPrize == "0"){
                System.out.println("Приз не разыгран");
            }else {
                System.out.println("Игрушки закончились");
                i = 10;
            }
        }
        dataIO.writePrizeToy(fileWriter, prizeToys);
    }
}