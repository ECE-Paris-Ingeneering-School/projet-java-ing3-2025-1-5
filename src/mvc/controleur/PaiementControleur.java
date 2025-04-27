package mvc.controleur;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import dao.daoClient;
import dao.daoConnect;
import dao.daoReservation;
import dao.daoReservation;
import mvc.modele.Client;
import mvc.modele.Reservation;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import mvc.modele.Reservation;

import java.io.FileNotFoundException;

public class PaiementControleur {

    public static void main(String[] args) {
        //test pdf
        Reservation reservation = new Reservation(1, 1, 1, new java.util.Date(), new java.util.Date(), 100.0f, true, new java.util.Date(), 2, 2);
        String filePath = "reservation_" + reservation.getResaId() + ".pdf";
        PdfGenerator.generateReservationPdf(filePath, reservation);
    }
    public void effectuerPaiement(Reservation reservation) {
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationdao = new daoReservation(dao);
        reservationdao.ajouter(reservation);

        // Génération du PDF
        String filePath = "reservation_" + reservation.getResaId() + ".pdf";
        PdfGenerator.generateReservationPdf(filePath, reservation);
    }

    public class PdfGenerator {

        public static void generateReservationPdf(String filePath, Reservation reservation) {
            try {
                // Initialisation du PDF
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                // Titre
                document.add(new Paragraph("WhereBNB").setBold().setFontSize(26));
                document.add(new Paragraph("Vous faire sourire, notre désir").setBold().setFontSize(10));
                document.add(new Paragraph("Détails de la réservation").setBold().setFontSize(18));

                //get client details
                daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
                daoClient clientDAO = new daoClient(dao);
                Client client = clientDAO.getClientById(reservation.getClientId());
                document.add(new Paragraph("Client : " + client.getNom() + " " ).setFontSize(14));

                // Tableau des détails
                Table table = new Table(2);
                table.addCell("Arrivée :");
                table.addCell(reservation.getDateDebut().toString());
                table.addCell("Départ :");
                table.addCell(reservation.getDateFin().toString());
                table.addCell("Durée du séjour :");
                Float dureeSejourFloat = (float) (reservation.getDateFin().getTime() - reservation.getDateDebut().getTime()) / (1000 * 60 * 60 * 24);
                table.addCell(String.valueOf(dureeSejourFloat) + " jours");
                table.addCell("Nombre de personnes :");
                table.addCell(String.valueOf(reservation.getNbAdultes() + reservation.getNbEnfants()));
                table.addCell("Nombre de chambres :");
                Float totalChambres = (float) reservation.getNbAdultes() / 2 + (reservation.getNbEnfants() / 2) + 1;
                table.addCell(String.valueOf(totalChambres));
                table.addCell("Prix total :");
                table.addCell(reservation.getPrixTotal() + " €");

                // Ajout du tableau au document
                document.add(table);

                // Fermeture du document
                document.close();
                System.out.println("PDF généré avec succès : " + filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}