package be.intecbrussel.actresses.model;

public class Movies {

    private String title;
    private int year;
    private String genre;
    private String language;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movies{" +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", language=" + language +
                '}';
    }
}
