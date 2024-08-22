package br.com.athenas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.athenas.dto.PessoaDTO;
import br.com.athenas.entity.Pessoa;
import br.com.athenas.repository.PessoaRepository;

@Component
public class Task {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaDTO incluir(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa(pessoaDTO);
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		PessoaDTO pessoaSalvaDTO = new PessoaDTO(pessoaSalva);
		return pessoaSalvaDTO;
	}

	public PessoaDTO alterar(PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaRepository.findById(pessoaDTO.getId()).orElseThrow();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setSexo(pessoaDTO.getSexo());
		pessoa.setAltura(pessoaDTO.getAltura());
		pessoa.setPeso(pessoaDTO.getPeso());
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		PessoaDTO pessoaSalvaDTO = new PessoaDTO(pessoaSalva);
		return pessoaSalvaDTO;
	}

	public void excluir(Long id) {
		pessoaRepository.deleteById(id);
	}

	public Pessoa pesquisar(Long id) {
		return pessoaRepository.findById(id).orElseThrow();
	}

	public double calcularPesoIdeal(PessoaDTO pessoaDTO) {
		if (pessoaDTO.getSexo() == 'M') {
			return (72.7 * pessoaDTO.getAltura()) - 58;
		} else {
			return (62.1 * pessoaDTO.getAltura()) - 44.7;
		}
	}

}
