/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author student1
 */
public class Operation implements Serializable{
    public static final int Operacija_Kreiraj_Radnika=1;
    public static final int Operacija_Zapamti_Radnika=2;
    public static final int Operacija_Kreiraj_Korisnika=3;
    public static final int Operacija_Zapamti_Korisnika=4;
    public static final int Operacija_Prijava_Radnika=5;
    public static final int Operacija_Kreiraj_Prtljag=6;
    public static final int Operacija_Zapamti_Prtljag=7;
    public static final int Operacija_Kreiraj_Prijemnicu=8;
    public static final int Operacija_Zapamti_Prijemnicu=9;
    public static final int Operacija_Vrati_Prijemnicu=10;
    public static final int Operacija_Kreiraj_Racun=11;
    public static final int Operacija_Zapamti_Racun=12;
    public static final int Operacija_Vrati_TrenutnoStanje=13;
    public static final int Operacija_Vrati_IzvestajRacuna=14;
    public static final int Operacija_Vrati_RacuneZaKorisnikeICene=15;
    public static final int Operacija_Vrati_Listu_Korisnika=16;
    public static final int Operacija_Vrati_Tipove_Prtljaga=17;
    public static final int Operacija_Vrati_Listu_Prtljaga=18;
    //todo sve operacije!
}
