package forum.hub.challenger.registro;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "registros")
@Entity(name = "Registro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @Column(name = "nomeCurso")
    private String nomeCurso;
    private String titulo;

    public Registro(DadosRegistroTopicos dados) {
        this.mensagem = dados.mensagem();
        this.nomeCurso= dados.nomeCurso();
        this.titulo = dados.titulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void atualizarInformacoes(@Valid DadosAtualizaTopicos dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.nomeCurso() != null) {
            this.nomeCurso = dados.nomeCurso();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }
}
