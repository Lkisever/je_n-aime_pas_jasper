package com.lkis.pocpdf.model;

import lombok.Data;

import java.util.List;

@Data
public class FicheJeune {
    private Mineur mineur;
    private Adresse adresse;
    private List<Decisions> decisionsList;
    private Parent pere;
    private Parent mere;
    private Scolarite scolarite ;
}
