package org.pokemon.api.pokemon.dataproviders.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;

public class V2__PokemonData extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        URL resource = getClass().getClassLoader().getResource("db/migration/Pokemon.csv");
        assert resource != null;
        Reader reader = new FileReader(resource.getFile());

        var pokemons = PokemonCsvEntry.fromCSV(reader);

        pokemons.forEach(pokemon -> {
            try (Statement insert = context.getConnection().createStatement()) {

                insert.executeQuery("INSERT INTO pokemon VALUES (" +
                        pokemon.id() + " " +
                        pokemon.name() + " " +
                        pokemon.type1() + " " +
                        pokemon.type2() + " " +
                        pokemon.total() + " " +
                        pokemon.hp() + " " +
                        pokemon.attack() + " " +
                        pokemon.defense() + " " +
                        pokemon.specialAttack() + " " +
                        pokemon.specialDefense() + " " +
                        pokemon.speed() + " " +
                        pokemon.generation() + " " +
                        pokemon.legendary() + ")"
                );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
