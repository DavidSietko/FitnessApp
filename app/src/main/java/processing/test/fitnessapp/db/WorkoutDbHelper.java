package processing.test.fitnessapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class WorkoutDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "fitnessTracker.db";
    public static final int DATABASE_VERSION = 2;

    private static final Gson gson = new Gson(); // For JSON conversion

    // Workout Template Table
    public static final String TABLE_WORKOUT_TEMPLATES = "workout_templates";
    public static final String COLUMN_TEMPLATE_ID = "_id";
    public static final String COLUMN_TEMPLATE_NAME = "name";
    public static final String COLUMN_TEMPLATE_EXERCISE_NAMES_JSON = "exercise_names_json";

    // Workout Table
    public static final String TABLE_WORKOUTS = "workouts";
    public static final String COLUMN_WORKOUT_ID = "_id";
    public static final String COLUMN_WORKOUT_TEMPLATE_ID_FK = "template_id";
    public static final String COLUMN_WORKOUT_DATE = "date";

    // Exercise Table
    public static final String TABLE_EXERCISES = "exercises";
    public static final String COLUMN_EXERCISE_ID = "_id";
    public static final String COLUMN_EXERCISE_NAME = "name";
    public static final String COLUMN_EXERCISE_WORKOUT_ID_FK = "workout_id";
    public static final String COLUMN_EXERCISE_SETS_JSON = "sets_json";


    public WorkoutDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_WORKOUT_TEMPLATES_TABLE = "CREATE TABLE " + TABLE_WORKOUT_TEMPLATES + "("
                + COLUMN_TEMPLATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TEMPLATE_NAME + " TEXT UNIQUE NOT NULL,"
                + COLUMN_TEMPLATE_EXERCISE_NAMES_JSON + " TEXT" + ")";
        db.execSQL(CREATE_WORKOUT_TEMPLATES_TABLE);

        String CREATE_WORKOUTS_TABLE = "CREATE TABLE " + TABLE_WORKOUTS + "("
                + COLUMN_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_WORKOUT_TEMPLATE_ID_FK + " INTEGER,"
                + COLUMN_WORKOUT_DATE + " TEXT NOT NULL,"
                + "FOREIGN KEY(" + COLUMN_WORKOUT_TEMPLATE_ID_FK + ") REFERENCES " + TABLE_WORKOUT_TEMPLATES + "(" + COLUMN_TEMPLATE_ID + ") ON DELETE SET NULL"
                + ")";
        db.execSQL(CREATE_WORKOUTS_TABLE);

        String CREATE_EXERCISES_TABLE = "CREATE TABLE " + TABLE_EXERCISES + "("
                + COLUMN_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_EXERCISE_NAME + " TEXT NOT NULL,"
                + COLUMN_EXERCISE_WORKOUT_ID_FK + " INTEGER NOT NULL,"
                + COLUMN_EXERCISE_SETS_JSON + " TEXT,"
                + "FOREIGN KEY(" + COLUMN_EXERCISE_WORKOUT_ID_FK + ") REFERENCES " + TABLE_WORKOUTS + "(" + COLUMN_WORKOUT_ID + ") ON DELETE CASCADE"
                + ")";
        db.execSQL(CREATE_EXERCISES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("WorkoutDbHelper", "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT_TEMPLATES);
        onCreate(db);
    }

    // Helper to save LocalDate to ContentValues
    public static void putDate(ContentValues values, String key, LocalDate date) {
        values.put(key, date.toString()); // "YYYY-MM-DD"
    }

    // Helper to read LocalDate from Cursor
    public static LocalDate getDate(android.database.Cursor cursor, String columnName) {
        String dateStr = cursor.getString(cursor.getColumnIndexOrThrow(columnName));
        return LocalDate.parse(dateStr);
    }

    // Gson helpers for lists
    public static <T> String toJson(List<T> list) {
        return gson.toJson(list);
    }

    public static <T> List<T> fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }
}
