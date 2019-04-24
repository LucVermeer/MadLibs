package vermeer.luc.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;

public class FillActivity extends AppCompatActivity {

    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        InputStream is = getResources().openRawResource(R.raw.madlib1_tarzan);
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
        counterText.setText(Integer.toString(counter) + " more words to complete the story!");
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
            startActivity(intent);
            return;
        }
        updateViews();
    }
}
