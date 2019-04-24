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

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.madlibs_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void startGame(View view) {
        Intent intent = new Intent(MainActivity.this, FillActivity.class);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String filename = getFilename(spinner);
        intent.putExtra("selectedStory", filename);
        Log.d("FILENAME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", filename);
        startActivity(intent);
    }

    private String getFilename(Spinner spinner) {
        int selectedStoryInt = spinner.getSelectedItemPosition();
        String selectedStoryText = spinner.getSelectedItem().toString();
        return "madlib" + Integer.toString(selectedStoryInt) + "_" +
                selectedStoryText.toLowerCase();
    }
}