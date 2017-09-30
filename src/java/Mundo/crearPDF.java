/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import Dao.*;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.*;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.io.*;

/**
 *
 * @author brialxsfxubun
 */
public class crearPDF extends Thread {

    private String id_pdf;
    
    private Document document;
    public crearPDF() {
    }

    public crearPDF(String id, String tipo, Document document) {

        this.id_pdf = id;
        this.document=document;
    }

    public  void crearInformePDF(String id, String rutaImg, String rutaSave, Document document,PdfWriter fd) {
        
        try {
            
                                
           HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);

            htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

            CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(false);

            //cssResolver.addCss("hr { background-color: green; height: 5px; width: 80%; }", true);

            Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, new HtmlPipeline(htmlContext, new PdfWriterPipeline(document,fd )));

            XMLWorker worker = new XMLWorker(pipeline, true);
            XMLParser xmlParser = new XMLParser(worker);

            document.open();
            
           
            Image logo = Image.getInstance(rutaImg +"/images/" +"sistemas.png");
             
            
            
            document.add(logo);

            String html = "<html>\n";
            String body = "<body>\n";
            String header = "";
            body += header + "</body>";
            html += body + "</html>\n\n";
            xmlParser.parse(new StringReader(html));
            
       
            String titulo = "REPORTE GENERAL";
            tableTitle(document, titulo);
            document.add(new Paragraph(" "));
            titulo= "La Proyección Social, es entendida como la acción educativa orientada hacia la comunidad con "
                    + "el fin fundamental de desarrollar en los docentes y estudiantes del programa de Ingeniería"
                    + " de Sistemas, sentimientos de solidaridad y responsabilidad social para con la comunidad"
                    + " que se manifiesta a través de proyectos de interacción y servicio que pretenden mejorar "
                    + "la calidad de la enseñanza y la calidad de vida, confrontando la teoría de la práctica "
                    + "en un campo real de aplicación, siempre tratando de beneficiar a las comunidades. \n"
                    + "En el documento se podra vizualisar las Organizaciones(Convenios, proyectos, Actividades) con las que el Programa de Ingenieria"
                    + "de Sistemas tiene convenios para realizar proyectos y actividades el cual cumplan con el proposito "
                    + "de la proyeccion social ";
            tableTitle2(document, titulo);
            document.add(new Paragraph(" "));
            titulo= "ORGANIZACIONES";
            tableTitle(document, titulo);
            document.add(new Paragraph(" "));
            tableCuerpo(document, id, rutaImg);
            document.add(new Paragraph(" "));
            titulo= "CONVENIOS";
            tableTitle(document, titulo);
            document.add(new Paragraph(" "));
            tableCuerpo2(document, id, rutaImg);
            document.add(new Paragraph(" "));
            titulo= "PROYECTOS";
            tableTitle(document, titulo);
            document.add(new Paragraph(" "));
            tableCuerpo3(document, id, rutaImg);
            document.add(new Paragraph(" "));

            xmlParser.parse(new StringReader(html));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
   
    private void tableTitle2(Document document, String a) {
        try {
            PdfPTable title = new PdfPTable(1);
            PdfPCell title1;
            Paragraph p;
            Font font = new Font();
            
            font.setSize(12);
            font.setColor(0,0,0);

            
                title1 = new PdfPCell(new Paragraph(a, font));
                title1.setBorder(0);   
                         
            title1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            title.addCell(title1);
            document.add(title);
            
            
            return;
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }
    
    private void tableTitle(Document document, String a) {
        try {
            PdfPTable title = new PdfPTable(1);
            PdfPCell title1;
            Paragraph p;
            Font font = new Font();
            font.setStyle(1);
            font.setSize(18);
            font.setColor(64,64,64);

            
                title1 = new PdfPCell(new Paragraph(a, font));
                title1.setBorder(0);   
                         
            title1.setHorizontalAlignment(Element.ALIGN_CENTER);
            title.addCell(title1);
            document.add(title);
            
            
            return;
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private void tableTitle3(Document document, String a) {
        try {
            PdfPTable title = new PdfPTable(1);
            PdfPCell title1;
            Paragraph p;
            Font font = new Font();
            font.setStyle(1);
            font.setSize(16);
            font.setColor(64,64,64);

            
                title1 = new PdfPCell(new Paragraph(a, font));
                title1.setBorder(0);   
                         
            title1.setHorizontalAlignment(Element.ALIGN_LEFT);
            title.addCell(title1);
            document.add(title);
            
            
            return;
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }
    
    public void correr(Document d, String ruta, PdfWriter fd) {
        
        //String path = System.getProperty("user.dir"), pathSave = "";
        String split = System.getProperty("file.separator");
        
        //String pathImg = path + split + "web" + split + "images" + split;
        //pathSave += path + split + "web" + split + "reportes" + split;

        crearInformePDF(getId_pdf(),  ruta, ruta,d,  fd);
    }

    private void tableCuerpo(Document document, String id,  String rutaImg) {
        
        Consultas z = new Consultas ();
        
        try {
            document.add(new Paragraph("")); 
            PdfPTable title = new PdfPTable(4);
            Paragraph p;
            PdfPCell c;
            
            Font font = new Font();
            font.setStyle(2);
            font.setSize(12);
            float tamaños []={0.5f,2,2,4.5f};
            title.setWidths(tamaños);
            
            String fundacion[][]=z.todasLasFundaciones();
       
               
                p = new Paragraph("ID", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph( "NOMBRE", font);
                c = new PdfPCell(p);
                title.addCell(c).setBackgroundColor(BaseColor.LIGHT_GRAY);
                title.setHorizontalAlignment(Element.ALIGN_CENTER);
                p = new Paragraph("TELEFONO", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph("CORREO", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
              
            
            for (int i = 0; i < fundacion.length; i++) {

                String [] t = z.retornarFundacion(fundacion[i][0]);
                
                p = new Paragraph(fundacion[i][0]);
                title.addCell(new PdfPCell(p));
                p = new Paragraph( fundacion[i][1]);
                c = new PdfPCell(p);
                title.addCell(c);
                p = new Paragraph(t[3]);
                title.addCell(new PdfPCell(p));
                p = new Paragraph(t[5]);
                title.addCell(new PdfPCell(p));
            
          }
          title.setHorizontalAlignment(Element.ALIGN_CENTER);
          document.add(title);

           
            

            return;
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private void tableCuerpo2(Document document, String id,  String rutaImg) {
        
        Consultas z = new Consultas ();
        
        try {
            document.add(new Paragraph("")); 
            PdfPTable title = new PdfPTable(5);
            Paragraph p;
            PdfPCell c;
            
            Font font = new Font();
            font.setStyle(2);
            font.setSize(10);
            float tamaños []={1,3,2,2,6};
            title.setWidths(tamaños);
            
            String convenio[][]=z.todasLosConvenio();
               
                p = new Paragraph("ID", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph( "NOMBRE", font);
                c = new PdfPCell(p);
                title.addCell(c).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph("FECHA INICIO", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph("FECHA FIN", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph("DESCRIPCION", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                
                for (int i = 0; i < convenio.length; i++) {

                String [] t = z.retornarConvenio(convenio[i][0]);
                p = new Paragraph(convenio[i][0],font);
                title.addCell(new PdfPCell(p));
                p = new Paragraph( convenio[i][1],font);
                c = new PdfPCell(p);
                title.addCell(c);
                p = new Paragraph(t[2],font);
                title.addCell(new PdfPCell(p));
                p = new Paragraph(t[3],font);
                title.addCell(new PdfPCell(p));
                p = new Paragraph(t[7],font);
                title.addCell(new PdfPCell(p));
            
          }
              
            
          
          title.setHorizontalAlignment(Element.ALIGN_CENTER);
          document.add(title);

           
            

            return;
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private void tableCuerpo3(Document document, String id,  String rutaImg) {
        
        Consultas z = new Consultas ();
        
        try {
                       
            String proyecto[][]=z.TodosLosProyectos();
               
            int j =0;
            String h="";
            for (int i = 0; i < proyecto.length; i++) {

            String d[]=z.retornarProyecto(proyecto[i][0]);
            String titulo = proyecto[i][1] ;
            j=i+1;
            tableTitle3(document, j+"."+titulo);
            document.add(new Paragraph(" "));
            titulo= d[8]+" La fecha de inicio es "+d[1]+" y termina "+d[2]+" Sera realizado en la organizacion "
                    +d[4]+" para las cuales se programaron las siguientes actividades:";
            tableTitle2(document, titulo);
            document.add(new Paragraph(" "));
             
             
            PdfPTable title = new PdfPTable(3);
            Paragraph p;
            PdfPCell c;
            
            Font font = new Font();
            font.setStyle(2);
            font.setSize(10);
            float tamaños []={3,3,5};
            title.setWidths(tamaños);
            
            String Act[][]=z.CargarActividadPRoyecto(proyecto[i][0]);
               
                
                p = new Paragraph( "NOMBRE", font);
                c = new PdfPCell(p);
                title.addCell(c).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph("COORDINADOR", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                p = new Paragraph("DESCRIPCION", font);
                title.addCell(new PdfPCell(p)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                
                for (int w = 0; w < Act.length; w++) {

                String [] t = z.retornarActividad(Integer.parseInt(Act[w][0]));
               
                p = new Paragraph( Act[w][1],font);
                c = new PdfPCell(p);
                title.addCell(c);
                p = new Paragraph(t[11],font);
                title.addCell(new PdfPCell(p));
                p = new Paragraph(t[8],font);
                title.addCell(new PdfPCell(p));

            
          }
              
            
           
          title.setHorizontalAlignment(Element.ALIGN_CENTER);
          document.add(title);
          document.add(new Paragraph(" "));
            
          }
              
                
          
             
            

            return;
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }


    
    private void agregarChart(boolean x, String rutaImg, Document document) {

        try {
            if (x) {
                Image chart = Image.getInstance(rutaImg + "pieChart3D.jpeg");
                document.add(chart);

            } else {
                Font f = new Font();
                f.setSize(15);
                f.setStyle(1);

                Paragraph p = new Paragraph("NO SE ENCONTRARON REGISTROS", f);
                p.setAlignment(1);
                document.add(p);
            }
        } catch (BadElementException ex) {
        } catch (IOException | DocumentException ex) {
            ex.printStackTrace();
        }

    }

    public String getId_pdf() {
        return id_pdf;
    }

    public void setId_pdf(String id_pdf) {
       
        this.id_pdf = id_pdf;
    }


}
