package correio.core;

import java.util.Date;
import java.io.Serializable;

public class Mensagem implements Serializable {

    private String userNameRemetente;
    private String titulo;
    private String texto;
    private Date data;

    public Mensagem(String userNameRemetente, String titulo, String texto, Date data) {
        this.userNameRemetente = userNameRemetente;
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
    }

    public String getUserNameRemetente() {
        return userNameRemetente;
    }

    public void setUserNameRemetente(String userNameRemetente) {
        this.userNameRemetente = userNameRemetente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
