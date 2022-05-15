package proyekAkhir.JSN.mygadget;

import java.util.List;

public class LaptopModel {

    //nama variable list dan semua variable dalam model mengikuti API
    private List<Result> result;

    public List<Result> getResult() {

        return result;
    }

    public void setResult(List<Result> result) {

        this.result = result;
    }

    public class Result {

        private String laptop_id;
        private String brand_id;
        private String brand_name;
        private String laptop_name;
        private String image;

        public String getLaptop_id() {

            return laptop_id;
        }

        public void setLaptop_id(String laptop_id) {

            this.laptop_id = laptop_id;
        }

        public String getBrand_id() {

            return brand_id;
        }

        public void setBrand_id(String brand_id) {

            this.brand_id = brand_id;
        }

        public String getBrand_name() {

            return brand_name;
        }

        public void setBrand_name(String brand_name) {

            this.brand_name = brand_name;
        }

        public String getLaptop_name() {

            return laptop_name;
        }

        public void setLaptop_name(String laptop_name) {

            this.laptop_name = laptop_name;
        }

        public String getImage() {

            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "laptop_id='" + laptop_id + '\'' +
                    ", brand_id='" + brand_id + '\'' +
                    ", brand_name='" + brand_name + '\'' +
                    ", laptop_name='" + laptop_name + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }

}
