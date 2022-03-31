package tacom.com.br.repository.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import tacom.com.br.model.UsuarioModel;

@Database(entities = {UsuarioModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static AppDatabase get(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"TacomDB").allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public abstract RoomUsuarioDao getUsuarioDao();
}
