/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correio.utils;

import correio.core.Correio;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author filipe
 */
public class RMIUtils {
    public static Correio getStub(String hostname) {
        try {
            System.setProperty("java.rmi.server.hostname", hostname);
            Registry registro = LocateRegistry.getRegistry(hostname);
            return (Correio) registro.lookup("Correio");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cliente! Servidor não encontrado :(",
                    "Que merda kkkk", JOptionPane.ERROR_MESSAGE);
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cliente! Serviço não disponível pelo servidor :(",
                    "Que merda kkkk", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public static void registrarServicoRMI(Correio servico, String hostname) {
        try {
            Correio stub = (Correio) UnicastRemoteObject.exportObject(servico, 5001);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Correio", stub);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro no servidor! Vai da não pai :(",
                    "Que merda kkkk", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
