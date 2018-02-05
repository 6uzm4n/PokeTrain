import CSV.CSV;
import CSV.CSVReader;

import java.io.IOException;

public class Test {

    public static void main (String[] args) throws IOException {
        CSVReader reader = new CSVReader();
        CSV data = reader.readFile("res/PokemonList.csv",",","\"", true);
        data.print();
    }
}
