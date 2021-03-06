package net.david.fernandez.oblogatorio.dda.server.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.david.fernandez.oblogatorio.dda.common.LoginController;
import net.david.fernandez.oblogatorio.dda.common.dto.Jugador;

public class LoginControllerImpl extends UnicastRemoteObject implements LoginController {

	private static final long serialVersionUID = 1L;
	private static LoginController instance = null;

	public static LoginController getInstance() throws RemoteException {
		if(instance == null) {
			instance = new LoginControllerImpl();
		}
		return instance;
	}

	private LoginControllerImpl() throws RemoteException {
		super();
	}

	public Jugador autenticar(String username, String password) throws RemoteException {
		Jugador jugador = new Jugador();
		jugador.setId(25);
		return jugador;
	}


}
