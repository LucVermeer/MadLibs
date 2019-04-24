package vermeer.luc.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("madeStory");

        TextView storyText = (TextView) findViewById(R.id.textStory);
        storyText.setText(story.toString());
    }


}
