/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eshoppe;

/**
 *
 * @author Isabelle
 */
public class Utilitaires {
    //contient des méthodes réutilisables
    static String retourneNullsiVide(String val)
    {
        if(val.equals(""))
        {
            val = "null";
        }
        return val;
    }
}
