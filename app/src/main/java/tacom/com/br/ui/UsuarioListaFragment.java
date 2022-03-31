package tacom.com.br.ui;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import javax.inject.Inject;

import tacom.com.br.adapter.RecyclerAdapter;
import tacom.com.br.databinding.UsuarioListaFragmentBinding;
import tacom.com.br.enviroment.App;
import tacom.com.br.repository.viewmodels.UsuarioViewModel;
import tacom.com.br.repository.viewmodels.factory.UsuarioFactory;

public class UsuarioListaFragment extends Fragment {
    @Inject
    UsuarioFactory factory;
    private UsuarioListaFragmentBinding binding;
    private RecyclerAdapter adapter;

    public UsuarioListaFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = UsuarioListaFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        configuraAdapter();
        App.getComponent().inject(this);
        UsuarioViewModel mViewModel = new ViewModelProvider(requireActivity()).get(UsuarioViewModel.class);
        mViewModel.getUsuarios().observe(getViewLifecycleOwner(), usuarios -> adapter.submitList(usuarios));
    }

    private void configuraAdapter() {
        adapter = new RecyclerAdapter();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycleView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
