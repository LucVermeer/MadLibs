package vermeer.luc.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize spinner (from the Android Developers page).
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.madlibs_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void startGame(View view) {
        Intent intent = new Intent(MainActivity.this, FillActivity.class);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String filename = getFilename(spinner);
        intent.putExtra("selectedStory", filename);
        startActivity(intent);
    }

    private String getFilename(Spinner spinner) {
        int selectedStoryInt = spinner.getSelectedItemPosition();
        String selectedStoryText = spinner.getSelectedItem().toString();
        return "madlib" + Integer.toString(selectedStoryInt) + "_" +
                selectedStoryText.toLowerCase();
    }
}