import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by kingkong on 8/18/17.
 */
public class SquadTest {
    @Test
    public void Squad_instantiatesCorrectly_true(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertTrue(mySquad instanceof Squad);
    }
    @Test
    public void Squad_getName_instantiatesWithName_String(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertEquals("Changers", mySquad.getName());
    }
    @Test
    public void Squad_getSize_instantiatesWithMaxSize_int(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertEquals(3, mySquad.getSize());
    }
    @Test
    public void Squad_getCause_instantiatesWithCause_String(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertEquals("Climate Change",mySquad.getCause());
    }
    @Test
    public void Squad_all_returnsAllInstancesOfSquad_true(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertTrue(Squad.all().contains(mySquad));
    }
    @Test
    public void Squad_getId_instantiatesWithId_int(){
        Squad.clear();
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertEquals(1, mySquad.getId());
    }
    @Test
    public void Squad_find_returnsInstanceOfSquadOfParticularId_Squad(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertEquals(mySquad, Squad.find(mySquad.getId()));
    }
    @Test
    public void Squad_clear_removesAllInstancesOfSquad_true(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        Squad.clear();
        assertEquals(0,Squad.all().size());
    }
    @Test
    public void Squad_remove_removesAParticularSquad_false(){
        Squad firstSquad = new Squad("Changers", 3, "Climate Change");
        Squad secondSquad = new Squad("Makers",4,"Worship");
        Squad.remove(firstSquad.getId());
        assertFalse(Squad.all().contains(firstSquad));
    }
    @Test
    public void Squad_getHeros_instantiatesWithEmptyHeroList_int(){
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        assertEquals(0, mySquad.getHeros().size());
    }
    @Test
    public void Squad_addHeros_addsHeroInstanceToSquad_true(){
        Hero myHero = new Hero("Wangari", 50, "Environment ambassador","corruption");
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        mySquad.addHero(Hero.find(myHero.getId()));
        assertTrue(mySquad.getHeros().contains(myHero));
    }
    @Test
    public void Squad_removeHero_removesHeroFromASquad_false(){
        Hero firstHero = new Hero("Wangari", 50, "Environment ambassador","corruption");
        Hero secondHero = new Hero("Sonko", 40, "Governer","Nairobians Littering Everywhere");
        Squad mySquad = new Squad("Changers", 3, "Climate Change");
        mySquad.addHero(Hero.find(firstHero.getId()));
        mySquad.addHero(Hero.find(secondHero.getId()));
        mySquad.removeHero(Hero.find(secondHero.getId()));
        assertFalse(mySquad.getHeros().contains(secondHero));
    }

}
