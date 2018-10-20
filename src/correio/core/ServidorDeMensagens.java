/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correio.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author filipe
 */
public class ServidorDeMensagens implements Correio {

    private Map<String, Usuario> usuarios;
    private List<ServidorListener> listeners;

    public ServidorDeMensagens(String hostname) {
        usuarios = new TreeMap<>();
        listeners = new ArrayList<>();
    }

    public void addServidorListener(ServidorListener listener) {
        listeners.add(listener);
    }
    
    private void notificarListeners() {
        for (ServidorListener listener : listeners) {
            listener.mudancaOcorrida();
        }
    }
    
    public boolean removerUsuario(String username) {
        if (usuarios.containsKey(username)) {
            usuarios.remove(username);
            notificarListeners();
            return true;
        }
        return false;
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
                notificarListeners();
                return true;
            }
        }
        return false;
    }

    @Override
    public Mensagem getMensagem(String userName, String senha) throws RemoteException {
        Usuario usuario = autenticar(userName, senha);
        if (usuario != null) {
            Mensagem mensagem = usuario.getMensagem();
            notificarListeners();
            return mensagem;
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
                notificarListeners();
                return true;
            } else {
                Mensagem erro = new Mensagem("Sistema do servidor - noreply", "Falha de envio", 
                        "O usuário \"" + userNameDestinatario + "\" não existe em nosso sistema!", new Date());
                usuarios.get(userName).putMensagem(erro);
                notificarListeners();
            }
        }
        return false;
    }

    @Override
    public boolean login(String userName, String senha) {
        Usuario usuario = autenticar(userName, senha);
        return usuario != null;
    }
    
    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(new ArrayList<>(usuarios.values()));
    }

}
