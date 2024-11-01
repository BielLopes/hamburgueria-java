package com.gabriel.hamburgueria_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabriel.hamburgueria_java.repositories.models.AlimentoEntity;

public interface AlimentoRepository extends JpaRepository<AlimentoEntity, Long> {
    AlimentoEntity findByNome(String nome);
}