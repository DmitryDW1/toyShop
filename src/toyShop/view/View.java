package toyShop.view;

import toyShop.controller.ToyQueue;
import toyShop.controller.DataIO;
import toyShop.model.Toy;

import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class View {
    public void run(ToyQueue toyQueue, DataIO dataIO, FileWriter fileWriter){
        game(toyQueue);
        List<Toy> prizeToys = toyQueue.getAllPrizeToys();
        dataIO.writePrizeToy(prizeToys, fileWriter);
        if(!toyQueue.empty()){
            System.out.println("Оставшиеся игрушки " + toyQueue);
        }
    }

    private void newToy(ToyQueue toyQueue) {
        System.out.println("Хотите добавить игрушку? y/n");
        Scanner scannerAnswer = new Scanner(System.in);
        String keyAnswer = scannerAnswer.next();
        switch (keyAnswer) {
            case "y":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите название игрушки: ");
                String nameToy = scanner.nextLine();
                Double weightToy = getNewToy();
                toyQueue.addToy(new Toy(String.valueOf(toyQueue.sizeQueue()), nameToy, weightToy));
            case "n":
                return;
            default:
                System.out.println("Again");
                newToy(toyQueue);
        }
    }

    private Double getNewToy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вес игрушки: ");
        double weightToy = scanner.nextDouble();
        return weightToy;
    }

    private void game(ToyQueue toyQueue) {
        toyQueue.addToy(new Toy("1", "кукла", ThreadLocalRandom.current().nextInt(0, 100)));
        toyQueue.addToy(new Toy("2", "робот", ThreadLocalRandom.current().nextInt(0, 100)));
        toyQueue.addToy(new Toy("3", "машинка", ThreadLocalRandom.current().nextInt(0, 100)));
        System.out.println(toyQueue);
        newToy(toyQueue);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите поменять вес игрушки? y/n");
        String key = scanner.next();
        System.out.print("\033[H\033[J");
        switch (key){
            case "y":
                System.out.println("Для смены веса игрушки введите id:");
                String id = scanner.next();
                double userWeight = scanner.nextDouble();
                toyQueue.updateToyWeight(id, userWeight);
            case "n":
                System.out.println("Разыгрываются игрушки " + toyQueue);
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
        }
    }
}