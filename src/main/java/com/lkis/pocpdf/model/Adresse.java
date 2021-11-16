package com.lkis.pocpdf.model;

import lombok.Data;

@Data
public class Adresse {
    private String rue;
    private String ville;
    private String pays;
    private String codePostal;
}
