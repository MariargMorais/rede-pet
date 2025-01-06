package ifpe.redepet.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.redepet.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPetId(Long petId);
    List<Consulta> findByVeterinarioId(Long vetId);
    List<Consulta> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}
