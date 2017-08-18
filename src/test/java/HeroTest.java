import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by kingkong on 8/18/17.
 */
public class HeroTest {
    @Test
    public void Hero_instantiatesCorrectly_true(){
//        name, age, special power and weakness.
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertTrue(myHero instanceof Hero);
    }
    @Test
    public void Hero_instantiatesWithName_String(){
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertEquals("Victor", myHero.getName());
    }
    @Test
    public void Hero_instantiatesWithAge_int(){
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertEquals(16, myHero.getAge());
    }
    @Test
    public void Hero_instantiatesWithSpecialPower_String(){
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertEquals("Lying", myHero.getWeakness());
    }
    @Test
    public void Hero_instantiatesWithWeakness_String(){
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertEquals("Mathematics guru", myHero.getSpecialPower());
    }
    @Test
    public void clear_clearsAllInstancesOfHero_int(){
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        Hero.clear();
        assertEquals(0,Hero.all().size());
    }
    @Test
    public void all_returnsAllInstancesOfHero_true(){
        Hero.clear();
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertTrue(Hero.all().contains(myHero));
        assertTrue(Hero.all().size()==1);
    }
    @Test
    public void getId_instantiatesWithId_int(){
        Hero.clear();
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertEquals(1, myHero.getId());
    }
    @Test
    public void find_returnsHeroWithParticularId_true(){
        Hero.clear();
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        assertEquals(myHero, Hero.find(myHero.getId()));
    }
    @Test
    public void remove_removesHeroWithParticularId_false(){
        Hero.clear();
        Hero myHero = new Hero("Victor", 16, "Mathematics guru", "Lying");
        Hero.remove(myHero.getId());
        assertFalse(Hero.all().contains(myHero));
    }


}
