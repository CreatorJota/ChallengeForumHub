package forum.hub.challenger.registro;

public record DadosListarRegistro(Long id, String mensagem, String nomeCurso, String titulo) {

    public DadosListarRegistro(Registro registro){
        this(registro.getId(), registro.getMensagem(), registro.getNomeCurso(), registro.getTitulo());
    }
}
