import org.junit.Test;

import main.Logic.ElementSystem.Element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ElementSystemTest {

    @Test
    public void fireVsTest(){
        Element testElment = new Element();

        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.FIRE,Element.DamageElement.AIR),0.01);
        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.FIRE,Element.DamageElement.FIRE),0.01);
        assertEquals(2,testElment.ElementComparation(
                Element.DamageElement.FIRE,Element.DamageElement.EARTH),0.01);
        assertEquals(0.5,testElment.ElementComparation(
                Element.DamageElement.FIRE,Element.DamageElement.WATER),0.01);
    }

    @Test
    public void waterVsTest(){
        Element testElment = new Element();

        assertEquals(0.5,testElment.ElementComparation(
                Element.DamageElement.WATER,Element.DamageElement.AIR),0.01);
        assertEquals(2,testElment.ElementComparation(
                Element.DamageElement.WATER,Element.DamageElement.FIRE),0.01);
        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.WATER,Element.DamageElement.EARTH),0.01);
        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.WATER,Element.DamageElement.WATER),0.01);
    }

    @Test
    public void earthVsTest(){
        Element testElment = new Element();

        assertEquals(2,testElment.ElementComparation(
                Element.DamageElement.EARTH,Element.DamageElement.AIR),0.01);
        assertEquals(0.5,testElment.ElementComparation(
                Element.DamageElement.EARTH,Element.DamageElement.FIRE),0.01);
        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.EARTH,Element.DamageElement.EARTH),0.01);
        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.EARTH,Element.DamageElement.WATER),0.01);
    }

    @Test
    public void airVsTest(){
        Element testElment = new Element();

        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.AIR,Element.DamageElement.AIR),0.01);
        assertEquals(1,testElment.ElementComparation(
                Element.DamageElement.AIR,Element.DamageElement.FIRE),0.01);
        assertEquals(0.5,testElment.ElementComparation(
                Element.DamageElement.AIR,Element.DamageElement.EARTH),0.01);
        assertEquals(2,testElment.ElementComparation(
                Element.DamageElement.AIR,Element.DamageElement.WATER),0.01);
    }

    @Test
    public void magicDamageTypeEnumTest(){
        assertEquals(Element.DamageType.Magical,Element.DamageType.Magical);
        assertNotEquals(Element.DamageType.Physical,Element.DamageType.Magical);
        assertNotEquals(Element.DamageType.TRUE,Element.DamageType.Magical);
    }

    @Test
    public void physicalDamageTypeEnumTest(){
        assertEquals(Element.DamageType.Physical,Element.DamageType.Physical);
        assertNotEquals(Element.DamageType.Physical,Element.DamageType.Magical);
        assertNotEquals(Element.DamageType.TRUE,Element.DamageType.Physical);
    }

    @Test
    public void trueDamageTypeEnumTest(){
        assertEquals(Element.DamageType.TRUE,Element.DamageType.TRUE);
        assertNotEquals(Element.DamageType.TRUE,Element.DamageType.Magical);
        assertNotEquals(Element.DamageType.TRUE,Element.DamageType.Physical);
    }

    @Test
    public void fireDamageElementTest() {
        assertEquals(Element.DamageElement.FIRE, Element.DamageElement.FIRE);
        assertNotEquals(Element.DamageElement.WATER, Element.DamageElement.FIRE);
        assertNotEquals(Element.DamageElement.AIR, Element.DamageElement.FIRE);
        assertNotEquals(Element.DamageElement.EARTH, Element.DamageElement.FIRE);
    }

    @Test
    public void waterDamageElementTest() {
        assertEquals(Element.DamageElement.WATER, Element.DamageElement.WATER);
        assertNotEquals(Element.DamageElement.FIRE, Element.DamageElement.WATER);
        assertNotEquals(Element.DamageElement.AIR, Element.DamageElement.WATER);
        assertNotEquals(Element.DamageElement.EARTH, Element.DamageElement.WATER);
    }

    @Test
    public void earthDamageElementTest() {
        assertEquals(Element.DamageElement.EARTH, Element.DamageElement.EARTH);
        assertNotEquals(Element.DamageElement.FIRE, Element.DamageElement.EARTH);
        assertNotEquals(Element.DamageElement.AIR, Element.DamageElement.EARTH);
        assertNotEquals(Element.DamageElement.EARTH, Element.DamageElement.WATER);
    }

    @Test
    public void airDamageElementTest() {
        assertEquals(Element.DamageElement.AIR, Element.DamageElement.AIR);
        assertNotEquals(Element.DamageElement.FIRE, Element.DamageElement.AIR);
        assertNotEquals(Element.DamageElement.AIR, Element.DamageElement.WATER);
        assertNotEquals(Element.DamageElement.EARTH, Element.DamageElement.AIR);
    }
}
