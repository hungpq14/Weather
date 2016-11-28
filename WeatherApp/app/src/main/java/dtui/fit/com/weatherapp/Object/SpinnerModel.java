package dtui.fit.com.weatherapp.Object;

/**
 * Created by Win 81 on 11/28/2016.
 */
public class SpinnerModel {

    private int Image=0;
    private String Type="";

    public  SpinnerModel(int Image, String Type){
        this.Image = Image;
        this.Type = Type;
    }
    //Set methods
    public void setImage(int Image){
        this.Image = Image;
    }
    public void setType(String Type){
        this.Type = Type;
    }
    //Get method
    public int getImage(){
        return this.Image;
    }
    public  String getType(){
        return this.Type;
    }
}
