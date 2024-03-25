package ru.sberbank.jd.lesson06;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CustomArrayImplTest {

    CustomArrayImpl<String> customArrayImpl = new CustomArrayImpl<>();

    @Test
    public void size() {
        customArrayImpl.add("test");
        customArrayImpl.add("size");
        customArrayImpl.add("of");
        customArrayImpl.add("array");
        Assert.assertEquals(4, customArrayImpl.size());
        customArrayImpl = new CustomArrayImpl<>();
        Assert.assertEquals(0, customArrayImpl.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(customArrayImpl.isEmpty());
    }

    @Test
    public void add() {
        Assert.assertTrue(customArrayImpl.add("add1"));
        Assert.assertEquals("add1 ", customArrayImpl.toString());
    }

    @Test
    public void test1AddAll() {
        customArrayImpl.add("test");
        customArrayImpl.add("add");
        customArrayImpl.add("all");
        String[] strToAdd = {"add","array"};
        Assert.assertTrue(customArrayImpl.addAll(strToAdd));
        Assert.assertEquals(5,customArrayImpl.size());
        Assert.assertEquals("test add all add array ",customArrayImpl.toString());
    }

    @Test
    public void test2AddAll() {
        customArrayImpl.add("test2");
        customArrayImpl.add("add");
        customArrayImpl.add("all");
        List<String> strToAdd = new ArrayList<>();
        strToAdd.add("add");
        strToAdd.add("List");
        Assert.assertTrue(customArrayImpl.addAll(strToAdd));
        Assert.assertEquals(5,customArrayImpl.size());
        Assert.assertEquals("test2 add all add List ",customArrayImpl.toString());
    }

    @Test
    public void test3AddAll() {
        customArrayImpl.add("test3");
        customArrayImpl.add("add");
        customArrayImpl.add("all");
        String[] strToAdd = {"Index","add"};
        Assert.assertTrue(customArrayImpl.addAll(0,strToAdd));
        Assert.assertEquals(5,customArrayImpl.size());
        Assert.assertEquals("Index add test3 add all ",customArrayImpl.toString());
    }

    @Test
    public void get() {
        customArrayImpl.add("test");
        customArrayImpl.add("get");
        Assert.assertEquals("get",customArrayImpl.get(1));
    }

    @Test
    public void set() {
        customArrayImpl.add("test");
        customArrayImpl.add("set");
        customArrayImpl.add("item");
        Assert.assertEquals("item",customArrayImpl.set(2,"newItem"));
        Assert.assertEquals("test set newItem ",customArrayImpl.toString());
    }

    @Test
    public void remove() {
        customArrayImpl.add("test");
        customArrayImpl.add("item");
        customArrayImpl.add("remove");
        customArrayImpl.remove(1);
        Assert.assertEquals("test remove ",customArrayImpl.toString());
        Assert.assertEquals(2,customArrayImpl.size());
    }

    @Test
    public void testRemove() {
        customArrayImpl.add("test");
        customArrayImpl.add("item");
        customArrayImpl.add("remove");
        customArrayImpl.remove("test");
        Assert.assertEquals("item remove ",customArrayImpl.toString());
        Assert.assertEquals(2,customArrayImpl.size());
    }

    @Test
    public void contains() {
        customArrayImpl.add("test");
        customArrayImpl.add("contains");
        customArrayImpl.add("item");
        Assert.assertTrue(customArrayImpl.contains("item"));
        Assert.assertFalse(customArrayImpl.contains("test2"));
    }

    @Test
    public void indexOf() {
        customArrayImpl.add("test");
        customArrayImpl.add("indexOf");
        Assert.assertEquals(1,customArrayImpl.indexOf("indexOf"));
    }

    @Test
    public void ensureCapacity() {
        customArrayImpl.add("test");
        customArrayImpl.add("ensure");
        customArrayImpl.add("capacity");
        Assert.assertEquals(3,customArrayImpl.getCapacity());
        customArrayImpl.ensureCapacity(2);
        Assert.assertEquals(2,customArrayImpl.getCapacity());
        customArrayImpl.ensureCapacity(5);
        Assert.assertEquals(5,customArrayImpl.getCapacity());
    }

    @Test
    public void getCapacity() {
        customArrayImpl.add("test");
        customArrayImpl.add("get");
        customArrayImpl.add("capacity");
        Assert.assertEquals(3,customArrayImpl.getCapacity());
        customArrayImpl.ensureCapacity(5);
        Assert.assertEquals(5,customArrayImpl.getCapacity());
    }

    @Test
    public void reverse() {
        customArrayImpl.add("test");
        customArrayImpl.add("reverse");
        customArrayImpl.add("array");
        customArrayImpl.reverse();
        Assert.assertEquals("array reverse test ",customArrayImpl.toString());
    }
    @Test
    public void toArray() {
        customArrayImpl.add("toArray");
        customArrayImpl.add("test");
        Assert.assertNotNull(customArrayImpl.toArray());
    }
}