package helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import models.Directory;

/**
 * Created by xzbla on 17/10/2015.
 */
public class DatabaseHelper  extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "nzschools";

    // Directories table name
    private static final String TABLE_DIRECTORIES = "directories";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_SCHOOL_ID = "school_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TELEPHONE = "telephone";
    private static final String KEY_FAX = "fax";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PRINCIPAL = "principal";
    private static final String KEY_SCHOOL_WEBSITE = "school_website";
    private static final String KEY_STREET = "street";
    private static final String KEY_SUBURB = "suburb";
    private static final String KEY_CITY = "city";
    private static final String KEY_REGION = "region";
    private static final String KEY_POSTAL_ADDRESS_1 = "postal_address_1";
    private static final String KEY_POSTAL_ADDRESS_2 = "postal_address_2";
    private static final String KEY_POSTAL_ADDRESS_3 = "postal_address_3";
    private static final String KEY_POSTAL_CODE = "postal_code";
    private static final String KEY_URBAN_AREA = "urban_area";
    private static final String KEY_SCHOOL_TYPE = "school_type";
    private static final String KEY_DEFINITION = "definition";
    private static final String KEY_AUTHORITY = "authority";
    private static final String KEY_GENDER_OF_STUDENTS = "gender_of_students";
    private static final String KEY_TERRITORIAL_AUTHORITY_WITH_AUCKLAND_LOCAL_BOARD = "territorial_authority_with_auckland_local_board";
    private static final String KEY_MINISTRY_OF_EDUCATION_LOCAL_OFFICE = "ministry_of_education_local_office";
    private static final String KEY_EDUCATION_REGION = "education_region";
    private static final String KEY_GENERAL_ELECTORATE = "general_electorate";
    private static final String KEY_MĀORI_ELECTORATE = "māori_electorate";
    private static final String KEY_CENSUS_AREA_UNIT = "census_area_unit";
    private static final String KEY_WARD = "ward";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_DECILE = "decile";
    private static final String KEY_TOTAL_SCHOOL_ROLL = "total_school_roll";
    private static final String KEY_EUROPEAN_PĀKEHĀ = "european_pākehā";
    private static final String KEY_MĀORI = "māori";
    private static final String KEY_PASIFIKA = "pasifika";
    private static final String KEY_ASIAN = "asian";
    private static final String KEY_MELAA = "melaa";
    private static final String KEY_OTHER = "other";
    private static final String KEY_CHANGE_ID = "change_id";
    private static final String KEY_STATUS = "status";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DIRECTORIES_TABLE = "CREATE TABLE " + TABLE_DIRECTORIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_SCHOOL_ID + " INTEGER,"
                + KEY_NAME + " TEXT,"
                + KEY_TELEPHONE + " TEXT,"
                + KEY_FAX + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PRINCIPAL + " TEXT,"
                + KEY_SCHOOL_WEBSITE  + " TEXT,"
                + KEY_STREET + " TEXT,"
                + KEY_SUBURB + " TEXT,"
                + KEY_CITY + " TEXT,"
                + KEY_REGION + " TEXT,"
                + KEY_POSTAL_ADDRESS_1 + " TEXT,"
                + KEY_POSTAL_ADDRESS_2 + " TEXT,"
                + KEY_POSTAL_ADDRESS_3 + " TEXT,"
                + KEY_POSTAL_CODE + " TEXT,"
                + KEY_URBAN_AREA + " TEXT,"
                + KEY_SCHOOL_TYPE + " TEXT,"
                + KEY_DEFINITION + " TEXT,"
                + KEY_AUTHORITY + " TEXT,"
                + KEY_GENDER_OF_STUDENTS + " TEXT,"
                + KEY_TERRITORIAL_AUTHORITY_WITH_AUCKLAND_LOCAL_BOARD + " TEXT,"
                + KEY_MINISTRY_OF_EDUCATION_LOCAL_OFFICE + " TEXT,"
                + KEY_EDUCATION_REGION + " TEXT,"
                + KEY_GENERAL_ELECTORATE + " TEXT,"
                + KEY_MĀORI_ELECTORATE + " TEXT,"
                + KEY_CENSUS_AREA_UNIT + " TEXT,"
                + KEY_WARD + " TEXT,"
                + KEY_LATITUDE + " REAL,"
                + KEY_LONGITUDE + " REAL,"
                + KEY_DECILE + " INTEGER,"
                + KEY_TOTAL_SCHOOL_ROLL + " INTEGER,"
                + KEY_EUROPEAN_PĀKEHĀ + " INTEGER,"
                + KEY_MĀORI + " INTEGER,"
                + KEY_PASIFIKA + " INTEGER,"
                + KEY_ASIAN + " INTEGER,"
                + KEY_MELAA + " INTEGER,"
                + KEY_OTHER + " INTEGER,"
                + KEY_CHANGE_ID + " INTEGER,"
                + KEY_STATUS + " INTEGER)";
        db.execSQL(CREATE_DIRECTORIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIRECTORIES);

        // Create tables again
        onCreate(db);
    }

    public void addDirectory(Directory directory)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCHOOL_ID, directory.getSchoolId());
        values.put(KEY_NAME, directory.getName());
        values.put(KEY_TELEPHONE, directory.getTelephone());
        values.put(KEY_FAX, directory.getFax());
        values.put(KEY_EMAIL, directory.getEmail());
        values.put(KEY_PRINCIPAL, directory.getPrincipal());
        values.put(KEY_SCHOOL_WEBSITE, directory.getSchoolWebsite());
        values.put(KEY_STREET, directory.getStreet());
        values.put(KEY_SUBURB, directory.getSuburb());
        values.put(KEY_CITY, directory.getCity());
        values.put(KEY_REGION, directory.getRegion());
        values.put(KEY_POSTAL_ADDRESS_1, directory.getPostalAddress1());
        values.put(KEY_POSTAL_ADDRESS_2, directory.getPostalAddress2());
        values.put(KEY_POSTAL_ADDRESS_3, directory.getPostalAddress3());
        values.put(KEY_POSTAL_CODE, directory.getPostalCode());
        values.put(KEY_URBAN_AREA, directory.getUrbanArea());
        values.put(KEY_SCHOOL_TYPE, directory.getSchoolType());
        values.put(KEY_DEFINITION, directory.getDefinition());
        values.put(KEY_AUTHORITY, directory.getAuthority());
        values.put(KEY_GENDER_OF_STUDENTS, directory.getGenderOfStudents());
        values.put(KEY_TERRITORIAL_AUTHORITY_WITH_AUCKLAND_LOCAL_BOARD, directory.getTerritorialAuthorityWithAucklandLocalBoard());
        values.put(KEY_MINISTRY_OF_EDUCATION_LOCAL_OFFICE, directory.getMinistryOfEducationLocalOffice());
        values.put(KEY_EDUCATION_REGION, directory.getEducationRegion());
        values.put(KEY_GENERAL_ELECTORATE, directory.getGeneralElectorate());
        values.put(KEY_MĀORI_ELECTORATE, directory.getMāoriElectorate());
        values.put(KEY_CENSUS_AREA_UNIT, directory.getCensusAreaUnit());
        values.put(KEY_WARD, directory.getWard());
        values.put(KEY_LATITUDE, directory.getLatitude());
        values.put(KEY_LONGITUDE, directory.getLongitude());
        values.put(KEY_DECILE, directory.getDecile());
        values.put(KEY_TOTAL_SCHOOL_ROLL, directory.getTotalSchoolRoll());
        values.put(KEY_EUROPEAN_PĀKEHĀ, directory.getEuropeanPākehā());
        values.put(KEY_MĀORI, directory.getMāori());
        values.put(KEY_PASIFIKA, directory.getPasifika());
        values.put(KEY_ASIAN, directory.getAsian());
        values.put(KEY_MELAA, directory.getMelaa());
        values.put(KEY_OTHER, directory.getOther());
        values.put(KEY_CHANGE_ID, directory.getChangeId());
        values.put(KEY_STATUS, directory.getStatus());

        db.insert(TABLE_DIRECTORIES, null, values);
        db.close();
    }

    public Directory getDirectory(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DIRECTORIES, new String[]{
                        KEY_ID,
                        KEY_SCHOOL_ID,
                        KEY_NAME,
                        KEY_TELEPHONE,
                        KEY_FAX,
                        KEY_EMAIL,
                        KEY_PRINCIPAL,
                        KEY_SCHOOL_WEBSITE,
                        KEY_STREET,
                        KEY_SUBURB,
                        KEY_CITY,
                        KEY_REGION,
                        KEY_POSTAL_ADDRESS_1,
                        KEY_POSTAL_ADDRESS_2,
                        KEY_POSTAL_ADDRESS_3,
                        KEY_POSTAL_CODE,
                        KEY_URBAN_AREA,
                        KEY_SCHOOL_TYPE,
                        KEY_DEFINITION,
                        KEY_AUTHORITY,
                        KEY_GENDER_OF_STUDENTS,
                        KEY_TERRITORIAL_AUTHORITY_WITH_AUCKLAND_LOCAL_BOARD,
                        KEY_MINISTRY_OF_EDUCATION_LOCAL_OFFICE,
                        KEY_EDUCATION_REGION,
                        KEY_GENERAL_ELECTORATE,
                        KEY_MĀORI_ELECTORATE,
                        KEY_CENSUS_AREA_UNIT,
                        KEY_WARD,
                        KEY_LATITUDE,
                        KEY_LONGITUDE,
                        KEY_DECILE,
                        KEY_TOTAL_SCHOOL_ROLL,
                        KEY_EUROPEAN_PĀKEHĀ,
                        KEY_MĀORI,
                        KEY_PASIFIKA,
                        KEY_ASIAN,
                        KEY_MELAA,
                        KEY_OTHER,
                        KEY_CHANGE_ID,
                        KEY_STATUS
                }, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Directory directory = new Directory(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14),
                cursor.getString(15),
                cursor.getString(16),
                cursor.getString(17),
                cursor.getString(18),
                cursor.getString(19),
                cursor.getString(20),
                cursor.getString(21),
                cursor.getString(22),
                cursor.getString(23),
                cursor.getString(24),
                cursor.getString(25),
                cursor.getString(26),
                cursor.getString(27),
                cursor.getDouble(28),
                cursor.getDouble(29),
                Integer.parseInt(cursor.getString(30)),
                Integer.parseInt(cursor.getString(31)),
                Integer.parseInt(cursor.getString(32)),
                Integer.parseInt(cursor.getString(33)),
                Integer.parseInt(cursor.getString(34)),
                Integer.parseInt(cursor.getString(35)),
                Integer.parseInt(cursor.getString(36)),
                Integer.parseInt(cursor.getString(37)),
                Integer.parseInt(cursor.getString(38)),
                Integer.parseInt(cursor.getString(39))== 1 ? true : false);

        return directory;
    }

    public ArrayList<Directory> getAllDirectories()
    {
        ArrayList<Directory> directoriesList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DIRECTORIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Directory directory = new Directory(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13),
                        cursor.getString(14),
                        cursor.getString(15),
                        cursor.getString(16),
                        cursor.getString(17),
                        cursor.getString(18),
                        cursor.getString(19),
                        cursor.getString(20),
                        cursor.getString(21),
                        cursor.getString(22),
                        cursor.getString(23),
                        cursor.getString(24),
                        cursor.getString(25),
                        cursor.getString(26),
                        cursor.getString(27),
                        cursor.getDouble(28),
                        cursor.getDouble(29),
                        Integer.parseInt(cursor.getString(30)),
                        Integer.parseInt(cursor.getString(31)),
                        Integer.parseInt(cursor.getString(32)),
                        Integer.parseInt(cursor.getString(33)),
                        Integer.parseInt(cursor.getString(34)),
                        Integer.parseInt(cursor.getString(35)),
                        Integer.parseInt(cursor.getString(36)),
                        Integer.parseInt(cursor.getString(37)),
                        Integer.parseInt(cursor.getString(38)),
                        Integer.parseInt(cursor.getString(39))== 1 ? true : false);
                directoriesList.add(directory);
            } while (cursor.moveToNext());
        }

        return directoriesList;
    }

    public ArrayList<Directory> getDirectories(String region, String city, String suburb,
                                               String genderOfStudents, String schoolType,
                                               String decile)
    {
        ArrayList<Directory> directoriesList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_DIRECTORIES + " WHERE " +
                KEY_REGION + "='" + region + " Region'";

        if (!city.equals("All Cities"))
        {
            query = query + " AND " + KEY_CITY + "='" + city + "'";
        }

        if (!suburb.equals("All Suburbs"))
        {
            query = query + " AND " + KEY_SUBURB + "='" + suburb + "'";
        }

        if (!genderOfStudents.equals("All Genders"))
        {
            query = query + " AND " + KEY_GENDER_OF_STUDENTS + "='" + genderOfStudents + "'";
        }

        if (!schoolType.equals("All School Types"))
        {
            query = query + " AND " + KEY_SCHOOL_TYPE + "='" + schoolType + "'";
        }

        if (!decile.equals("All Deciles"))
        {
            query = query + " AND " + KEY_DECILE + "='" + decile + "'";
        }

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Directory directory = new Directory(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13),
                        cursor.getString(14),
                        cursor.getString(15),
                        cursor.getString(16),
                        cursor.getString(17),
                        cursor.getString(18),
                        cursor.getString(19),
                        cursor.getString(20),
                        cursor.getString(21),
                        cursor.getString(22),
                        cursor.getString(23),
                        cursor.getString(24),
                        cursor.getString(25),
                        cursor.getString(26),
                        cursor.getString(27),
                        cursor.getDouble(28),
                        cursor.getDouble(29),
                        Integer.parseInt(cursor.getString(30)),
                        Integer.parseInt(cursor.getString(31)),
                        Integer.parseInt(cursor.getString(32)),
                        Integer.parseInt(cursor.getString(33)),
                        Integer.parseInt(cursor.getString(34)),
                        Integer.parseInt(cursor.getString(35)),
                        Integer.parseInt(cursor.getString(36)),
                        Integer.parseInt(cursor.getString(37)),
                        Integer.parseInt(cursor.getString(38)),
                        Integer.parseInt(cursor.getString(39))== 1 ? true : false);
                directoriesList.add(directory);
            } while (cursor.moveToNext());
        }

        return directoriesList;
    }

    public int getDirectoriesCount()
    {
        String countQuery = "SELECT COUNT(*) FROM " + TABLE_DIRECTORIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int count= cursor.getInt(0);
        cursor.close();

        return count;
    }

    public int updateDirectory(Directory directory)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCHOOL_ID, directory.getSchoolId());
        values.put(KEY_NAME, directory.getName());
        values.put(KEY_TELEPHONE, directory.getTelephone());
        values.put(KEY_FAX, directory.getFax());
        values.put(KEY_EMAIL, directory.getEmail());
        values.put(KEY_PRINCIPAL, directory.getPrincipal());
        values.put(KEY_SCHOOL_WEBSITE, directory.getSchoolWebsite());
        values.put(KEY_STREET, directory.getStreet());
        values.put(KEY_SUBURB, directory.getSuburb());
        values.put(KEY_CITY, directory.getCity());
        values.put(KEY_REGION, directory.getRegion());
        values.put(KEY_POSTAL_ADDRESS_1, directory.getPostalAddress1());
        values.put(KEY_POSTAL_ADDRESS_2, directory.getPostalAddress2());
        values.put(KEY_POSTAL_ADDRESS_3, directory.getPostalAddress3());
        values.put(KEY_POSTAL_CODE, directory.getPostalCode());
        values.put(KEY_URBAN_AREA, directory.getUrbanArea());
        values.put(KEY_SCHOOL_TYPE, directory.getSchoolType());
        values.put(KEY_DEFINITION, directory.getDefinition());
        values.put(KEY_AUTHORITY, directory.getAuthority());
        values.put(KEY_GENDER_OF_STUDENTS, directory.getGenderOfStudents());
        values.put(KEY_TERRITORIAL_AUTHORITY_WITH_AUCKLAND_LOCAL_BOARD, directory.getTerritorialAuthorityWithAucklandLocalBoard());
        values.put(KEY_MINISTRY_OF_EDUCATION_LOCAL_OFFICE, directory.getMinistryOfEducationLocalOffice());
        values.put(KEY_EDUCATION_REGION, directory.getEducationRegion());
        values.put(KEY_GENERAL_ELECTORATE, directory.getGeneralElectorate());
        values.put(KEY_MĀORI_ELECTORATE, directory.getMāoriElectorate());
        values.put(KEY_CENSUS_AREA_UNIT, directory.getCensusAreaUnit());
        values.put(KEY_WARD, directory.getWard());
        values.put(KEY_LATITUDE, directory.getLatitude());
        values.put(KEY_LONGITUDE, directory.getLongitude());
        values.put(KEY_DECILE, directory.getDecile());
        values.put(KEY_TOTAL_SCHOOL_ROLL, directory.getTotalSchoolRoll());
        values.put(KEY_EUROPEAN_PĀKEHĀ, directory.getEuropeanPākehā());
        values.put(KEY_MĀORI, directory.getMāori());
        values.put(KEY_PASIFIKA, directory.getPasifika());
        values.put(KEY_ASIAN, directory.getAsian());
        values.put(KEY_MELAA, directory.getMelaa());
        values.put(KEY_OTHER, directory.getOther());
        values.put(KEY_CHANGE_ID, directory.getChangeId());
        values.put(KEY_STATUS, directory.getStatus());

        return db.update(TABLE_DIRECTORIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(directory.getId()) });
    }

    public void deleteDirectory(Directory directory)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DIRECTORIES, KEY_ID + " = ?",
                new String[]{String.valueOf(directory.getId())});
        db.close();
    }

    public void deleteAllDirectories()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_DIRECTORIES);
        db.close();
    }
}
