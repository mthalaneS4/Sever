import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import  java.net.*;


public class ServerSide {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(4444);
            System.out.println("Sever Listening ..");
            Socket s = ss.accept();
            System.out.println("Request ACCEPTED");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String str = (String) dis.readUTF();
            System.out.println("message= " + str);

            dout.writeUTF("The sever received a message thank you.....");

            dout.close();
            dout.flush();
            ss.close();


        }catch (IOException e){
            System.out.println(e);
        }
    }
}
