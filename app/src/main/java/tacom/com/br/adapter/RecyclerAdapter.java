package tacom.com.br.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import tacom.com.br.databinding.ItemListBinding;
import tacom.com.br.model.UsuarioModel;

public class RecyclerAdapter extends PagedListAdapter<UsuarioModel, RecyclerAdapter.ViewHolder> {

    public RecyclerAdapter() {
        super(DIFF_CALLBACK);
    }

    public static final DiffUtil.ItemCallback<UsuarioModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<UsuarioModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull UsuarioModel oldUser, @NonNull UsuarioModel newUser) {
            return oldUser.getId() == newUser.getId();
        }
        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull UsuarioModel oldUser, @NonNull UsuarioModel newUser) {
            return oldUser.equals(newUser);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(ItemListBinding.inflate(inflater));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final ItemListBinding binding;

        public ViewHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
