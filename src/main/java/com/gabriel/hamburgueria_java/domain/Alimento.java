package com.gabriel.hamburgueria_java.domain;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Alimento {
  private Long id;
  private final String nome;
  private final BigDecimal preco;
  private final String descricao;
  private final String categoria;

  public Alimento(Long id, String nome, BigDecimal preco, String descricao, String categoria) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.descricao = descricao;
    this.categoria = categoria;
  }
}
