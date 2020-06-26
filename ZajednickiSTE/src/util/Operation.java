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
    public static final int Operacija_Kreiraj_Korisnika=2;
    public static final int Operacija_Prijava_Radnika=3;
    public static final int Operacija_Kreiraj_Prtljag=4;
    public static final int Operacija_Kreiraj_Prijemnicu=5;
    public static final int Operacija_Vrati_Prijemnicu=6;
    public static final int Operacija_Kreiraj_Racun=7;
    public static final int Operacija_Vrati_TrenutnoStanje=8;
    public static final int Operacija_Vrati_IzvestajRacuna=9;
    public static final int Operacija_Vrati_RacuneZaKorisnikeICene=10;
    public static final int Operacija_Vrati_Listu_Korisnika=11;
    public static final int Operacija_Vrati_Tipove_Prtljaga=12;
    public static final int Operacija_Vrati_Listu_Prtljaga=13;
    public static final int Operacija_Obrisi_Prijemnicu=14;
    public static final int Operacija_Stampaj_Izvestaj=15;
    //todo sve operacije!
}
