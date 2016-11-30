package dtui.fit.com.weatherapp.Service;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import dtui.fit.com.weatherapp.Models.Noti_data;

/**
 * Created by Administrator on 28/11/2016.
 */

public class MyService extends IntentService {
    public MyService() {
        super("MyService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        getDatafromUet();
    }
    public void getDatafromUet(){
        new GetDataFromUET().execute();
        Log.d("TAG","lay du lieu");
    }

    public class GetDataFromUET extends AsyncTask<String,Void,ArrayList> {


        @Override
        protected ArrayList doInBackground(String... params) {
            Document doc = null;
            ArrayList datas = new ArrayList();
            try {
                doc = Jsoup.connect("http://www.uet.vnu.edu.vn/taxonomy/term/53").get();
                Elements content = doc.select(".view-content div.views-row");


                for (int i = 0; i < content.size(); i++) {
                    Element div = content.get(i);

                    //lay dc title va link
                    Elements link_title =div.select(".views-field-title .field-content a");
                    Element a = link_title.get(0);
                    String link = a.attr("href");
                    String title = a.attr("alt");

                    //lay content
                    Elements cnt =div.select(".rtejustify span span");
                    Element cont = cnt.get(0);
                    String con = cont.text();

                    //
                    Noti_data item = new Noti_data(title,con,link);
                    datas.add(item);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.d("TAG",datas.size()+"");
            return datas;
        }

        @Override
        protected void onPostExecute(ArrayList arrayList) {
            super.onPostExecute(arrayList);
            for(int i=0;i<arrayList.size();i++){
                Noti_data item = (Noti_data) arrayList.get(i);
            }

        }
    }
}

