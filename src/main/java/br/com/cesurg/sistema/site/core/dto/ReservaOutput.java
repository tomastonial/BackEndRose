package br.com.cesurg.sistema.site.core.dto;

public record ReservaOutput(
        int id,
        String Professor,
        String Sala,
        String Turma,
        String Materia ) {
    public ReservaOutput(int id, String Professor, String Sala, String Turma, String Materia) {
        this.id = id;
        this.Professor = Professor;
        this.Sala = Sala;
        this.Turma = Turma;
        this.Materia = Materia;
    }
}
