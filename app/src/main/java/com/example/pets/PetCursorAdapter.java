package com.example.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.pets.data.PetContract;

public class PetCursorAdapter  extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 );
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.summary);
        // Extract properties from cursor
        int nameColumnIndex = cursor.getInt(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME));
        int breedColumnIndex = cursor.getInt(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED));

        //red the pet att from the cursor
        String petName = cursor.getString(nameColumnIndex);
        String petBreed = cursor.getString(breedColumnIndex);

        // Populate fields with extracted properties
        nameTextView.setText(petName);
        summaryTextView.setText(String.valueOf(petBreed));
    }

}
