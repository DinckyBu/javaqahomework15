import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.AviaSouls;
import ru.netology.javaqa.Ticket;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void compareTo() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 2_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket6, ticket2};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToInOrder() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 2_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.search("SPB", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToEqual() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 2_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_000, 18, 22);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6, ticket2, ticket7};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareTo1() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 2_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("MSK", "UFA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareTo0() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 2_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "KZN");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparator1() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("SPB", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparator0() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 18, 21);
        Ticket ticket2 = new Ticket("MSK", "SPB", 4_000, 19, 23);
        Ticket ticket3 = new Ticket("SPB", "UFA", 3_000, 21, 00);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_000, 7, 11);
        Ticket ticket5 = new Ticket("SPB", "MSK", 4_000, 12, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 11, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("SPB", "KZN", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
