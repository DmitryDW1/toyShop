package toyShop.controller;

import toyShop.model.Toy;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataIO {
    public void writePrizeToy(FileWriter fileWriter, List<Toy> prizeToys) {
        try {
            for (Toy prizeToy : prizeToys) {
                fileWriter.write(prizeToy.getName() + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
