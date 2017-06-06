package bg.test.bindModel;

import java.util.List;

/**
 *
 * @author Kalin
 */
public interface PersonService {

    void create(PersonBindModel person);

    void delete(long id);

    void update(long id);

    PersonViewModel findOneByName(String name);

    List<PersonViewModel> findAll();

}
