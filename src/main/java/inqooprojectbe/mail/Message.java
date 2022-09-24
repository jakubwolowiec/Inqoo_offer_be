package inqooprojectbe.mail;

import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.Workshop;

public class Message {
    private Workshop workshop;
    private Trainer trainer;
    private Subcategory subcategory;

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

    public String setMessage(){
        return """
                Dzień dobry!
                Wybrałeś kurs: %s %s, prowadzony przez: %s,
                który odbędzie się w dniach:
                %s
                """;
    }

}
