package br.edu.fateczl.SpringAGIS.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dispensa {
	Aluno aluno;
	Disciplina disciplina;
	String nomeCurso;
	String motivo;
	String estado;
}
