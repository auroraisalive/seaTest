package me.aurorash.seaTest.modules.setor;

import me.aurorash.seaTest.domain.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("SELECT s FROM Setor s WHERE s.nome = :nome")
    Optional<Setor> findByName(@Param("nome") String nome);

}
