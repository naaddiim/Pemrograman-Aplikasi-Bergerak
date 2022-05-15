package proyekAkhir.JSN.mygadget;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class HpModel {

    //nama variable list dan semua variable dalam model mengikuti API
    private ArrayList<Result> data;

    public ArrayList<Result> getData() {
        return data;
    }

    public void setData(List<Result> data) {
        this.data = (ArrayList<Result>) data;
    }

    public class Result {

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
