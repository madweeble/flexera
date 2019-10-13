package com.kevinbradley.web.service;

import com.kevinbradley.business.service.PersonService;
import com.kevinbradley.data.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/app/people")
public class PersonServiceController {

    @Autowired
    private PersonService personService;

    /**
     * Handle the request for returning all {@link PersonEntity}s
     *
     * @return all PersonEntity records in the data store
     */
    @GetMapping(produces = "application/json")
    public List<PersonEntity> getPeople(@RequestParam(value = "sortBy", required = false)String sortBy) {
        return this.personService.getPeople(sortBy);
    }

    /**
     * Handle the request for returning the specified {@link PersonEntity}
     *
     * @param name the person we want to get information for
     * @return all fields for the specified name
     */
    @GetMapping(value = "/{name}", produces = "application/json")
    public List<PersonEntity> getPersonByName(@PathVariable(value = "name")String name) {
        return this.personService.getPeopleByName(name);
    }

    /**
     * Handle the request to add a new {@link PersonEntity}
     *
     * @param personEntity the person to add in json format
     * @return the data for this person, provided the object was successfully persisted to the data store
     */
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public List<PersonEntity> addPerson(@RequestBody PersonEntity personEntity) {
        return this.personService.addPerson(personEntity);
    }

    /**
     * Handle the request to delete the specified {@link PersonEntity}
     *
     * @param name the person to delete from the data store
     * @return the number of people deleted by this operation
     */
    @Transactional
    @DeleteMapping(value = "/delete/{name}")
    public long deletePerson(@PathVariable(value = "name")String name) {
        return this.personService.deletePerson(name);
    }
}
