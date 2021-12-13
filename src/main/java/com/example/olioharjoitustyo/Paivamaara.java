package com.example.olioharjoitustyo;

import java.io.Serializable;


public class Paivamaara implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int paiva;
    private int kuukausi;
    private int vuosi;


    //Piti lisätä String.format(), jotta tunnisti ja osasi järjestää kuukaudet ja päivät.
    @Override
    public String toString() {
        return vuosi + "." + String.format("%02d",kuukausi) + "." + String.format("%02d",paiva);
    }




    //Ottaa nykyisen päivämäärän
    public Paivamaara() {
        super();
        java.time.LocalDate tanaan = java.time.LocalDate.now();
        paiva = tanaan.getDayOfMonth();
        kuukausi = tanaan.getMonthValue();
        vuosi = tanaan.getYear();
    }

    //Pitää itse syöttää kokonaisluku muodossa päivämäärä
    public Paivamaara(int paiva, int kuukausi, int vuosi) {
        super();
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    //Syötetään 23.1.2021 muodossa merkkijono
    public Paivamaara(String paiva) {
        String [] pa = paiva.split("\\.");
        //String [] pa = paiva.split("- .");
        this.paiva=Integer.parseInt(pa[0]);
        this.kuukausi=Integer.parseInt(pa[1]);
        this.vuosi= Integer.parseInt(pa[2]);
    }

    public int getPaiva() {
        return paiva;
    }

    public void setPaiva(int paiva) {
        this.paiva = paiva;
    }

    public int getKuukausi() {
        return kuukausi;
    }

    public void setKuukausi(int kuukausi) {
        this.kuukausi = kuukausi;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    //Testataan onko 2 olion päivämäärä sama
    public boolean onSama(Paivamaara toinen) {
        if(getPaiva()!=toinen.getPaiva() || getKuukausi()!= toinen.getKuukausi() || getVuosi()!=toinen.getVuosi()) {
            return false;
        }
        else {
            return true;
        }
    }

    //Kuukausi taulu
    public static final String[] KUUKAUDET = {"tammikuu", "helmikuu", "maaliskuu", "huhtikuu", "toukokuu", "kesäkuu", "heinäkuu",
            "elokuu", "syyskuu", "lokakuu", "marraskuu", "joulukuu"};

    //Instanssimetodissa käsitellään olioita ja ei ole static määrettä
    //Palauttaa päivämäärä olion 11. Toukokuuta, 2021 muodossa
    public String instanssimetodi() {
        int a=getKuukausi();
        return paiva + ". " + KUUKAUDET[a-1]+"ta" + ", " + vuosi;
    }

    //Luokkametodi, mikä palauttaa annetun kuukauden numerona ei ole väliä onko kuukausi kirjoitettu isolla vai pienellä
    public static int luokkametodi(String kuukausi) {
        int kk=0;
        kuukausi=kuukausi.toLowerCase();
        //System.out.println(kuukausi);
        for(int i=0;i<KUUKAUDET.length;i++) {
            if (KUUKAUDET[i].equals(kuukausi)) {
                kk=i+1;
                break;
            }
        }
        return kk;
    }
}