package tacom.com.br.repository.provider;
import androidx.paging.DataSource;

import java.util.List;

import javax.inject.Inject;

import tacom.com.br.model.UsuarioModel;
import tacom.com.br.repository.dao.RoomUsuarioDao;

public class UsuarioProvider {
    private final RoomUsuarioDao usuarioDao;

    @Inject
    public UsuarioProvider(RoomUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public DataSource.Factory<Integer, UsuarioModel> fetchAll() {
        return usuarioDao.fetchAll();
    }
}
