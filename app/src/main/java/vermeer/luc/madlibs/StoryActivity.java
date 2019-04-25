package vermeer.luc.madlibs;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        getSupportFragmentManager().popBackStack();
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("madeStory");
        TextView storyText = (TextView) findViewById(R.id.textStory);
        storyText.setText(Html.fromHtml(story.toString(), Html.FROM_HTML_MODE_COMPACT));
    }


}
