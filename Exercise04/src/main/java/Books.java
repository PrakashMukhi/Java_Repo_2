public class Books {
    /*
     * fields for books class
     */
    private String title;
    private int publicationYear;
    private double rating;

    public Books(String title, int publicationYear, double rating) {
        super();
        this.title = title;
        this.publicationYear = publicationYear;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
