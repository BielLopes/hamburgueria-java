package com.gabriel.hamburgueria_java.repositories.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.gabriel.hamburgueria_java.domain.Alimento;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "alimento")
public class AlimentoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private BigDecimal preco;
  private String descricao;
  private String categoria;

  // public AlimentoEntity(){}

  public Alimento toDomain() {
    return new Alimento(
      id,
      nome,
      preco,
      descricao,
      categoria
    );
  }

  public static AlimentoEntity toEntity(Alimento alimento) {
    AlimentoEntity entity = new AlimentoEntity(
      alimento.getId(),
      alimento.getNome(),
      alimento.getPreco(),
      alimento.getDescricao(),
      alimento.getCategoria()
    );
    return entity;
  }
}