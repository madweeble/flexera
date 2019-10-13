package com.kevinbradley.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinbradley.data.entity.PersonEntity;
import com.kevinbradley.data.repository.PersonRepository;

import java.util.Comparator;
import java.util.List;

/**
 * The Spring service component for returning {@link PersonEntity} information
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    /**
     * Constructor to inject the {@link PersonRepository}
     *
     * @param personRepository the repository interface
     */
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Return a sorted list of {@link PersonEntity} objects
     *
     * @param sortBy a list of people sorted by this field
     * @return a sorted list of people
     */
    public List<PersonEntity> getPeople(final String sortBy) {
        List<PersonEntity> people = this.personRepository.findAll();
        sortRecords(sortBy, people);
        return people;
    }

    /**
     * Return a {@link PersonEntity} that matches the given name
     *
     * @param name the person we wish to find
     * @return all the fields that exist for this person
     */
    public List<PersonEntity> getPeopleByName(final String name) {
        return this.personRepository.findByNameIgnoreCase(name);
    }

    /**
     * Create a new {@link PersonEntity} and persist the object to the
     * data store, returning the person if they were successfully added.
     * If the person already exists, do not add a duplicate, but return
     * the existing entry
     *
     * @param person the new person to add
     * @return the new person in the data store
     */
    public List<PersonEntity> addPerson(PersonEntity person) {
        List<PersonEntity> people = personRepository.findByNameIgnoreCase(person.getName());
        boolean matchFound = people.stream().anyMatch( p -> p.toString().equalsIgnoreCase(person.toString()));
        if (!matchFound) {
            this.personRepository.save(person);
        }
        return this.getPeopleByName(person.getName());
    }

    /**
     * Remove this person from the data store
     *
     * @param name the unique name of the person to delete
     * @return the number of people deleted by this operation
     */
    public long deletePerson(final String name) {
        return this.personRepository.deleteByNameIgnoreCase(name);
    }

    // ===========================================================
    // ===========================================================

    /**
     * Sort the list of people if a sort parameter is specified
     *
     * @param sortBy the sort field
     * @param people a {@link PersonEntity} list
     */
    private void sortRecords(final String sortBy, List<PersonEntity> people) {
        if (sortBy != null && sortBy.length() > 0) {
            Comparator comparator = null;
            if (sortBy.equalsIgnoreCase("name")) {
                comparator = Comparator.comparing(PersonEntity::getName);
            } else if (sortBy.equalsIgnoreCase("email")) {
                comparator = Comparator.comparing(PersonEntity::getEmail);
            }
            if (comparator != null) {
                people.sort(comparator);
            }
        }
    }
}
