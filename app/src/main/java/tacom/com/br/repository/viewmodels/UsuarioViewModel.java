package tacom.com.br.repository.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

import tacom.com.br.model.UsuarioModel;
import tacom.com.br.repository.provider.UsuarioProvider;

public class UsuarioViewModel extends ViewModel {

    private final UsuarioProvider provider;

    private LiveData<PagedList<UsuarioModel>> pagedListLiveData;

    @Inject
    public UsuarioViewModel(UsuarioProvider provider) {
        this.provider = provider;
        atualizaLista();
    }

    public LiveData<PagedList<UsuarioModel>> getUsuarios() {
        if (pagedListLiveData == null)
            pagedListLiveData = new MutableLiveData<>();
        return pagedListLiveData;
    }

    public void atualizaLista() {
        pagedListLiveData = new LivePagedListBuilder<>(provider.fetchAll(), 10).build();
    }
}