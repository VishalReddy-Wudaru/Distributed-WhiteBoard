import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Client extends Frame implements MouseMotionListener{

	private Socket socket            = null;
	private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    Client(String address, int port){

		try
		        {
		            socket = new Socket(address, port);
		            System.out.println("Connected");

		            // takes input from terminal
		            input  = new DataInputStream(System.in);

		            // sends output to the socket
		            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
		        {
		            System.out.println(u);
		        }
		        catch(IOException i)
		        {
		            System.out.println(i);
        		}

        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e) {
						try
						    {
								out.writeInt(-1);
						    	out.writeInt(-1);
							}
							catch(IOException i)
							 {
							        System.out.println(i);
     						}
		                dispose();
		            }
        });
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
public void mouseDragged(MouseEvent e) {
    Graphics g=getGraphics();
    g.setColor(Color.BLUE);
    g.fillOval(e.getX(),e.getY(),5,5);
    try
    {
		out.writeInt(e.getX());
    	out.writeInt(e.getY());
	}
	catch(IOException i)
	 {
	        System.out.println(i);
     }

}
public void mouseMoved(MouseEvent e) {}

public static void main(String[] args) {
    new Client("10.7.4.195", 5000);
}
}

