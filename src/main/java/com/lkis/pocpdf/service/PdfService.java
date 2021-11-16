package com.lkis.pocpdf.service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.openhtmltopdf.svgsupport.BatikSVGDrawer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfService {

    private static final String PDF_RESOURCES = "/static/";
    private SpringTemplateEngine templateEngine;

    @Autowired
    public PdfService(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public File generatePdf(String namePdf, String template, String variableContext, Object objectContext) throws IOException {
        Context context = getContext(variableContext, objectContext);
        String html = loadAndFillTemplate(template, context);
        return renderPdf(html, namePdf);
    }

    private Context getContext(String variableContext, Object objectContext) {
        Context context = new Context();
        context.setVariable(variableContext, objectContext);
        return context;
    }

    private String loadAndFillTemplate(String template, Context context) {
        return templateEngine.process(template, context);
    }

    private File renderPdf(String html, String namePdf) throws IOException {
        File file = File.createTempFile(namePdf, ".pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        builder.useFastMode();
        builder.toStream(outputStream);
        builder.useSVGDrawer(new BatikSVGDrawer());
        builder.run();

        outputStream.close();
        file.deleteOnExit();

        return file;
    }

    private File encrypt(File pdf) throws IOException {
        PDDocument doc = PDDocument.load(pdf);
        AccessPermission ap = new AccessPermission();
        ap.setCanPrint(false);
        ap.setCanPrintDegraded(false);
        ap.setCanExtractContent(false);
        ap.setCanExtractForAccessibility(false);
        ap.setCanFillInForm(false);
        ap.setCanModifyAnnotations(false);
        ap.setCanModify(false);
        ap.setReadOnly();
        StandardProtectionPolicy spp = new StandardProtectionPolicy("admin", "password", ap);
        spp.setEncryptionKeyLength(128);
        spp.setPreferAES(true);
        doc.protect(spp);
        doc.save(pdf);
        return pdf;
    }


    public File generatePdfEncrypt(String namePdf, String template, String variableContext, Object objectContext) throws IOException {
        Context context = getContext(variableContext, objectContext);
        String html = loadAndFillTemplate(template, context);
        return encrypt(renderPdf(html, namePdf));
    }
}
