package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	public Vet findById(Long id) {
		return super.findById(id);
	}

	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public void save(Vet object) {
		super.save(object.getId(), object);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Vet vet) {
		super.delete(vet);
	}

}
