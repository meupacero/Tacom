package tacom.com.br.inject.component;

import javax.inject.Singleton;

import dagger.Component;
import tacom.com.br.MainActivity;
import tacom.com.br.enviroment.manager.Controller;
import tacom.com.br.inject.modulo.AppModulo;
import tacom.com.br.ui.UsuarioCadastroFragment;
import tacom.com.br.ui.UsuarioListaFragment;

@Singleton
@Component(modules = {AppModulo.class})
public interface AppComponent {
    Controller getController();
    void inject(UsuarioCadastroFragment cadastroFragment);
    void inject(UsuarioListaFragment listaFragment);
}
