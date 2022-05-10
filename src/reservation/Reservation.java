package reservation;

public class Reservation {

    private Client client;

    private String numero;


    public Reservation() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
