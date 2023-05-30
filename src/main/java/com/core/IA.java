package com.core;

import java.util.ArrayList;
import java.util.List;

public class IA extends AbstractJoueur{
    public IA() {
        super("IA");
    }

    @Override
    public List<Carte> choisirCartesAJouer(Plateau plateau){
        List<Carte> cartesAJouer = new ArrayList<>();

        //L'ia choisi une carte au hasard
    }

}
