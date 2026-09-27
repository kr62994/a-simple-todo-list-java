package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TodoListTest {
    private TodoList list;

    @BeforeEach
    void setUp() {
        list = new TodoList();
    }

    @Test
    void testAdd() {
        list.add("Buy milk");
        list.add("Buy eggs");
    }

    @Test
    void testEmptyAdd() {
        assertThrows(IllegalArgumentException.class, () -> list.add(""));
    }

    @Test
    void testDuplicateAdd() {
        list.add("Buy milk");
        assertThrows(IllegalArgumentException.class, () -> list.add("Buy milk"));
    }

    @Test
    void testComplete() {
        list.add("Buy milk");
        list.complete("Buy milk");
    }

    @Test
    void testCompleteNotExistent() {
        assertThrows(IllegalArgumentException.class, () -> list.complete("Buy milk"));
    }

    @Test
    void testCompleteAlreadyCompleted() {
        list.add("Buy milk");
        list.complete("Buy milk");
        assertThrows(IllegalArgumentException.class, () -> list.complete("Buy milk"));
    }


}
