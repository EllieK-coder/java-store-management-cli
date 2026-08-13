/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Αναπαριστά ένα κινητό τηλέφωνο του καταστήματος.
 *
 * Η κλάση επεκτείνει την πατρική κλάση  Product και περιλαμβάνει
 * επιπλέον χαρακτηριστικά που αφορούν έναν κινητό, όπως
 * τον κατασκευαστή, την ανάλυση κάμερας και το χρώμα.
 *
 * @author Ευαγγελία Άννα Καλοδήμου, Μερτινός Νεκτάριος
 * 
 */
public class MobilePhones extends Product {
/** Ο κατασκευαστής του κινητού. */
    public Manufacturers manufacturer;
/** Η ανάλυση κάμερας του κινητού. */    
    public String cameraRes;
/** Το χρώμα του κινητού. */
    public String color;
/**
 * Δημιουργεί ένα νέο αντικείμενο το Κινητό.
 *
 * @param code ο μοναδικός κωδικός του προϊόντος
 * @param description η περιγραφή του υπολογιστή
 * @param price η τιμή πώλησης του προϊόντος
 * @param newQuantity η διαθέσιμη ποσότητα στο απόθεμα
 * @param manufacturer ο κατασκευαστής του υπολογιστή
 * @param cameraRes Ανάλυση της κάμερας
 * @param color το χρώμα του κινητού
 */
    public MobilePhones(String code, String description, double price, int newQuantity, Manufacturers manufacturer, String cameraRes, String color) {
        super(code, description, price, newQuantity);
        this.manufacturer = manufacturer;
        this.cameraRes = cameraRes;
        this.color = color;
    }
}