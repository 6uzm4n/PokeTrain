package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {

    public static CSV readFile(String pPath, String pSeparator, String pTextMark, boolean pHeader) throws IOException {
        CSV csv = new CSV();
        BufferedReader reader = new BufferedReader(new FileReader(pPath));
        String data = "";
        String readLine;


        //Reads and sets the headers if necessary
        if (pHeader && (readLine=reader.readLine())!=null){
            String[] cntLine = readLine.split(pSeparator);
            ArrayList<String> headers = new ArrayList<>();
            headers.addAll(Arrays.asList(cntLine));
            for (int i = 0; i < headers.size(); i++) {
                headers.set(i, headers.get(i).replace(pTextMark,""));
            }
            csv.setHeaders(headers);
        }

        //Reads and sets the data of the csv file
        while ((readLine = reader.readLine()) != null){
            String[] cntLine = readLine.split(pSeparator);
            ArrayList<Object> dataLine = new ArrayList<>();
            for (int i = 0; i < cntLine.length; i++) {
                if (cntLine[i].startsWith(pTextMark) && cntLine[i].endsWith(pTextMark)){
                    dataLine.add((String)cntLine[i].replace(pTextMark, ""));
                }else{
                    dataLine.add(cntLine[i]);
                }
            }
            csv.addData(dataLine);
        }

        return csv;
    }
}
