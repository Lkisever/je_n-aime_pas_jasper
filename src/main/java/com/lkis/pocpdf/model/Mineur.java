package com.lkis.pocpdf.model;

import lombok.Data;

import java.util.Date;

@Data
public class Mineur {
    private String nom;
    private String prenom;
    private String sexe;
    private Date dateNaissance;
    private Boolean scolarise;
}
