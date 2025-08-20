package forum.hub.challenger.registro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTopicos(
        @NotNull
        Long id,
        String mensagem,
        String nomeCurso,
        String titulo) {
}
