/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Αναπαριστά μία πώληση προϊόντος του καταστήματος.
 *
 * Η κλάση αποθηκεύει όλα τα  στοιχεία μιας πώλησης,
 * όπως το προϊόν που πωλήθηκε, την ποσότητα, το συνολικό
 * ποσό της συναλλαγής και την ημερομηνία και ώρα πραγματοποίησης
 * της πώλησης.
 *
 * @author Ευαγγελία Άννα Καλοδήμου, Μερτινός Νεκτάριος
 */
public class Sales {
/** Το προϊόν που πωλήθηκε. */
    private Product productSold;
/** Η ποσότητα που πωλήθηκε. */
    private int quantitySold;
/** Το συνολικό ποσό της πώλησης. */
    private double totalAmount;
/** Η ημερομηνία και ώρα της πώλησης. */
    private LocalDateTime saleTime;
/** Η ποσότητα που πωλήθηκε σε μορφή συμβολοσειράς. */
    String soldQuantity;
/** Το συνολικό ποσό της πώλησης σε μορφή συμβολοσειράς. */
    String totalPrice;
/** Αντικείμενο που αναπαριστά το προίον που πουλήθηκε. */
    Object soldProduct;
/**
 * Δημιουργεί μία νέα  πώληση.
 *
 * Υπολογίζει αυτόματα το συνολικό ποσό της πώλησης
 * πολλαπλασιάζοντας την τιμή του προϊόντος με την ποσότητα
 * και αποθηκεύει την τρέχουσα ημερομηνία και ώρα
 *
 * @param productSold το προϊόν που πωλήθηκε
 * @param quantitySold η ποσότητα που πωλήθηκε
 */
    public Sales(Product productSold, int quantitySold) {
        this.productSold = productSold;
        this.quantitySold = quantitySold;
        this.totalAmount = productSold.price * quantitySold; 
        this.saleTime = LocalDateTime.now();
    }

/** Επιστρέφει το προϊόν που πωλήθηκε.
 *
 * @return το προϊόν της πώλησης
 */    
    public Product getProductSold() { return this.productSold; }
/**Επιστρέφει τη ποσότητα που πωλήθηκε.
 *
 * @return η ποσότητα της πώλησης
 */
    public int getQuantitySold() { return this.quantitySold; }
/**Επιστρέφει το ποσο της συναλλάγης.
 * *
 * @return το συνολικό ποσό της συναλλαγής
 */
    public double getTotalAmount() { return this.totalAmount; }
/**
 * Επιστρέφει την ημερομηνία και ώρα της πώλησης
 * σε μορφή {@code dd-MM-yyyy HH:mm:ss}.
 *
 * @return ημερομηνία και ώρα της πώλησης
 */    
    public String getFormattedSaleTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return this.saleTime.format(formatter);
    }
/**
 * Δημιουργεί ένα νέο αντικείμενο soldProduct.
 */
    class soldProduct {

        static String productName;

        public soldProduct() {
        }
    }
}