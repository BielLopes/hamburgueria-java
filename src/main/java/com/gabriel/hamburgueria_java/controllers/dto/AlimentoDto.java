package com.gabriel.hamburgueria_java.controllers.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.gabriel.hamburgueria_java.domain.Alimento;

@Getter
@Setter
@AllArgsConstructor
public class AlimentoDto {

  @NotBlank(message = "Nome é obrigatório")
  @Size(min = 3, max = 20, message = "Nome deve ter entre 3 e 20 caracteres")
  private String nome;

  @NotNull(message = "Preço é obrigatório")
  @Min(value = 0, message = "Preço deve ser maior que 0")
  private BigDecimal preco;

  private String descricao;

  @NotBlank(message = "Categoria é obrigatório")
  @Size(max = 20, message = "Categoria deve ter no máximo 20 caracteres")
  private String categoria;

  public Alimento toDomain() {
    return new Alimento(
        null,
        nome,
        preco,
        descricao,
        categoria);
  }
}