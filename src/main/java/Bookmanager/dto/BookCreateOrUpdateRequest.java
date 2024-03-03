package Bookmanager.dto;

public class BookCreateOrUpdateRequest {
    private String name;
    private int year;

    public String getName() {
        return name;
    }
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }
}
