package tacom.com.br.inject.modulo;
import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import tacom.com.br.repository.dao.AppDatabase;
import tacom.com.br.repository.dao.RoomUsuarioDao;
import tacom.com.br.repository.provider.UsuarioProvider;
import tacom.com.br.repository.viewmodels.factory.UsuarioFactory;

@Module
public class AppModulo {
    private final Application application;

    public AppModulo(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public RoomUsuarioDao getUsuarioDao(AppDatabase dataBase) {
        return dataBase.getUsuarioDao();
    }

    @Singleton
    @Provides
    public UsuarioFactory getUsuarioFactory(UsuarioProvider provider) {
        return new UsuarioFactory(provider);
    }

    @Singleton
    @Provides
    public AppDatabase getDatabase(){
        return AppDatabase.get(providerContext());
    }

    @Singleton
    @Provides
    public Context providerContext(){
        return application.getApplicationContext();
    }
}
