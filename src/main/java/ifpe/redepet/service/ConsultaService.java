package ifpe.redepet.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ifpe.redepet.model.Consulta;
import ifpe.redepet.repository.ConsultaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta agendar(Consulta consulta) {
        consulta.setCreatedAt(LocalDateTime.now());
        return consultaRepository.save(consulta);
    }

    public List<Consulta> buscarConsultasPorPet(Long petId) {
        return consultaRepository.findByPetId(petId);
    }

    public List<Consulta> buscarConsultasPorVeterinario(Long vetId) {
        return consultaRepository.findByVeterinarioId(vetId);
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public void cancelarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
