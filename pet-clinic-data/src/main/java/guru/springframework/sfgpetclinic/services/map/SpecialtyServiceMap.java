package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	public Specialty findById(Long id) {
		return super.findById(id);
	}

	public Set<Specialty> findAll() {
		return super.findAll();
	}
	
	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Specialty specialty) {
		super.delete(specialty);
	}

}
