/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.matercero.ec.utils;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import es.matercero.ec.hibernate.Cliente;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author mtercero
 */
@Component("cartasPDF")
@Scope("session")
public class CartasPDF implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(CartasPDF.class);

    public static final String RESOURCE = "/resources/images/logo1.png";
    public static final String CHECK_OK = "/reports/img/ok.png";

    public static final Font FONTTIMES_ROMAN12BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
    public static final Font FONTTIMES_ROMAN9NORMAL = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

    /**
     * Path to the resulting PDF file.
     */
    /**
     * COLORES ROJO: e80000 ALVERO: d99900
     *
     */
    public void lanzar(List<Cliente> nombres) {

        Document document = new Document();

        try {
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, baos);

            MyFooter event = new MyFooter();
            writer.setPageEvent(event);

            // step 3
            document.open();
            document.addTitle("EL CORTIJO");
            document.setPageSize(PageSize.A4);

            for (Cliente cli : nombres) {

                ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                        .getExternalContext().getContext();
                Image img = Image.getInstance(ctx.getRealPath(RESOURCE));
                img.setAbsolutePosition(50f, 645f);
                img.scaleAbsolute(160f, 220f);
                document.add(img);

                PdfContentByte canvas = writer.getDirectContent();
                Rectangle rect = new Rectangle(10, 820, 30, 450);
                rect.setBorder(Rectangle.BOX);
                rect.setBackgroundColor(new BaseColor(217, 153, 0));
                rect.setBorderWidth(0);
                canvas.rectangle(rect);

                img.setAbsolutePosition(7f, 398f);
                img.scaleAbsolute(25f, 64f);
                document.add(img);

                rect = new Rectangle(10, 10, 30, 410);
                rect.setBorder(Rectangle.BOX);
                rect.setBackgroundColor(new BaseColor(232, 0, 0));
                rect.setBorderWidth(0);
                canvas.rectangle(rect);

                PdfPTable tabla = new PdfPTable(1);
                tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                tabla.addCell(" ");
                document.add(tabla);

                PdfPTable table = new PdfPTable(1);
                //table.setWidths(new int[]{100});
                table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                table.setSpacingBefore(120f);

                PdfPCell celda;

                Paragraph p = new Paragraph("El Presidente de la Asociación Cultural");
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPaddingTop(5.0f);
                celda.setPaddingBottom(5.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("CASETA EL CORTIJO");
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPaddingTop(5.0f);
                celda.setPaddingBottom(5.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("Al Sr. " + cli.getNombre());
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda.setPaddingTop(5.0f);
                celda.setPaddingBottom(5.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("Y se complace en invitarle al acto de inauguración de la Exposición Fotográfica que tendrá "
                        + "lugar el día 4 de Septiembre de 2018 a las 20 horas, en la sala de exposiciones Espacio Santa Clara de esta localidad, "
                        + "con motivo del  CINCUENTA ANIVERSARIO  de  nuestra caseta.");
                p.setLeading(10, 10);
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
                celda.setPaddingTop(25.0f);
                celda.setPaddingBottom(5.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("Sírvase esta invitación para acompañarnos en nuestra caseta durante la Feria 2018. ");
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda.setPaddingTop(30.0f);
                celda.setPaddingBottom(5.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("José Antonio Fernández Rubiales");
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPaddingTop(150.0f);
                celda.setPaddingBottom(5.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("Aprovecha     gustoso      esta     ocasión     para   reiterarle "
                        + "el  testimonio    de    su    consideración    más   distinguida.");
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda.setPaddingTop(15.0f);
                celda.setPaddingBottom(15.0f);
                celda.setBorder(0);
                table.addCell(celda);

                p = new Paragraph("Morón de la Frontera, 1 de Septiembre de 2018.");
                celda = new PdfPCell(p);
                celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda.setPaddingTop(15.0f);
                celda.setPaddingBottom(15.0f);
                celda.setBorder(0);
                table.addCell(celda);

                document.add(table);

                document.newPage();
            }

            //Closed
            document.close();

            byte[] bytearrayb = baos.toByteArray();

            downloadFile("carta.pdf", bytearrayb);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    /**
     *
     * @param filename
     * @param bytearrayb
     * @throws IOException
     */
    public void downloadFile(String filename, byte[] bytearrayb) throws IOException {
        File f = null;
        try {
            f = new File(filename);

            InputStream in = new ByteArrayInputStream(bytearrayb);
            FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
            int c = 0;
            while ((c = in.read()) >= 0) {
                out.write(c);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
        }

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext
                .getExternalContext().getResponse();
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + f.getName() + "\"");

        OutputStream responseOutputStream = response.getOutputStream();
        InputStream fis = new FileInputStream(f);
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = fis.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }
        responseOutputStream.flush();
        fis.close();
        responseOutputStream.close();
        facesContext.responseComplete();
    }

    class MyFooter extends PdfPageEventHelper {

        Font ffont = new Font(Font.FontFamily.UNDEFINED, 8, Font.NORMAL);
        String texto = "ASOCIACION CASETA EL CORTIJO. Carrera, 5 - 1ºC. 41530 Morón de la Frontera. casetaelcortijo@gmail.com";

        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase footer = new Phrase(texto, ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,
                    footer,
                    document.leftMargin(),
                    document.bottom() - 10, 0);
        }
    }

}
