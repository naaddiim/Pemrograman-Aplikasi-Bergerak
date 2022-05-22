package proyekAkhir.JSN.mygadget.models;

import java.util.List;
import java.util.Map;

public class LainModel {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data{

        private int id;
        private String title;
        private double price;
        private String description;
        private String category;
        private String image;
        private List<Rating> rating;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<Rating> getRating() {
            return rating;
        }

        public void setRating(List<Rating> rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", price=" + price +
                    ", description='" + description + '\'' +
                    ", category='" + category + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }

        public class Rating
        {
            private double rate;
            private int count;

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }

}
