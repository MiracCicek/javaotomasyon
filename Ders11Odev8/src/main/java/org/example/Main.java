package org.example;

import java.util.ArrayList;
import java.util.List;

class Personel {
    private String ad;
    private String soyad;
    private String dogumTarihi;

    public Personel(String ad, String soyad, String dogumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public int emekliOlmaYasi() {
        return 60; // Kadınlar 60 yaşında emekli olur
    }
}

class Erkek extends Personel {
    public Erkek(String ad, String soyad, String dogumTarihi) {
        super(ad, soyad, dogumTarihi);
    }

    @Override
    public int emekliOlmaYasi() {
        return 65; // Erkekler 65 yaşında emekli olur
    }
}

class Departman {
    private Erkek teamLead;
    private List<Personel> personelList;
    private List<String> assignmentList;

    public Departman(Erkek teamLead) {
        this.teamLead = teamLead;
        this.personelList = new ArrayList<>();
        this.assignmentList = new ArrayList<>();
    }

    public void setTeamLead(Erkek teamLead) {
        this.teamLead = teamLead;
    }

    public void addPersonel(Personel personel) {
        personelList.add(personel);
    }

    public void removePersonel(Personel personel) {
        personelList.remove(personel);
    }

    public void changeTeamLead(Erkek newTeamLead) {
        this.teamLead = newTeamLead;
    }

    public void addAssignment(String assignment) {
        assignmentList.add(assignment);
    }

    public void markAssignmentComplete(String assignment) {
        assignmentList.remove(assignment);
        System.out.println(assignment + " tamamlandı olarak işaretlendi.");
    }

    public static void main(String[] args) {
        Erkek teamLead = new Erkek("Ahmet", "Yılmaz", "01.01.1975");
        Departman department = new Departman(teamLead);

        Personel personel1 = new Personel("Ayşe", "Kaya", "01.01.1980");
        Personel personel2 = new Personel("Mehmet", "Demir", "01.01.1985");

        department.addPersonel(personel1);
        department.addPersonel(personel2);

        department.addAssignment("Proje 1");
        department.addAssignment("Proje 2");

        department.markAssignmentComplete("Proje 1");
    }
}