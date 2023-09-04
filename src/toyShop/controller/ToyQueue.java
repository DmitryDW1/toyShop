package toyShop.controller;

import toyShop.model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyQueue {
    private PriorityQueue<Toy> queue;
    private Random random;
    private List<Toy> prizeToys;

    public ToyQueue() {
        queue = new PriorityQueue<>((t1, t2) -> (int) (t1.getWeight() - t2.getWeight()));
        random = new Random();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        queue.add(toy);
    }

    public void updateToyWeight(String id, double weight) {
        Toy toy = queue.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        if (toy != null) {
            toy.setWeight(weight);
        }
    }

    private Toy chooseToy() {
        double rand = random.nextDouble() * 100;
        if (rand < 10) {
            return queue.stream().filter(t -> t.getWeight() <= 1).findFirst().orElse(null);
        } else if (rand < 60) {
            return queue.stream().filter(t -> t.getWeight() > 1 && t.getWeight() <= 10).findFirst().orElse(null);
        } else {
            return queue.stream().filter(t -> t.getWeight() > 11 && t.getWeight() <= 90).findFirst().orElse(null);
        }
    }
    public String givePrizeToy() {
        System.out.println(queue.toString());
        if (!queue.isEmpty()) {
            Toy prizeToy = chooseToy();
            if (prizeToy == null) {
                return "0";
            }else{
                queue.remove(prizeToy);
                prizeToys.add(prizeToy);
                System.out.println(queue.toString());
                return prizeToy.getName();
            }
        }
        return null;
    }

    public List<Toy> getAllPrizeToys() {
        return prizeToys;
    }
}