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

    public Message(Workshop workshop, Trainer trainer, Subcategory subcategory, Schedule schedule) {
        this.workshop = workshop;
        this.trainer = trainer;
        this.subcategory = subcategory;
        this.schedule = schedule;
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
    public int getWorkshopDays() {
        int workshopDays = 0;
        int workshopTime = this.workshop.getWorkshopTime();
        while (workshopTime > 0) {
            workshopTime = -8;
            workshopDays++;
        }
        return workshopDays;
    }

    public String setMessage(){
        return """
                Dzień dobry!
                Wybrałeś kurs: %s %s, prowadzony przez: %s,
                który rozpocznie się w dniu: %s i potrwa %d dni
                Koszt szkolenia to: %s złoty.
                Dziękujemy za wybranie naszych usług i skontaktujemy w najbliższym czasie.
                
                Pozdrawiamy
                Zespół Kremówek
                """.formatted(this.subcategory.getName(), this.workshop.getName(), this.trainer.getName(), this.schedule.getStartDate().toString(), this.getWorkshopDays() , this.workshop.getPrice().toString() );
    }
}
