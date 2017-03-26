package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Characters.Enemy;
import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.Map;
import Maps.MapDimension;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import Weapons.Club;
import Weapons.Weapon;

public class Tests {

	private Map Map1;
	private Map Map2;
	private Guard map1Guard;
	private Hero ma1Hero;
	private Hero map2Hero;
	private Oggre map2Oggre;
	
	private String[][] map1=new String[][]{
	        {"X","X","X","X","X","X","X","X","X","X"},
	        {"X"," "," "," ","I"," ","X"," "," ","X"},
	        {"X","X","X"," ","X","X","X"," "," ","X"},
	        {"X"," ","I"," ","I"," ","X"," "," ","X"},
	        {"X","X","X"," ","X","X","X"," "," ","X"},
	        {" "," "," "," "," "," "," "," "," ","X"},
	        {" "," "," "," "," "," "," "," "," ","X"},
	        {"X","X","X"," ","X","X","X","X"," ","X"},
	        {"X"," ","I"," ","I"," ","X"," "," ","X"},
	        {"X","X","X","X","X","X","X","X","X","X"}
	    };
	    private     String[][] referenceMap1=new String[][]{
	            {"X","X","X","X","X","X","X","X","X","X"},
	            {"X"," "," "," ","I"," ","X"," "," ","X"},
	            {"X","X","X"," ","X","X","X"," "," ","X"},
	            {"X"," ","I"," ","I"," ","X"," "," ","X"},
	            {"X","X","X"," ","X","X","X"," "," ","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {"X","X","X"," ","X","X","X","X"," ","X"},
	            {"X"," ","I"," ","I"," ","X"," "," ","X"},
	            {"X","X","X","X","X","X","X","X","X","X"}
	    };
	    private     MapDimension map1Dimension=new MapDimension(10,10);


	    private     String[][] map2=new String[][]{
	            {"X","X","X","X","X","X","X","X","X","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X","X","X","X","X","X","X","X","X","X"}
	    };

	    private    String[][] referenceMap2=new String[][]{
	            {"X","X","X","X","X","X","X","X","X","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X","X","X","X","X","X","X","X","X","X"}
	    };
	    
	    private   MapDimension map2Dimension=new MapDimension(10,10);

	    private   Lever map1Lever = new Lever(7,8);
	    private   Key map2Key = new Key(8,1);

	    private   Enemy[] map1Enemies=new Enemy[1];
	   

	    private   Lever[] map1Levers=new Lever[1];

	    private   Key[] map2Keys = new Key [1];

	    private   Door[] map1Doors = new Door[2];
	    private   Door[] map2Doors = new Door[1];

	    //private   Club map2Club = new Club(map2Oggre);

	    private    Weapon[] oggreMap2Weapons = new Weapon[1];
	
	@Test
	public void testHeroi()
	{
	    ma1Hero= new Hero(map1,2,1);
	    map2Hero=new Hero(map2,1,8);
	    map1Guard = new Guard(map1,"rookie");
        map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);



        Map map1 = new Map(this.map1,this.referenceMap1,this.map1Dimension,ma1Hero,map1Enemies,map1Levers,true);
        map1.setDoor(map1Doors);
        
        //moving to the right to an empty cell
        map1.SwingmapLogic(4);
        assertEquals(3, ma1Hero.getXPos());
        //moving left to an empty cell
        map1.SwingmapLogic(3);
        assertEquals(2, ma1Hero.getXPos());
        //moving up towards a wall the hero needs to stay in the same place
        map1.SwingmapLogic(1);
        assertEquals(1, ma1Hero.getYPos());
        //moving down towards a wall the hero needs to stay in the same place
        map1.SwingmapLogic(2);
        assertEquals(1, ma1Hero.getYPos());
	}
	
	@Test
	public void testLockedDoor()
	{
	    ma1Hero= new Hero(map1,2,6);
	    map2Hero=new Hero(map2,1,8);
		map1Guard = new Guard(map1, "rookie");
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
        for(int i = 0; i < 1; i++)
        map2Enemies[i]= map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
        //the hero tries to go through the first locked door, must stay in the same place
		Map1.SwingmapLogic(3);
		Map1.SwingmapLogic(3);
		Map1.SwingmapLogic(3);
		Map1.SwingmapLogic(3);
        assertEquals(1, ma1Hero.getXPos());
        //the hero tries to go through the second locked door, must stay in the same place
        Map1.SwingmapLogic(2);
		Map1.SwingmapLogic(3);
		Map1.SwingmapLogic(3);
		Map1.SwingmapLogic(3);
		Map1.SwingmapLogic(3);
		assertEquals(1, ma1Hero.getXPos());
	}
	
	@Test
	public void testGettingCaught()
	{
	    ma1Hero= new Hero(map1,7,3);
	    map2Hero=new Hero(map2,1,8);
		map1Guard = new Guard(map1, "rookie");
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
        for(int i = 0; i < 1; i++)
        map2Enemies[i]= map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	//by moving up the player will be close to the guard therefore the game ends
	assertEquals(false, Map1.hasLost());
	Map1.SwingmapLogic(1);
	assertEquals(true, Map1.hasLost());
	}
	
	@Test
	public void testTurninLeverAndNextLevel()
	{
	    ma1Hero= new Hero(map1,8,8);
	    map2Hero=new Hero(map2,1,8);
		map1Guard = new Guard(map1, "rookie");
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
        for(int i = 0; i < 1; i++)
        map2Enemies[i]= map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	//the doors are initially closed
	assertEquals(false, Map1.getDoors()[0].getIsOpen());
	Map1.SwingmapLogic(3);
	//the doors are opened by the lever
	assertEquals(true, Map1.getDoors()[0].getIsOpen());
	Map1.getHero().setXPos(2);
	Map1.getHero().setYPos(5);
	//the hero hasn't yet walked down the stairs
	assertEquals(false, Map1.hasWon());
	Map1.SwingmapLogic(3);
	Map1.SwingmapLogic(3);
	//the hero walked the stairs and won the first level
	assertEquals(true, Map1.hasWon());
	}
	
	@Test
	public void testOgreAttack()
	{
	    ma1Hero= new Hero(map1,8,8);
	    map2Hero=new Hero(map2,2,1);
		map1Guard = new Guard(map1, "rookie");
		map2Oggre = new Oggre(map2);
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
//        for(int i = 0; i < 1; i++)
//        map2Enemies[i]= map2Oggre;
        map2Enemies[0] = map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	//the hero is away from the ogre so the game isn't over
	assertEquals(false, Map2.hasLost());
	//the hero moves closer to the ogre and the game ends
	Map2.SwingmapLogic(4);
	assertEquals(true, Map2.hasLost());
	}
	
	@Test
	public void testKeyRepresentationAndIsPicked()
	{
	    ma1Hero= new Hero(map1,8,8);
	    map2Hero=new Hero(map2,8,2);
		map1Guard = new Guard(map1, "rookie");
		map2Oggre = new Oggre(map2);
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
//        for(int i = 0; i < 1; i++)
//        map2Enemies[i]= map2Oggre;
        map2Enemies[0] = map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	//the hero hasn't picked up the key yet
	assertEquals(false, Map2.getKeys()[0].isPicked());
	//the hero moves towards the key, pickes it up and changes his representation
	Map2.SwingmapLogic(1);
	assertEquals("K", Map2.getHero().getRepresentation(map2Keys));
	assertEquals(true, Map2.getKeys()[0].isPicked());
	}
	
	@Test
	public void doorWithoutKey()
	{
	    ma1Hero= new Hero(map1,8,8);
	    map2Hero=new Hero(map2,2,1);
		map1Guard = new Guard(map1, "rookie");
		map2Oggre = new Oggre(map2);
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
//        for(int i = 0; i < 1; i++)
//        map2Enemies[i]= map2Oggre;
        map2Enemies[0] = map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	//the hero hasn't picked up the key yet
	assertEquals(false, Map2.getKeys()[0].isPicked());
	//the hero moves towards the locked door
	Map2.SwingmapLogic(3);
	assertEquals(1, Map2.getHero().getXPos());
	//the hero stays in the same position because the door is locked
	Map2.SwingmapLogic(3);
	assertEquals(1, Map2.getHero().getXPos());
	}
	
	@Test
	public void doorOpensWithKeyAndWinGame()
	{
	    ma1Hero= new Hero(map1,8,8);
	    map2Hero=new Hero(map2,8,2);
		map1Guard = new Guard(map1, "rookie");
		map2Oggre = new Oggre(map2);
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
   //     oggreMap2Weapons[0]=map2Club;
    //    map2Oggre.setWeapons(oggreMap2Weapons);
//        for(int i = 0; i < 1; i++)
//        map2Enemies[i]= map2Oggre;
        map2Enemies[0] = map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	//picking up the key
	Map2.SwingmapLogic(1);
	assertEquals(true, Map2.getKeys()[0].isPicked());
	//walking to the door but 1 unit away so the door is still closed
	Map2.getHero().setXPos(2);
	Map2.getHero().setYPos(1);
	Map2.SwingmapLogic(3);
	assertEquals(false, Map2.getDoors()[0].getIsOpen());
	//opening the door
	Map2.SwingmapLogic(3);
	assertEquals(true, Map2.getDoors()[0].getIsOpen());
	//hero hasn't walked through the door yet
	assertEquals(false, Map2.hasWon());
	//hero walked through the door and won
	Map2.SwingmapLogic(3);
	assertEquals(true, Map2.hasWon());
	}
	
	@Test(timeout = 1000)
	public void testOgreRandomMovement()
	{
	    ma1Hero= new Hero(map1,8,8);
	    map2Hero=new Hero(map2,1,8);
		map1Guard = new Guard(map1, "rookie");
		map2Oggre = new Oggre(map2);
		Enemy[] map2Enemies = new  Enemy[1];
		map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
        Club map2Club = new Club(map2Oggre);
        oggreMap2Weapons[0]=map2Club;
        map2Oggre.setWeapons(oggreMap2Weapons);
//        for(int i = 0; i < 1; i++)
//        map2Enemies[i]= map2Oggre;
        map2Enemies[0] = map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);

	Map Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
	Map1.setDoor(map1Doors);
	Map Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
	Map2.setDoor(map2Doors);
	Map1.setNextMap(Map2);
        
	boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4= false;
	while(!outcome1 || !outcome2 || !outcome3 || !outcome4)
	{
		Map2.SwingmapLogic(1);
		if(Map2.getEnemies().get(0).getXPos()==3)
			outcome1 = true;
		else if(Map2.getEnemies().get(0).getXPos()==5)
			outcome2 = true;
		else if(Map2.getEnemies().get(0).getYPos()==2)
			outcome3 = true;
		else if(Map2.getEnemies().get(0).getYPos()==1)
			outcome4 = true;
	}
	
	}
}
