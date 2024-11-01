package com.gabriel.hamburgueria_java.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;

import com.gabriel.hamburgueria_java.controllers.dto.AlimentoDto;
import com.gabriel.hamburgueria_java.domain.Alimento;
import com.gabriel.hamburgueria_java.services.AlimentoService;

@RestController
@RequestMapping("/v1/alimento")
public class AlimentoController {

  private final AlimentoService alimentoService;

  public AlimentoController(AlimentoService alimentoService) {
    this.alimentoService = alimentoService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Alimento salvar(@Valid @RequestBody AlimentoDto alimentoDto) {
    return alimentoService.salvar(alimentoDto);
  }

  @GetMapping
  public List<Alimento> buscarTodos() {
    return alimentoService.buscarTodos();
  }

  @GetMapping("/{pesquisa}")
  public Alimento buscarComFiltro(@PathVariable String pesquisa) {
    return alimentoService.buscarComFiltro(pesquisa);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletar(@PathVariable Long id) {
    alimentoService.deletar(id);
  }

  @PutMapping("/{id}")
  public Alimento atualizar(@PathVariable Long id, @RequestBody AlimentoDto alimentoDto) {
    return alimentoService.atualizar(id, alimentoDto);
  }
}