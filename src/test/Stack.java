package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class Stack<T> {
    //linked list are very goo to implement stacks (LIFO)
    LinkedList<T> list;

    public Stack() {
        this.list = new LinkedList<T>();
    }

    public void push(T t) {
        //inserts new element
        list.push(t);
    }

    public T pop() {
        //remove and return the last inserted element
        return list.pop();
    }

    public T peek() {
        //return the last element
        return list.peek();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}

class StackTest {
    Stack<String> names;

    @BeforeEach
    public void init() {
        names = new Stack<>();
    }

    @Test
    public void testStackEmpty() {
        assertTrue(names.empty());
    }

    @Test
    public void testStackCoisoeTal() {
        names.push("coiso");
        names.push("e");
        names.push("tal");
        assertFalse(names.empty());
        assertEquals("tal", names.peek());
        assertEquals("tal", names.peek());
        assertEquals("tal", names.pop());
        assertEquals("e", names.pop());
        assertEquals("coiso", names.pop());
        assertTrue(names.empty());
    }

    @Test
    public void testStackCenas() {
        names.push("Cenas");
        assertEquals("Cenas", names.pop());
        assertTrue(names.empty());
    }
}
