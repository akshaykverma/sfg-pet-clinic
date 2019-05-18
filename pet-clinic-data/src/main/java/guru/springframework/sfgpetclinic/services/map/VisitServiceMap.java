package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService{

	public Visit findById(Long id) {
		return super.findById(id);
	}

	public Set<Visit> findAll() {
		return super.findAll();
	}
	
	@Override
	public Visit save(Visit visit) {
		if (visit == null || visit.getPet() == null || visit.getPet().getOwner() == null
				|| visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {

			throw new RuntimeException("Invalid Visit");
		}
		return super.save(visit);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public void delete(Visit visit) {
		super.delete(visit);
	}

}
