package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	private final PetService petService;
	private final PetTypeService petTypeService;
	
	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll() 
				 .stream() 
				 .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				 .findFirst()
				 .orElse(null);
	}

	public Owner findById(Long id) {
		return super.findById(id);
	}

	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public Owner save(Owner object) {
		
		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					
					if (pet.getPetType() != null) {
						
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required");
					}
					if (pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
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
	
	public void delete(Owner owner) {
		super.delete(owner);
	}

}
