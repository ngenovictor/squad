import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingkong on 8/18/17.
 */
public class Hero {
    //        name, age, special power and weakness.
    private String mName;
    private int mAge;
    private String mSpecialPower;
    private String mWeakness;
    private static List<Hero> instances = new ArrayList<>();
    private int mId;

    public Hero(String name, int age, String special_power,String weakness){
        mName = name;
        mAge = age;
        mSpecialPower = special_power;
        mWeakness = weakness;
        instances.add(this);
        mId = instances.size();
    }
    public String getName(){
        return mName;
    }
    public int getAge(){
        return mAge;
    }
    public String getSpecialPower(){
        return mSpecialPower;
    }
    public String getWeakness(){
        return mWeakness;
    }
    public int getId(){
        return mId;
    }
    public static List<Hero> all(){
        return instances;
    }
    public static void clear(){
        instances.clear();
    }
    public static Hero find(int id){
        return instances.get(id-1);
    }
    public static void remove(int id){
        instances.remove(id-1);
    }


}
