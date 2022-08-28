/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import errores.ErrorChecked;

/**
 *
 * @author fabricio
 */
public interface VentanaInicializable {
    public void cargarVentana(String fxmlUrl) throws ErrorChecked;
}
