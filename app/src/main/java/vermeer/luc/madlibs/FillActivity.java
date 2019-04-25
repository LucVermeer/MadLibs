package vermeer.luc.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FillActivity extends AppCompatActivity {

    public Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        String filename = (String) intent.getSerializableExtra("selectedStory");
        int fileId = getResources().getIdentifier(filename, "raw", getPackageName());
        InputStream is = getResources().openRawResource(fileId);

        story = new Story(is);
        updateViews();
    }

    public void updateViews() {
        String wordType = story.getNextPlaceholder();
        int counter = story.getPlaceholderRemainingCount();

        TextView infoText = (TextView) findViewById(R.id.textFill);
        TextView counterText = (TextView) findViewById(R.id.textCounter);
        EditText input = (EditText) findViewById(R.id.inputFill);

        infoText.setText("Fill in a/an " + wordType +" below");
        if (counter == 1) {
            counterText.setText("Only 1 more word to complete the story!");

        } else {
            counterText.setText(Integer.toString(counter) + " more words to complete the story!");
        }

        input.setText("");
        input.setHint(wordType);
    }

    public void fillWord(View view) {
        EditText input = (EditText) findViewById(R.id.inputFill);
        String inputText = input.getText().toString();
        story.fillInPlaceholder(inputText);
        if (story.getPlaceholderRemainingCount() == 0) {
            Intent intent = new Intent(FillActivity.this, StoryActivity.class);
            intent.putExtra("madeStory", story);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }
        updateViews();
    }
}
