package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtySevice;
	private final VisitService visitService;

	//@Autowired can be ignored as form Spring 4.2 its automatically constructor autowired  
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtySevice, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtySevice = specialtySevice;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();

		if(count == 0) {
			loadData();			
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("radiology");
        Specialty savedRadiology = specialtySevice.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtySevice.save(surgery);
        
        Specialty dendistry = new Specialty();
        surgery.setDescription("dendistry");
        Specialty savedDendistry = specialtySevice.save(dendistry);

		Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Adr1");
        owner1.setCity("city1");
        owner1.setTelephone("1233434522");   
        
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Adr2");
        owner2.setCity("city2");
        owner2.setTelephone("12888434522");

        Pet FionasPet = new Pet();
        FionasPet.setPetType(savedCatPetType);
        FionasPet.setOwner(owner2);
        FionasPet.setBirthDate(LocalDate.now());
        FionasPet.setName("Just Cat");
        owner2.getPets().add(FionasPet);
        
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(FionasPet);
        catVisit.setDescription("Sneezy Kitty");
        catVisit.setDate(LocalDate.now());
        
        visitService.save(catVisit);
        
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
	}

}
