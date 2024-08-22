package br.com.athenas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.athenas.dto.PessoaDTO;
import br.com.athenas.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public ResponseEntity<PessoaDTO> incluir(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pessoaDTOIncluida = pessoaService.incluir(pessoaDTO);
        return ResponseEntity.ok(pessoaDTOIncluida);
    }

    @PutMapping("/")
    public ResponseEntity<PessoaDTO> alterar(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pessoaDTOAlterada = pessoaService.alterar(pessoaDTO);
        return ResponseEntity.ok(pessoaDTOAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> pesquisar(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.pesquisar(id);
        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping("/{id}/peso-ideal")
    public ResponseEntity<Double> calcularPesoIdeal(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.pesquisar(id);
        double pesoIdeal = pessoaService.calcularPesoIdeal(pessoaDTO);
        return ResponseEntity.ok(pesoIdeal);
    }
}
