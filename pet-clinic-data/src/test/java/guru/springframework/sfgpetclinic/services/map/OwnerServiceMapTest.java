package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap; 
	
	final Long ownerId = 1L;
	final String ownerLastName = "Verma";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
	}

	@Test
	void testFindByLastNameExists() {
		Owner owner = ownerServiceMap.findByLastName(ownerLastName);
		assertEquals(ownerLastName, owner.getLastName());
	}

	@Test
	void testFindByLastNameNull() {
		Owner owner = ownerServiceMap.findByLastName("abc");
		assertNull(owner);
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testFindAll() {
		assertEquals(1L, ownerServiceMap.findAll().size());
	}

	@Test
	void testSaveOwnerExistingId() {
		Long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		Owner savedOwner = ownerServiceMap.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}
	
	@Test
	void testSaveOwnerNonExistingId() {
		Owner owner2 = Owner.builder().build();
		Owner savedOwner = ownerServiceMap.save(owner2);
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

}
