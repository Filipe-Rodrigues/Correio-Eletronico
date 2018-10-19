/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correio.core;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author filipe
 */
public class Servidor implements Correio {

    private Map<String, Usuario> usuarios;

    public Servidor() {
        usuarios = new TreeMap<>();
    }

    private Usuario autenticar(String userName, String senha) {
        if (usuarios.containsKey(userName)) {
            Usuario usuario = usuarios.get(userName);
            if (usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean cadastrarUsuario(Usuario u) throws RemoteException {
        if (u != null) {
            if (!usuarios.containsKey(u.getUserName())) {
                usuarios.put(u.getUserName(), u);
                return true;
            }
        }
        return false;
    }

    @Override
    public Mensagem getMensagem(String userName, String senha) throws RemoteException {
        Usuario usuario = autenticar(userName, senha);
        if (usuario != null) {
            return usuario.getMensagem();
        }
        return null;
    }

    @Override
    public int getNMensagens(String userName, String senha) throws RemoteException {
        Usuario usuario = autenticar(userName, senha);
        if (usuario != null) {
            return usuario.getQtdMensagens();
        }
        return -1;
    }

    @Override
    public boolean sendMensagem(String userName, String senha, Mensagem m, String userNameDestinatario) throws RemoteException {
        Usuario usuario = autenticar(userName, senha);
        if (usuario != null) {
            if (usuarios.containsKey(userNameDestinatario)) {
                usuarios.get(userNameDestinatario).putMensagem(m);
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario login(String userName, String senha) {
        Usuario usuario = autenticar(userName, senha);
        if (usuario != null) {
            return usuario;
        }
        return null;
    }

}
