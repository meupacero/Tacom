package tacom.com.br.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class UsuarioModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String nome;
    private String sobrenome;

    public UsuarioModel(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
