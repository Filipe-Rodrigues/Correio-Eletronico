package correio.core;

import java.util.LinkedList;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Usuario implements Serializable {

    private String userName;
    private String senha;
    private List<Mensagem> listaDeMensagens;

    public Usuario(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
        this.listaDeMensagens = new LinkedList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Mensagem getMensagem() {
        return (!listaDeMensagens.isEmpty()) 
                ? (listaDeMensagens.remove(0)) : (null);
    }
    
    public void putMensagem(Mensagem mensagemNova) {
        listaDeMensagens.add(mensagemNova);
    }

    public int getQtdMensagens() {
        return listaDeMensagens.size();
    }
}
