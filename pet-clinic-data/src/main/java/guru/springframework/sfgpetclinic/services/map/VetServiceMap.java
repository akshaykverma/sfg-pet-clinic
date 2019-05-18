package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	private final SpecialtyService specialtyService;
	
	public VetServiceMap(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	public Vet findById(Long id) {
		return super.findById(id);
	}

	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Vet save(Vet object) {
		
		if(object != null) {

			if(object.getSpecialties().size() > 0) {
				object.getSpecialties().forEach(specialty -> {
					
					if(specialty.getId() == null) {
						specialty.setId(specialtyService.save(specialty).getId());
					}
				});
			}
			
			return super.save(object);			
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Vet vet) {
		super.delete(vet);
	}

}
