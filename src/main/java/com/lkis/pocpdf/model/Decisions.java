package com.lkis.pocpdf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Decisions {
    private String code;
    private String libelle;
    private Date dabebut;
    private Date dateFin;

}
