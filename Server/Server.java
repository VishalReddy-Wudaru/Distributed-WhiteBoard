import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Server extends Frame implements MouseMotionListener{

	private Socket          socket   = null;
	private ServerSocket    server   = null;
    private DataInputStream in       =  null;

    Server(int port){
		addMouseMotionListener(this);
		        addWindowListener(new WindowAdapter(){
				            public void windowClosing(WindowEvent e) {
				                dispose();
				            }
		        });
		        setSize(500,500);
		        setLayout(null);
        		setVisible(true);

		try
		        {
		            server = new ServerSocket(port);
		            System.out.println("Server started");

		            System.out.println("Waiting for a client ...");

		            socket = server.accept();
		            System.out.println("Client accepted");

		            // takes input from the client socket
		            in = new DataInputStream(
		                new BufferedInputStream(socket.getInputStream()));
					int value1=0,value2=0;
		            while (value1!=-1 && value2!=-1)
					            {
					                try
					                {
					                    value1 = in.readInt();
										value2 = in.readInt();
										if(value1!=-1 && value2!=-1)
										{
					 						Graphics g=getGraphics();
										    g.setColor(Color.BLUE);
    										g.fillOval(value1,value2,5,5);
										}
					                }
					                catch(IOException i)
					                {
					                    System.out.println(i);
					                }
            					}


			}
			catch(IOException i)
			{
			     System.out.println(i);
        	}

    }
public void mouseDragged(MouseEvent e) {
    Graphics g=getGraphics();
    g.setColor(Color.RED);
    g.fillOval(e.getX(),e.getY(),5,5);
}
public void mouseMoved(MouseEvent e) {}

public static void main(String[] args) {
    new Server(5000);
}
}