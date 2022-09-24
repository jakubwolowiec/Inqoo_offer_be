package inqooprojectbe.mail;

import inqooprojectbe.model.SubcategoryDTO;

import java.util.List;

public class Request {
    private String receiver;
    private List<SubcategoryDTO> subcategoryDTOList;


    public Request(String receiver, List<SubcategoryDTO> subcategoryDTOList) {
        this.receiver = receiver;
        this.subcategoryDTOList = subcategoryDTOList;
    }

    public String getReceiver() {
        return receiver;
    }

    public List<SubcategoryDTO> getSubcategoryDTOList() {
        return subcategoryDTOList;
    }

}
