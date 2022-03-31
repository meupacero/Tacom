package tacom.com.br.ui;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import javax.inject.Inject;

import tacom.com.br.R;
import tacom.com.br.databinding.UsuarioCadastroFragmentBinding;
import tacom.com.br.enviroment.App;
import tacom.com.br.repository.viewmodels.UsuarioViewModel;
import tacom.com.br.repository.viewmodels.factory.UsuarioFactory;

public class UsuarioCadastroFragment extends Fragment {
    @Inject
    UsuarioFactory factory;
    private UsuarioCadastroFragmentBinding binding;
    private UsuarioViewModel mViewModel;

    public UsuarioCadastroFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = UsuarioCadastroFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.getComponent().inject(this);
        mViewModel = new ViewModelProvider(requireActivity(), factory).get(UsuarioViewModel.class);
        binding.cadastrarBtn.setOnClickListener(v->onClickCadastro());
        binding.listarUsuario.setOnClickListener(v->onClickListaUsuarios());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClickCadastro() {
        String nome = binding.nome.getText().toString().trim();
        String sobrenome = binding.sobrenome.getText().toString().trim();

        if (nome.isEmpty() || nome.length() < 3) {
            binding.nome.setError("Informação inválida");
            return;
        }

        if (sobrenome.isEmpty() || sobrenome.length() < 3) {
            binding.sobrenome.setError("Informação inválida");
            return;
        }

        criarUsuario(nome, sobrenome);
    }

    private void criarUsuario(String nome, String sobrenome) {
        try {
            App.getComponent().getController().cadastrarUsuario(nome, sobrenome);
            mViewModel.atualizaLista();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Toast.makeText(getContext(), "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        limparCampos();
    }

    private void onClickListaUsuarios() {
        NavHostFragment.findNavController(this).navigate(R.id.ListaFragment);
    }
    private void limparCampos() {
        binding.nome.setText("");
        binding.sobrenome.setText("");
    }
}
