package proyekAkhir.JSN.mygadget.models.Hp.Detail;

import java.util.ArrayList;
import java.util.List;

public class DetailData {

    private String thumbnail, phone_name;

    List<Specifications> specifications;

    public String getThumbnail() {
        return thumbnail;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public List<Specifications> getSpecifications() {
        return specifications;
    }
}
