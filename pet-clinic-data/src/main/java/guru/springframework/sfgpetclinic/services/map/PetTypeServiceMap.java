package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService{

	public PetType findById(Long id) {
		return super.findById(id);
	}

	public Set<PetType> findAll() {
		return super.findAll();
	}
	
	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(PetType petType) {
		super.delete(petType);
	}

}
