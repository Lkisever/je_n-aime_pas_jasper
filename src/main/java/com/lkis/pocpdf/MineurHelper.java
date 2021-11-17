package com.lkis.pocpdf;

import com.lkis.pocpdf.model.Adresse;
import com.lkis.pocpdf.model.Decisions;
import com.lkis.pocpdf.model.FicheJeune;
import com.lkis.pocpdf.model.Mineur;
import com.lkis.pocpdf.model.Parent;
import com.lkis.pocpdf.model.Scolarite;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class MineurHelper {

    public static FicheJeune getFicheJeune() {

        Mineur mineur = new Mineur();
        mineur.setNom("SMITH");
        mineur.setPrenom("Morty");
        mineur.setSexe("M");
        mineur.setDateNaissance(new GregorianCalendar(2005, 03, 27).getTime());
        mineur.setScolarise(true);

        Adresse adresse = new Adresse();
        adresse.setCodePostal("75019");
        adresse.setPays("FRANCE");
        adresse.setRue("7 rue de la Gare");
        adresse.setVille("AUBERVILLIERS");

        List<Decisions> decisionsList = new ArrayList<>();
        Decisions decision1 = new Decisions("MJIE", "Investigation", new GregorianCalendar(2010, 3, 27).getTime(), new GregorianCalendar(2010, 4, 27).getTime());
        decisionsList.add(decision1);
        Decisions decision2 = new Decisions("MJIE", "Investigation", new GregorianCalendar(2010, 4, 27).getTime(), new GregorianCalendar(2010, 4, 27).getTime());
        decisionsList.add(decision2);
        Decisions decision3 = new Decisions("CJ", "Placement sous contrôle judiciaire", new GregorianCalendar(2010, 4, 29).getTime(), new GregorianCalendar(2010, 6, 17).getTime());
        decisionsList.add(decision3);
        Decisions decision4 = new Decisions("CURDX", "Injonction thérapeutique", new GregorianCalendar(2012, 4, 3).getTime(), new GregorianCalendar(2012, 5, 2).getTime());
        decisionsList.add(decision4);
        Decisions decision5 = new Decisions("DEPC", "Débouté de la partie civile", new GregorianCalendar(2012, 8, 1).getTime(), new GregorianCalendar(2012, 9, 21).getTime());
        decisionsList.add(decision5);
        Decisions decision6 = new Decisions("DISPNE", "Dispense de peine", new GregorianCalendar(2012, 3, 1).getTime(), new GregorianCalendar(2012, 9, 30).getTime());
        decisionsList.add(decision6);
        Decisions decision7 = new Decisions("DOMINT", "Dommages et intérêts", new GregorianCalendar(2012, 3, 8).getTime(), new GregorianCalendar(2012, 4, 11).getTime());
        decisionsList.add(decision7);
        Decisions decision8 = new Decisions("ED", "Investigation", new GregorianCalendar(2012, 1, 10).getTime(), new GregorianCalendar(2012, 1, 10).getTime());
        decisionsList.add(decision8);
        Decisions decision9 = new Decisions("ESR", "Emprisonnement délictuel", new GregorianCalendar(2015, 2, 10).getTime(), new GregorianCalendar(2015, 2, 5).getTime());
        decisionsList.add(decision9);
        Decisions decision10 = new Decisions("MJIE", "Enquête sociale rapide", new GregorianCalendar(2015, 3, 10).getTime(), new GregorianCalendar(2015, 8, 27).getTime());
        decisionsList.add(decision10);
        Decisions decision11 = new Decisions("EXAMCHO", "Se soumettre à un examen psychologique", new GregorianCalendar(2015, 3, 7).getTime(), new GregorianCalendar(2015, 12, 8).getTime());
        decisionsList.add(decision11);
        Decisions decision12 = new Decisions("EXAMED", "Se soumettre à un examen médical", new GregorianCalendar(2015, 3, 4).getTime(), new GregorianCalendar(2015, 11, 12).getTime());
        decisionsList.add(decision12);
        Decisions decision13 = new Decisions("EXEPART", "Exécution partielle", new GregorianCalendar(2015, 4, 8).getTime(), new GregorianCalendar(2015, 04, 5).getTime());
        decisionsList.add(decision13);
        Decisions decision14 = new Decisions("ICVQUEL", "S'abstenir de conduire tout véhicule", new GregorianCalendar(2016, 1, 8).getTime(), new GregorianCalendar(2016, 12, 17).getTime());
        decisionsList.add(decision14);
        Decisions decision15 = new Decisions("INJSOIN", "Injonction de soins", new GregorianCalendar(2016, 2, 20).getTime(), new GregorianCalendar(2016, 3, 5).getTime());
        decisionsList.add(decision15);
        Decisions decision16 = new Decisions("IPARM", "Interdiction de porter une arme", new GregorianCalendar(2019, 2, 4).getTime(), new GregorianCalendar(2019, 3, 20).getTime());
        decisionsList.add(decision16);
        Decisions decision17 = new Decisions("LIBSP", "Liberté surveillée préjudicielle", new GregorianCalendar(2019, 10, 1).getTime(), new GregorianCalendar(2019, 11, 10).getTime());
        decisionsList.add(decision17);
        Decisions decision18 = new Decisions("MEDIAVI", "Médiation entre le mineur et la victime", new GregorianCalendar(2019, 10, 20).getTime(), new GregorianCalendar(2019, 10, 9).getTime());
        decisionsList.add(decision18);
        Decisions decision19 = new Decisions("PLACC", "Placement dans un centre d'accueil", new GregorianCalendar(2019, 11, 2).getTime(), new GregorianCalendar(2019, 12, 9).getTime());
        decisionsList.add(decision19);
        Decisions decision20 = new Decisions("PLACEXT", "Placement à l'extérieur", new GregorianCalendar(2019, 12, 12).getTime(), new GregorianCalendar(2019, 12, 1).getTime());
        decisionsList.add(decision20);
        Decisions decision21 = new Decisions("PLAP", "Placement chez l'autre parent", new GregorianCalendar(2021, 1, 4).getTime(), new GregorianCalendar(2022, 2, 2).getTime());
        decisionsList.add(decision21);

        Parent pere = new Parent();
        pere.setAdresse(adresse);
        pere.setPrenom("Jerry");
        pere.setNom("SMITH");

        Parent mere = new Parent();
        mere.setAdresse(adresse);
        mere.setPrenom("Beth");
        mere.setNom("SMITH");

        Scolarite scolarite = new Scolarite(true, true,true,true,true,true,true,false,false) ;

        FicheJeune ficheJeune = new FicheJeune();
        ficheJeune.setAdresse(adresse);
        ficheJeune.setMineur(mineur);
        ficheJeune.setDecisionsList(decisionsList);
        ficheJeune.setMere(mere);
        ficheJeune.setPere(pere);
        ficheJeune.setScolarite(scolarite);

        return ficheJeune;
    }
}
