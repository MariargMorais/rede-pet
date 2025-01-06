package ifpe.redepet.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ifpe.redepet.model.Pet;
import ifpe.redepet.repository.PetRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet salvar(Pet pet) {
        pet.setCreatedAt(LocalDateTime.now());
        return petRepository.save(pet);
    }

    public List<Pet> buscarPorCliente(Long clienteId) {
        return petRepository.findByClienteId(clienteId);
    }

    public Pet buscarPorId(Long id) {
        return petRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    public Pet atualizar(Long id, Pet pet) {
        Pet petExistente = buscarPorId(id);
        petExistente.setNome(pet.getNome());
        petExistente.setEspecie(pet.getEspecie());
        petExistente.setRaca(pet.getRaca());
        petExistente.setIdade(pet.getIdade());
        return petRepository.save(petExistente);
    }

    public void deletar(Long id) {
        petRepository.deleteById(id);
    }
}
