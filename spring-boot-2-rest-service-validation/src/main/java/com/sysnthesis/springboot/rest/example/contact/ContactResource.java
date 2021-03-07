package com.sysnthesis.springboot.rest.example.contact;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sysnthesis.springboot.rest.example.contact.model.Contact;
import com.sysnthesis.springboot.rest.example.contact.repository.ContactRepository;
import com.sysnthesis.springboot.rest.example.exception.ContactNotFoundException;


@RestController
public class ContactResource {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	@GetMapping("/contacts")
	public List<Contact> retrieveAllContacts() {
		return contactRepository.findAll();
	}

	@GetMapping("/contacts/{id}")
	public EntityModel<Contact> retrieveContact(@PathVariable long id) {
		Optional<Contact> contact = contactRepository.findById(id);

		if (!contact.isPresent())
			throw new ContactNotFoundException("id-" + id);
		

		EntityModel<Contact> resource = EntityModel.of(contact.get());

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllContacts());

		resource.add(linkTo.withRel("all-contacts"));

		return resource;
	}

	@DeleteMapping("/contacts/{id}")
	public void deleteContact(@PathVariable long id) {
		contactRepository.deleteById(id);
	}

	@PostMapping("/contacts")
	public ResponseEntity<Object> createContact(@Valid @RequestBody Contact contact) {
		
		Contact savedContact = contactRepository.save(contact);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedContact.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Object> updateContact(@Valid @RequestBody Contact contact, @PathVariable long id) {

		Optional<Contact> contactOptional = contactRepository.findById(id);

		if (!contactOptional.isPresent())
			return ResponseEntity.notFound().build();

		contact.setId(id);
		
		contactRepository.save(contact);

		return ResponseEntity.noContent().build();
	}
}
