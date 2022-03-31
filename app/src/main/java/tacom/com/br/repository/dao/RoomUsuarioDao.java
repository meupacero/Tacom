package tacom.com.br.repository.dao;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import tacom.com.br.model.UsuarioModel;

@Dao
public abstract class RoomUsuarioDao implements BaseRoomDao<UsuarioModel> {
    @Query("SELECT * FROM usuario")
    public abstract DataSource.Factory<Integer, UsuarioModel> fetchAll();
}
