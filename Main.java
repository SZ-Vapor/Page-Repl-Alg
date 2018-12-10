/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc460_p10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<String> linesList = new ArrayList<>();

        String lines[] = getString(args[0]).split("[\\r\\n]+");
        for (String i : lines) {
            linesList.add(i.trim().replaceAll(" +", " "));
        }
        FIFO fifo = new FIFO(Integer.parseInt(args[1]));
        LRU lru = new LRU(Integer.parseInt(args[1]));
        for (int i = 0; i < linesList.size(); i++) {
            String z[] = linesList.get(i).split(" ");
            for (int j = 0; j < z.length; j++) {
                fifo.insert(Integer.parseInt(z[j]));
                lru.insert(Integer.parseInt(z[j]));
            }
            System.out.println("FIFO page faults for reference string " + (i + 1) + ": " + fifo.getPageFaultCount());
            System.out.println("LRU page faults for reference string " + (i + 1) + ": " + lru.getPageFaultCount());
            fifo.resetData();
            lru.resetData();
            System.out.println();

        }
    }

    /**
     * Sets all text in the input file as a single String
     * @param s The name of the file
     * @return THe text of the file as a String
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String getString(String s) throws FileNotFoundException, IOException {
        String everything;
        BufferedReader br = new BufferedReader(new FileReader(s));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        return everything;
    }

}
