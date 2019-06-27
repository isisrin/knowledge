package isisrin.jpa.setup.repository;

import isisrin.jpa.setup.domain.Pokemon;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * @RepositoryDefinition : 나만의 Repository interface 를 만들 수 있게 해줌.
 */
@RepositoryDefinition(domainClass = Pokemon.class, idClass = Long.class)
public interface CustomPokemonRepository {
    Pokemon save(Pokemon pokemon);
    List<Pokemon> findAll();
}
