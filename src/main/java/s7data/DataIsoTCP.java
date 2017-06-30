package s7data;

import libnodave.Nodave;
import libnodave.PLCinterface;
import libnodave.TCPConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;


/**
 * Created by kuzin.al on 05.12.2016.
 */
public class DataIsoTCP {
    public static boolean Connection = false;
    public static char buf[];
    public static byte buf1[];

    public static PLCinterface di;
    public static TCPConnection dc;
    public static Socket socket;
    public static int slot;
    public static byte[] by;
    public static String IP;

    //IP some IP
    DataIsoTCP(String host) {
        IP = host;
        buf = new char[Nodave.OrderCodeSize];
        buf1 = new byte[Nodave.PartnerListSize];
        try {
            socket = new Socket(host, 102);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static void startConnection() {
        Connection = false;
        OutputStream oStream = null;
        InputStream iStream = null;
        slot = 2;
        if (socket != null) {
            try {
                oStream = socket.getOutputStream();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                iStream = socket.getInputStream();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            di = new PLCinterface(oStream, iStream, "IF1", 0, Nodave.PROTOCOL_ISOTCP);
            dc = new TCPConnection(di, 0, slot);
            int res = dc.connectPLC();
            if (0 == res) {
                Connection = true;
                System.out.println("Connection Ok");

            } else System.out.println("No connection");
        }
    }

    //Disconnect
    public static void Disconnection() {
        if (Connection == true) {
            Connection = false;
            dc.disconnectPLC();
            di.disconnectAdapter();
            System.out.println("Disconnected");
        }
    }

    public static ArrayList<Float> readReals(int area, int DBnum, int number, int bytes) {
        ArrayList<Float> result = new ArrayList<>();

        if (Connection) {
            dc.readBytes(area, DBnum, number, bytes, null);
            for (int i = number; i < number+bytes; i += 4) {
                result.add(dc.getFloat());
            }
        }
        return result;
    }

    public static ArrayList<Integer> readIntegers(int area, int DBnum, int number, int bytes) {
        ArrayList<Integer> result = new ArrayList<>();

        if (Connection) {
            dc.readBytes(area, DBnum, number, bytes, null);
            for (int i = number; i < number + bytes; i += 2) {
                result.add(dc.getBYTE());
            }
        }
        return result;
    }

    public static ByteBuffer readIntegers2(int area, int DBnum, int number, int bytes) {
        ByteBuffer result = ByteBuffer.allocate(bytes);
        byte[] buffer = new byte[bytes];

        if (Connection) {
            dc.readBytes(area, DBnum, number, bytes, buffer);
 //           for (int i = number; i < number + bytes; i += 2) {
 //               result.add(dc.getINT());
  //          }
            result.put(buffer);
        }
        return result;
    }

    public static ArrayList<Integer> readBytes(int area, int DBnum, int number, int bytes) {
        ArrayList<Integer> result = new ArrayList<>();

        if (Connection) {
            dc.readBytes(area, DBnum, number, bytes, null);
            for (int i = number; i < number + bytes; i += 2) {
                result.add(dc.getBYTE());
            }
        }
        return result;
    }

        //Connect
    public static void Start(String adres) {
        //Nodave.Debug = Nodave.DEBUG_ALL ^ (Nodave.DEBUG_IFACE | Nodave.DEBUG_SPECIALCHARS);
        DataIsoTCP tp = new DataIsoTCP(adres);
        tp.startConnection();
    }

}


