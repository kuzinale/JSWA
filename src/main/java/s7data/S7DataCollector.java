package s7data;

import libnodave.Nodave;
import java.util.ArrayList;

/**
 * Created by kuzin.al on 30.06.2017.
 * Данный выполняет след. функции:
 * 1. Коннектится ко всем PLC
 * 2. Читает данные в несколько потоков, количество потоков = количеству PLC
 * 3. Все данные сохраняются в структуры, надо подумать сколько и какие.
 */
public class S7DataCollector {
    public static void main(String[] args) {
        ArrayList<Integer> intValues = new ArrayList<>();
        ArrayList<Integer> intValues2 = new ArrayList<>();
        ArrayList<Float>   floatValues = new ArrayList<>();
        ArrayList<Integer> byteValues = new ArrayList<>();
        DataIsoTCP.Start("192.168.0.40");

        DataIsoTCP.readIntegers(Nodave.DB,250,0,102);



        //Get Integers
        /*
        intValues.addAll(org.tags.DataIsoTCP.readIntegers(Nodave.DB,250,0,102));
        intValues.addAll(org.tags.DataIsoTCP.readIntegers(Nodave.DB,250,104,102));
        intValues.addAll(org.tags.DataIsoTCP.readIntegers(Nodave.DB,250,206,102));
        intValues.addAll(org.tags.DataIsoTCP.readIntegers(Nodave.DB,250,308,102));
        intValues.addAll(org.tags.DataIsoTCP.readIntegers(Nodave.DB,250,410,102));
        intValues.addAll(org.tags.DataIsoTCP.readIntegers(Nodave.DB,250,512,14));

        //get floats
        floatValues.addAll(org.tags.DataIsoTCP.readReals(Nodave.DB,250,1048,100));//25
        floatValues.addAll(org.tags.DataIsoTCP.readReals(Nodave.DB,250,1048,100));//50
        floatValues.addAll(org.tags.DataIsoTCP.readReals(Nodave.DB,250,1048,100));//75
        floatValues.addAll(org.tags.DataIsoTCP.readReals(Nodave.DB,250,1048,100));//100
        floatValues.addAll(org.tags.DataIsoTCP.readReals(Nodave.DB,250,1048,96));//125<>124

        //get bytes
        floatValues.addAll(org.tags.DataIsoTCP.readReals(Nodave.DB,250,536,64));//25
        //get bools

        */
        //Test for nio
        for (int i :
                DataIsoTCP.readIntegers2(Nodave.DB,250,0,102).asIntBuffer().array()) {
            System.out.println(i);
        }
        //org.tags.DataIsoTCP.readIntegers2(Nodave.DB,250,0,102);


/*
        for (Integer outPut  : intValues2)
        {
            System.out.println(outPut);

        }

        ByteBuffer buffer = ByteBuffer.allocate(102);


*/


        //System.out.println(org.tags.DataIsoTCP.readIntegers(0,250,46,2));
        DataIsoTCP.Disconnection();
    }
}
