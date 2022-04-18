package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.occupationDB.Occupation;
import com.example.insense.repository.room.occupationDB.OccupationDAO;
import com.example.insense.repository.room.occupationDB.OccupationDB;

import java.util.ArrayList;
import java.util.List;

public class OccupationRepository {
    OccupationDB db;
    OccupationDAO occupationDAO;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public OccupationRepository(Context context) {

        ArrayList<Occupation> occupationList = new ArrayList<Occupation>() {
        };
        Occupation piano = new Occupation();
        piano.category = "хобби";
        piano.name = "Игра на пианино";
        piano.description = "LOL! WHAT?!";
        occupationList.add(piano);

        Occupation guitar = new Occupation();
        guitar.category = "хобби";
        guitar.name = "Игра на гитаре";
        guitar.description = "LOL! WHAT?!";
        occupationList.add(guitar);

        Occupation workout = new Occupation();
        workout.category = "спорт";
        workout.name = "разминка";
        workout.description = "LOL! WHAT?!";
        occupationList.add(workout);

        Occupation run = new Occupation();
        run.category = "спорт";
        run.name = "пробежка";
        run.description = "LOL! WHAT?!";
        occupationList.add(run);

        Occupation tennis = new Occupation();
        tennis.category = "спорт";
        tennis.name = "игра в теннис";
        tennis.description = "LOL! WHAT?!";
        occupationList.add(tennis);




        OccupationDB db = Room.databaseBuilder(context,
                OccupationDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        occupationDAO = db.occupationDAO();
        occupationDAO.insertAll(occupationList);
    }
    public List<String> occupation_by_category(String categ){
        List<Occupation> all;

        all = occupationDAO.loadOccupationByCategoriesName(categ);
        List<String> all_categ = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_categ.add(all.get(i).name);
        }
        return all_categ;
    }

}