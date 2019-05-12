package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

	public Owner findById(Long id) {
		return super.findById(id);
	}

	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public void save(Owner object) {
		super.save(object.getId(), object);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Owner owner) {
		super.delete(owner);
	}

}
