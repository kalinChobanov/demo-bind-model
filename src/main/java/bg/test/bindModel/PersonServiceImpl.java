/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.test.bindModel;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(PersonBindModel person) {
        Person currentPerson = this.modelMapper.map(person, Person.class);
        this.personRepository.saveAndFlush(currentPerson);
    }

    @Override
    public void delete(long id) {
        this.personRepository.delete(id);
    }

    @Override
    public void update(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonViewModel findOneByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonViewModel> findAll() {
        List<Person> persons = this.personRepository.findAll();
        List<PersonViewModel> result = new ArrayList();
        persons.forEach(p -> {
            PersonViewModel currentPerson = this.modelMapper.map(p, PersonViewModel.class);
            result.add(currentPerson);
        });
        return result.size() > 0 ? result : null;
    }

}
