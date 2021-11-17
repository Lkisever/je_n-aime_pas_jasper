package com.lkis.pocpdf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Scolarite {
    private boolean cm1;
    private boolean cm2;
    private boolean sixieme;
    private boolean cinquieme;
    private boolean quatrieme;
    private boolean troisieme;
    private boolean seconde;
    private boolean premiere;
    private boolean terminale;
}
