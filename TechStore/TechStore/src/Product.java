/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Αναπαριστά ένα προϊόν του καταστήματος.
 *
 * Η κλάση Product αποτελεί την πατρική κλάση όλων των
 * προϊόντων της εφαρμογής. Περιλαμβάνει τα κοινά χαρακτηριστικά
 * κάθε προϊόντος, όπως τον κωδικό, την περιγραφή, την τιμή
 * πώλησης και τη διαθέσιμη ποσότητα στο απόθεμα.
 *
 * Από την κλάση αυτή κληρονομούν οι κλάσεις Computers και MobilePhones.
 *
 * @author Ευαγγελία Άννα Καλοδήμου, Μερτινός Νεκτάριος

 */
public class Product {
/** Ο κωδικός του προϊόντος. */
    public String code;
/** Η περιγραφή του προίοντος. */
    public String description;
/** Η τιμή του προϊόντος. */
    public double price;
/** Η ποσότητα του προϊόντος. */
    public int quantity;
/** Ο κατασκευαστής του προϊόντος. */
    Object manufacturer;

 /**
 * Δημιουργεί ένα νέο αντικείμενο τύπου Product.
 *
 * @param code ο κωδικός του προϊόντος
 * @param description η περιγραφή του προϊόντος
 * @param price η τιμή του προϊόντος
 * @param quantity η ποσότητα του προίοντος
 */  
    public Product(String code, String description, double price, int quantity) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    int getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}