package me.aurorash.seaTest.modules.trabalhador;

import me.aurorash.seaTest.domain.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Integer> {

    @Query("SELECT t FROM Trabalhador t WHERE t.cpf = :cpf")
    Optional<Trabalhador> findByCPF(@Param("cpf") String cpf);


}
