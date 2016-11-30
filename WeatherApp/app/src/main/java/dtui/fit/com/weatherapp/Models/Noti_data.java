package dtui.fit.com.weatherapp.Models;

/**
 * Created by Administrator on 28/11/2016.
 */

public class Noti_data {
    private String title;
    private String content;
    private String link;
    private String image;

    public Noti_data(String title, String content,String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public Noti_data(String title, String content, String link,String image) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.image= image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image){
        this.image= image;
    }
    public String getImage(){
        return image;
    }
}

