package org.pokemon.api.pokemon.dataproviders.db.migration;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonCsvEntryTest {

    @Test
    void should_get_pokemons_from_csv() throws IOException {
        // Arrange
        Reader reader = new FileReader("src/main/resources/db/migration/Pokemon.csv");

        // Act
        final var pokemonCsvEntries = PokemonCsvEntry.fromCSV(reader);

        // Assert
        assertThat(pokemonCsvEntries).hasSize(800);
    }

}