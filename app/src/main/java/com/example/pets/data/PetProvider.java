package com.example.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.pets.data.PetContract.PetEntry;

public class PetProvider extends ContentProvider {

    /** Tag for the log messages */
    public static final String LOG_TAG = PetProvider.class.getSimpleName();

    private static final int PETS = 100;
    private static final int PET_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.

        // TODO: Add 2 content URIs to URI matcher
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY,PetContract.PATH_PETS,PETS);
    }


    //database helper object
    private PetDbHelper mDBHelper;


    @Override
    public boolean onCreate() {
        mDBHelper = new PetDbHelper(getContext());


        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteDatabase database=mDBHelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);

        switch (match){
            case PETS:
                cursor = database.query(PetEntry.TABLE_NAME,strings,s,strings1,null,null,s1);
                break;

            case PET_ID:
                s = PetEntry._ID + "=?";
                strings1 = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor =database.query(PetEntry.TABLE_NAME,strings,s,strings1,null,null,s1);
                break;

            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);

        }
        return cursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {

        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {

        return 0;
    }
}
