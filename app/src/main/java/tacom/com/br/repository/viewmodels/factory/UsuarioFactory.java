package tacom.com.br.repository.viewmodels.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import tacom.com.br.repository.provider.UsuarioProvider;
import tacom.com.br.repository.viewmodels.UsuarioViewModel;

public class UsuarioFactory implements ViewModelProvider.Factory {
    private final UsuarioProvider provider;

    public UsuarioFactory(UsuarioProvider provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new UsuarioViewModel(provider);
    }
}
