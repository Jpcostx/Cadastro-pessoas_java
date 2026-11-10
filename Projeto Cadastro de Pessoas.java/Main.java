import controller.PessoaController;
import model.PessoaDAO;
import view.PessoaView;

public class Main {
    public static void main(String[] args) {
        PessoaDAO model = new PessoaDAO();
        PessoaView view = new PessoaView();
        PessoaController controller = new PessoaController(model, view);

        controller.iniciar();
    }
}