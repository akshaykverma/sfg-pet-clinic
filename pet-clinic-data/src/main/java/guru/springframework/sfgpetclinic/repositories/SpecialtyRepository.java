package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Vet;

public interface SpecialtyRepository extends CrudRepository<Vet, Long> {

}
