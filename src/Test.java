import CSV.CSV;
import CSV.CSVReader;

import java.io.IOException;

public class Test {

    public static void main (String[] args) throws IOException {
        CSVReader reader = new CSVReader();
        CSV data = reader.readFile("res/PokemonList.csv",",","\"", true);
        data.print();

        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", 55, "Quirk", 45, 49,
                49, 65, 65, 45, 31, 31,31,31,31,31,
                0,0,0,0,0,0);
        bulbasaur.printStats();

    }
}
