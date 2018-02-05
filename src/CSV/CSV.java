package CSV;

import java.util.ArrayList;

public class CSV {
    private ArrayList<String> header;
    private ArrayList<ArrayList<Object>> data;

    public CSV (){
         this.data = new ArrayList<>();
    }

    public void setHeaders(ArrayList<String> pHeader) {
        this.header = pHeader;
    }

    public void addData(ArrayList<Object> dataLine) {
        this.data.add(dataLine);
    }

    public void print(){
        int[] max  = maxSize();
        String midDiv = getDiv(max, "mid");
        String topDiv = getDiv(max, "top");
        String botDiv = getDiv(max, "bot");
        System.out.println(topDiv);
        if (header!=null){
            System.out.print("║");
            for (int i = 0; i < header.size(); i++) {
                System.out.print(parseStringLength(header.get(i), max[i]));
                System.out.print("║");
            }
            System.out.println();
            System.out.println(midDiv);
        }

        if (data!=null){
            for (int i = 0; i < data.size(); i++) {
                System.out.print("║");
                for (int j = 0; j < data.get(i).size(); j++) {
                    System.out.print(parseStringLength((String) data.get(i).get(j), max[j]));
                    System.out.print("║");
                }
                System.out.println();
            }
            System.out.println(botDiv);
        }
    }

    private int[] maxSize(){
        int size = data.get(0).size();
        int[] max = new int[size];
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < size; j++) {
                if (max[j]<data.get(i).get(j).toString().length()){
                    max[j] = data.get(i).get(j).toString().length();
                }
            }
        }
        if (header!=null){
            for (int i = 0; i < header.size(); i++) {
                if (max[i]<header.get(i).length()){
                    max[i] = header.get(i).length();
                }
            }
        }
        return max;
    }

    private String parseStringLength(String pString, int pLength){
        String res = pString;
        while (res.length() < pLength){
            res = res + " ";
        }
        return res;
    }

    private String getDiv(int[] max, String pPos){
        String res = "";
        String div = "═";
        String divL = "";
        String divM = "";
        String divR = "";
        switch (pPos){
            case "top":
                divL = "╔";
                divM = "╦";
                divR = "╗";
                break;
            case "mid":
                divL = "╠";
                divM = "╬";
                divR = "╣";
                break;
            case "bot":
                divL = "╚";
                divM = "╩";
                divR = "╝";
                break;
        }
        res += divL;
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[i]; j++) {
                res += div;
            }
            if (i != max.length-1){
                res += divM;
            }else{
                res += divR;
            }
        }
        return res;
    }
}
