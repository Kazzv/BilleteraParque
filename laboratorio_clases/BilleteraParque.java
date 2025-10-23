package laboratorio_clases;

public class BilleteraParque {
     private int tickets;
    private static boolean festivo = false;

    public BilleteraParque() {
        this.tickets = 0;
    }

    public BilleteraParque(int tickets) {
        if (tickets < 0) {
            this.tickets = 0;
        } else {
            this.tickets = tickets;
        }
    }

    public int getTickets() {
        return this.tickets;
    }

    public static boolean isFestivo() {
        return festivo;
    }

    public void setTickets(int tickets) {
        if (tickets >= 0) {
            this.tickets = tickets;
        }
    }

    public static void toggleFestivo() {
        festivo = !festivo;
    }

    public void agregarTickets(int cantidad) {
        if (cantidad >= 0) {
            this.tickets += cantidad;
        }
    }

    public boolean removerTickets(int cantidad) {
        if (cantidad >= 0 && this.tickets >= cantidad) {
            this.tickets -= cantidad;
            return true;
        } //hola
        return false;
    }
}
