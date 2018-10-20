package correio.main;

import correio.gui.TelaLogin;
import correio.gui.TerminalCliente;
import correio.gui.TerminalServidor;
import java.util.Map;
import javax.swing.JOptionPane;

public class ApplicationMain {

    public static void main(String[] args) {
        try {
            String hostname = (args.length == 0) ? ("127.0.0.1") : (args[0]);
            int option = JOptionPane.showOptionDialog(null, "Vai executar como cliente ou servidor?", "Correio",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Cliente", "Servidor"}, null);
            if (option == 0) {
                Map<String, String> usuario = TelaLogin.getUsuarioFromLogin(hostname);
                if (usuario != null) {
                    TerminalCliente terminal = new TerminalCliente(usuario.get("user"), usuario.get("pass"), hostname);
                    terminal.setVisible(true);
                }
            } else {
                TerminalServidor terminal = new TerminalServidor(hostname);
                terminal.setVisible(true);
            }
        } catch (Exception e) {
            
        }
    }
    
}
