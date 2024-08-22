package br.com.athenas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.athenas.dto.PessoaDTO;
import br.com.athenas.entity.Pessoa;
import br.com.athenas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private Task task;
	
	public PessoaDTO incluir(PessoaDTO pessoaDTO) {
		return task.incluir(pessoaDTO);
	}

	public PessoaDTO alterar(PessoaDTO pessoaDTO) {
		task.alterar(pessoaDTO);
		return pessoaDTO;
	}

	public void excluir(Long id) {
		task.excluir(id);
	}

	public PessoaDTO pesquisar(Long id) {
		Pessoa pessoa = task.pesquisar(id);
		return new PessoaDTO(pessoa);
	}

	public double calcularPesoIdeal(PessoaDTO pessoaDTO) {
		return task.calcularPesoIdeal(pessoaDTO);
	}
}
