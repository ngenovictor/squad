import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingkong on 8/18/17.
 */
public class Squad {
//    max size, name, and a cause

    private int mMaxSize;
    private String mName;
    private String mCause;
    private static List<Squad> instances = new ArrayList<>();
    private int mId;
    private List<Hero> mHeros;

    public Squad(String name, int max_size, String cause){
        mName = name;
        mMaxSize = max_size;
        mCause = cause;
        instances.add(this);
        mId = instances.size();
        mHeros = new ArrayList<>();
    }
    public String getName(){
        return mName;
    }
    public int getSize(){
        return mMaxSize;
    }
    public String getCause(){
        return mCause;
    }
    public static List<Squad> all(){
        return instances;
    }
    public int getId(){
        return mId;
    }
    public static Squad find(int id){
        return instances.get(id-1);
    }
    public static void clear(){
        instances.clear();
    }
    public static void remove(int id){
        instances.remove(id-1);
    }
    public List<Hero> getHeros(){
        return mHeros;
    }
    public void addHero(Hero myHero){
        mHeros.add(myHero);
    }
    public void removeHero(Hero myHero){
        mHeros.remove(myHero);
    }


}
