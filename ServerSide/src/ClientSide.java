import java.io.DataOutputStream;
import  java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import  java.net.*;
import  java.io.*;

public class ClientSide {
    public static void main(String[] args) {
        String temp;
        try{
            Socket s = new Socket("localhost", 4444);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            dout.writeUTF("Hellow Sever");
            System.out.println("String sent to sever....");
            temp = dis.readUTF();
            System.out.println("Message from the sever: " + temp);

            dis.close();
            dout.flush();
            s.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
