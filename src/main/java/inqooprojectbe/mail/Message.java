package inqooprojectbe.mail;

import inqooprojectbe.model.Schedule;
import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.Workshop;

public class Message {
    private Workshop workshop;
    private Trainer trainer;
    private Subcategory subcategory;
    private Schedule schedule;

    public Message(Workshop workshop, Trainer trainer, Subcategory subcategory) {
        this.workshop = workshop;
        this.trainer = trainer;
        this.subcategory = subcategory;
    }

    public Message() {

    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Message{" +
                "workshop=" + workshop +
                ", trainer=" + trainer +
                ", subcategory=" + subcategory +
                '}';
    }
    public String workshopDaysToString(String works){

        return works;
    }

    public String setMessage(String subcategoryName, String workshopName, String trainerName, String date, int period, String price ){
        return """
                Dzień dobry!
                Wybrałeś kurs: %s %s, prowadzony przez: %s,
                który rozpocznie się w dniu: %s i potrwa %d dni
                Koszt szkolenia to: %s złoty.
                Dziękujemy za wybranie naszych usług i skontaktujemy w najbliższym czasie.
                
                Pozdrawiamy
                Zespół Kremówek
                """.formatted(subcategory.getName(), workshop.getName(), trainer.getName(), schedule.getStartDate(), workshop.getWorkshopTime(), workshop.getPrice() );
    }
}
