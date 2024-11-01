package com.gabriel.hamburgueria_java.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.gabriel.hamburgueria_java.domain.Alimento;
import com.gabriel.hamburgueria_java.controllers.dto.AlimentoDto;
import com.gabriel.hamburgueria_java.repositories.AlimentoRepository;
import com.gabriel.hamburgueria_java.repositories.models.AlimentoEntity;

@Service
public class AlimentoService {

  private final AlimentoRepository alimentoRepository;

  public AlimentoService(AlimentoRepository alimentoRepository) {
    this.alimentoRepository = alimentoRepository;
  }

  public Alimento salvar(AlimentoDto alimentoDto) {
    Alimento alimento = alimentoDto.toDomain();
    return alimentoRepository.save(AlimentoEntity.toEntity(alimento)).toDomain();
  }

  public List<Alimento> buscarTodos() {
    return alimentoRepository.findAll().stream()
        .map(AlimentoEntity::toDomain)
        .collect(Collectors.toList());
  }

  public Alimento buscarComFiltro(String pesquisa) {
    Long id = null;
    try {
      id = Long.parseLong(pesquisa);
    } catch (NumberFormatException e) {
      // pesquisa is not a number
    }

    AlimentoEntity alimentoEntity;
    if (id == null) {
      alimentoEntity = alimentoRepository.findByNome(pesquisa);
    } else {
      alimentoEntity = alimentoRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("Alimento not found"));
    }
    return alimentoEntity.toDomain();
  }

  public void deletar(Long id) {
    alimentoRepository.deleteById(id);
  }

  public Alimento atualizar(Long id, AlimentoDto alimentoDto) {
    Alimento alimento = alimentoDto.toDomain();
    alimento.setId(id);
    return alimentoRepository.save(AlimentoEntity.toEntity(alimento)).toDomain();
  }
}