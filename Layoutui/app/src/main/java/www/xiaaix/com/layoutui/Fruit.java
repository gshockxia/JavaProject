package www.xiaaix.com.layoutui;

/**
 * Created by Monster on 2016/8/17.
 */
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
