package net.david.fernandez.oblogatorio.dda.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.david.fernandez.oblogatorio.dda.common.Server;
import net.david.fernandez.oblogatorio.dda.server.entities.LoginController;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		System.out.println("Hello World!<--App Server -->");

		conecSer();
		// conecDb();

	}

	/* Este metodo es el de coneccion con RMI */
	public static void conecSer() throws RemoteException, AlreadyBoundException {
		// ---0---0---0---0---0---0//
		// --Desde aqui RMI--//
		System.out.println("Comienza RMI");

		System.setProperty("java.security.policy", "file://c:/java.policy");

		LocateRegistry.createRegistry(1099);
		ServerImpl obj = new ServerImpl();
		Server stub = (Server) UnicastRemoteObject.exportObject(obj, 0);
		// Bind the remote
		// object's stub in the registry
		Registry registry = LocateRegistry.getRegistry(1099);
		registry.bind("ser", stub);

		System.out.println("Finaliza RMI");
		// ----0---0---0---0---0//
	}

	
}
