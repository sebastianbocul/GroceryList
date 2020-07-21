package com.sebix.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITILE="com.sebix.grocerylist.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION="com.sebix.grocerylist.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY="com.sebix.grocerylist.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescritpion;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescritpion = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        numberPickerPriority.setMaxValue(10);
        numberPickerPriority.setMinValue(1);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String descritpion = editTextDescritpion.getText().toString();
        int priority = numberPickerPriority.getValue();
        if (title.trim().isEmpty() || descritpion.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITILE,title);
        data.putExtra(EXTRA_DESCRIPTION,descritpion);
        data.putExtra(EXTRA_PRIORITY,priority);
        setResult(RESULT_OK,data);
        finish();

    }
}

