package correio.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Correio extends Remote {

    // Insere um novo usuário no sistema
    boolean cadastrarUsuario(Usuario u) throws RemoteException;

    // Recupera a primeira mensagem na lista de mensagens do usuario; a mensagem deve ser removida
    // Exigir autenticação do usuário
    Mensagem getMensagem(String userName, String senha) throws RemoteException;

    // retorna o número de mensagens na fila de mensagens dos usuário
    // Exigir autenticação do usuário
    int getNMensagens(String userName, String senha) throws RemoteException;

    // Exigir autenticação do usuário (senha do remetente, incluído como atributo da mensagem)
    boolean sendMensagem(String userName, String senha, Mensagem m, String userNameDestinatario) throws RemoteException;

    // Verifica o registro do usuário
    boolean login(String userName, String senha) throws RemoteException;
}
