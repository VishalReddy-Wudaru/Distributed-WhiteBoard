# Distributed-WhiteBoard

Java RMI:
An interface named ChatInterface is created for implemented of functions in both client and server. This interface is also called remote interface. It is implemented by Server, Client and Paint1 classes.
Interface consists of seven methods:
1.	checkClientCredintials() //To verify client credentials
2.	broadcastMessage() // To send message to all clients
3.	broadcastPoint() //To send co-ordinates to all clients
4.	sendMessageToClient() //To print message in client window
5.	sendOnlineToClient() //To print online clients in window
6.	sendPointToClient() // To paint co-ordinates in window
7.	listOfClients() // To get online clients

A class named Paint1 is created for GUI. This provides a template for creating GUI at client end. Components used are label, textarea and button.
Functions in Paint1 class:
1.	first() //Initialization of the window
2.	mouseDragged() // If anyone draws something the co-ordinates are fetched using this function.
3.	addChat() //To append new message.
4.	changeOnlineLabel() //To change online users.
5.	plotPoint() //To draw the figure.


Server class is created to listen to client requests and act accordingly.
Functions in Server class:
1.	listOfClients() //To find online clients and broadcast to clients.
2.	checkClientCredintials() //To check client credentials.
3.	broadcastMessage() // To send message to all clients.
4.	broadcastPoint() //To send co-ordinates to all clients.

Client class is created to request to server for some functions.
Functions in Client class:
1.	sendMessageToClient() //To print message in client window
2.	sendOnlineToClient() //To print online clients in window
3.	sendPointToClient() // To paint co-ordinates in window


Design:

Java RMI:

![](/Images/JavaRMI.jpg)

Interface Implementation:

![](/Images/JavaRMI.jpg)

Design of the application:

![](/Images/JavaRMI.jpg)

