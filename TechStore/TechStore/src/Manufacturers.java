/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Αναπαριστά έναν κατασκευαστή ηλεκτρονικών προϊόντων.
 *
 * Κλάση που αποθηκεύει τα βασικά στοιχεία του κατασκευαστή,
 * όπως κωδικό, επωνυμία και διεύθυνση ηλεκτρονικού ταχυδρομείου.
 *
 * @author Ευαγγελία Άννα Καλοδήμου, Μερτινός Νεκτάριος
 */
public class Manufacturers {
/** Ο κωδικός του κατασκευαστή.*/
    public String code;         // Κωδικός
/** Η επωνυμία του κατασκευαστή.*/
    public String name;         // Επωνυμία
/** Το email του κατασκευαστή.*/
    public String email;        // Email
/**
 * Δημιουργεί ένα νέο αντικείμενο τύπου Κατασκευαστή.
 *
 * @param code ο κωδικός του κατασκευαστή
 * @param name η επωνυμία του κατασκευαστή
 * @param email το email του κατασκευαστή
 */
    public Manufacturers(String code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
        
        
    }
}

