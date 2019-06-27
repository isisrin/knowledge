package isisrin.jpa.setup.repository;

import isisrin.jpa.setup.domain.Pokemon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @DataJpaTest 하면 기본적으로 rollback인데 rollback하고 싶지 않으면 @Rollback(false)를 넣자
 * 의존성에 H2 DB를 넣었으면 Test는 H2에서 동작함
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomPokemonRepositoryTest {

    @Autowired
    CustomPokemonRepository customPokemonRepository;

    @Test
    public void save() {
        // given
        Pokemon pokemon = new Pokemon();
        pokemon.setName("피카츄");
        customPokemonRepository.save(pokemon);

        // when
        List<Pokemon> result = customPokemonRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(1);
    }
}