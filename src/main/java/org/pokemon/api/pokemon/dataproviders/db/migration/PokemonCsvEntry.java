package org.pokemon.api.pokemon.dataproviders.db.migration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public record PokemonCsvEntry(
        @JsonProperty("#")
        Long id,
        String name,
        String type1,
        String type2,
        Integer total,
        Integer hp,
        Integer attack,
        Integer defense,
        Integer specialAttack,
        Integer specialDefense,
        Integer speed,
        Integer generation,
        Boolean legendary
) {


    public static List<PokemonCsvEntry> fromCSV(Reader reader) throws IOException {
        CsvMapper mapper = new CsvMapper();

        MappingIterator<PokemonCsvEntry> usersIter = mapper
                .readerFor(PokemonCsvEntry.class)
                .with(mapper.schemaWithHeader())
                .readValues(reader);

        return usersIter.readAll();
    }
}
