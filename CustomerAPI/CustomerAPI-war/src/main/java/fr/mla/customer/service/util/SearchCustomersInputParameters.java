package fr.mla.customer.service.util;

public class SearchCustomersInputParameters {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String extId;
    private Boolean soundex;
    private Integer algo;
    private String view;

    public SearchCustomersInputParameters(String firstName, String lastName, String phone, String email, String extId, Boolean soundex, Integer algo, String view) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.extId = extId;
        this.soundex = soundex;
        this.algo = algo;
        this.view = view;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getExtId() {
        return extId;
    }

    public Boolean getSoundex() {
        return soundex;
    }

    public Integer getAlgo() {
        return algo;
    }

    public String getView() {
        return view;
    }
}
