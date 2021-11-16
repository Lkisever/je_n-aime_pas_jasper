package com.lkis.pocpdf.controller;

import com.lkis.pocpdf.MineurHelper;
import com.lkis.pocpdf.model.FicheJeune;
import com.lkis.pocpdf.service.PdfService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class PdfController {

    private final PdfService pdfService;

    @Autowired
    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @RequestMapping(value = "/fichejeune", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getFicheJeune() throws IOException {

        FicheJeune ficheJeune = MineurHelper.getFicheJeune();
        File result = pdfService.generatePdf("fichejeune", "fiche", "ficheEntry", ficheJeune);
        ByteArrayInputStream in = new ByteArrayInputStream(FileUtils.readFileToByteArray(result));

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=fiche_jeune_"+ficheJeune.getMineur().getPrenom()+"-"+ficheJeune.getMineur().getNom()+".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(in));

    }

    @RequestMapping(value = "/fichejeune_encrypt", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getFicheJeuneEncrypt() throws IOException {

        FicheJeune ficheJeune = MineurHelper.getFicheJeune();
        File result = pdfService.generatePdfEncrypt("fichejeune", "fiche", "ficheEntry", ficheJeune);
        ByteArrayInputStream in = new ByteArrayInputStream(FileUtils.readFileToByteArray(result));

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=fiche_jeune-encrypt_"+ficheJeune.getMineur().getPrenom()+"-"+ficheJeune.getMineur().getNom()+".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(in));

    }

}
