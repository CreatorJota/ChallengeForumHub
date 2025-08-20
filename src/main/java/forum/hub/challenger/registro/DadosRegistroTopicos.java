package forum.hub.challenger.registro;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistroTopicos(
        @NotBlank
        String mensagem,

        @NotBlank
        String nomeCurso,

        @NotBlank
        String titulo
) {
}
