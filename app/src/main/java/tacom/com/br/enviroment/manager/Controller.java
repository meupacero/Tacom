package tacom.com.br.enviroment.manager;

import javax.inject.Inject;

import tacom.com.br.model.UsuarioModel;
import tacom.com.br.repository.dao.RoomUsuarioDao;

public class Controller {
    private final RoomUsuarioDao roomUsuarioDao;

    @Inject
    public Controller(RoomUsuarioDao roomUsuarioDao) {
        this.roomUsuarioDao = roomUsuarioDao;
    }

    public void cadastrarUsuario(String nome, String sobrenome) throws Exception {
        UsuarioModel novoUsuario = new UsuarioModel(nome,sobrenome);
        roomUsuarioDao.insert(novoUsuario);
    }
}
