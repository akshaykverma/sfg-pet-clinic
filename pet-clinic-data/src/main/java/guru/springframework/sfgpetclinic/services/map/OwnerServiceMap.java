package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

@Service
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
	public Owner save(Owner object) {
		return super.save(object);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Owner owner) {
		super.delete(owner);
	}

}
