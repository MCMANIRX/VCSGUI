import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ParamReader {
    static File list;
    static RandomAccessFile raf;

    public static Param[] readParams(File vc, File tsv) throws FileNotFoundException {
        list = tsv;
        Scanner listParse = new Scanner(list);

        ArrayList<Param> params = new ArrayList<Param>();

        listParse.nextLine();
        while (listParse.hasNextLine()) {


            String line = listParse.nextLine();
            String[] components = line.split("\t");
            if (components[4].length() > 1) {
                params.add(new Param(components[3], components[0], components[4], Integer.parseInt(components[1].startsWith("0x") ? components[1].substring(2):components[1], 16)));
            }

        }
        try {
            raf = new RandomAccessFile(vc, "r");

            for (Param p : params) {

                raf.seek(p.offset);
                if (p.type.equals("float"))
                    p.value = Float.floatToIntBits(raf.readFloat());
                else
                    p.value = raf.readInt();

                System.out.printf("Value: %x Offset: %x Type: %s\n",
                        p.type.equals("float") ?  p.value : p.value, p.offset,p.type);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return params.toArray(new Param[params.size()]);

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("hi");
    }

}
