/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uappbo.Classes;

public interface ProductCounter {
    double TAX = 0;

    public double getTAX();

    public void setTAX(double TAX);
    
    public void hitungJumlahProduk();
    public void hitungHargaProduk();
}
