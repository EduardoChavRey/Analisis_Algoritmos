/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProblemaDelCambioMonetario;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Maestro
 */

public class OrdenaMonedas implements Comparator<Moneda> {
    public int compare(Moneda chair1, Moneda chair2) {
        return chair2.getValorMoneda()-chair1.getValorMoneda();
    }
}