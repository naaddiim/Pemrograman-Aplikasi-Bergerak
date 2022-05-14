package NadimIF4A.example.pertemuan7.models;

import org.json.JSONArray;

import java.util.List;

public class ResponseData {

    //List dari isi object(ResponseMeal class)
    private List<ResponseMeal> meals;

    public List<ResponseMeal> getMeals() {
        return meals;
    }

    public void setMeals(List<ResponseMeal> meals) {
        this.meals = meals;
    }
}
