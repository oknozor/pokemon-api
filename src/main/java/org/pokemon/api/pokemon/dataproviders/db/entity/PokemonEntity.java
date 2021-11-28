package org.pokemon.api.pokemon.dataproviders.db.entity;

import org.pokemon.api.pokemon.dataproviders.db.migration.PokemonCsvEntry;

public class PokemonEntity {
    public Long id;
    public String name;
    public String type1;
    public String type2;
    public Integer total;
    public Integer hp;
    public Integer attack;
    public Integer defense;
    public Integer specialAttack;
    public Integer specialDefense;
    public Integer speed;
    public Integer generation;
    public Boolean legendary;
}
