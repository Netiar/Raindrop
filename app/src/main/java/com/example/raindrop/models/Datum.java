
package com.example.raindrop.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idCountry")
    @Expose
    private Integer idCountry;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nationalLeague")
    @Expose
    private Boolean nationalLeague;
    @SerializedName("clubsLeague")
    @Expose
    private Boolean clubsLeague;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param name
     * @param id
     * @param countryName
     * @param clubsLeague
     * @param idCountry
     * @param nationalLeague
     */
    public Datum(Integer id, Integer idCountry, String countryName, String name, Boolean nationalLeague, Boolean clubsLeague) {
        super();
        this.id = id;
        this.idCountry = idCountry;
        this.countryName = countryName;
        this.name = name;
        this.nationalLeague = nationalLeague;
        this.clubsLeague = clubsLeague;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNationalLeague() {
        return nationalLeague;
    }

    public void setNationalLeague(Boolean nationalLeague) {
        this.nationalLeague = nationalLeague;
    }

    public Boolean getClubsLeague() {
        return clubsLeague;
    }

    public void setClubsLeague(Boolean clubsLeague) {
        this.clubsLeague = clubsLeague;
    }

}
