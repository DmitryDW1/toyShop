package toyShop.controller;

import toyShop.model.Toy;

import java.io.*;
import java.util.List;

public class DataIO {
    public void writePrizeToy(List<Toy> prizeToys, FileWriter fileWriter) {
        try {
            for (Toy prizeToy : prizeToys) {
                fileWriter.write(prizeToy.getName() + "\n");
            }
            fileWriter.write("--------" + "\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
