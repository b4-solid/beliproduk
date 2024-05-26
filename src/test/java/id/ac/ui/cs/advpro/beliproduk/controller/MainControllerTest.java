package id.ac.ui.cs.advpro.beliproduk.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainControllerTest {

    @Test
    public void testController() {
        MainController mainController = new MainController();
        String page = mainController.tempPage();

        assertEquals("tempPage", page);
    }
}
