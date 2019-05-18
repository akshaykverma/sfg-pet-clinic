package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

	public Pet findById(Long id) {
		return super.findById(id);
	}

	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Pet pet) {
		super.delete(pet);
	}

}
