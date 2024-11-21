package br.com.cesurg.sistema.site.core.dto;

public record OcupadosNomeOutput(
        int id,
        String sala,
        String turma,
        String professor,
        String materia
) {
}
