package com.example.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}

    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PETS = "pets";


    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class PetEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        public final static String TABLE_NAME = "pets";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME ="name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        /** Possible values for the gender of the pet. */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;


        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


        /** fonction validation **/
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }

    }



}
