package com.example.randomquoteapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String[][] quotes = {
            {"The only way to do great work is to love what you do.", "Steve Jobs"},
            {"Imagination is more important than knowledge.", "Albert Einstein"},
            {"You miss 100% of the shots you don't take.", "Wayne Gretzky"},
            {"The best way to predict the future is to invent it.", "Alan Kay"},
            {"The only thing we have to fear is fear itself.", "Franklin D. Roosevelt"},
            {"Well done is better than well said.", "Benjamin Franklin"},
            {"Talk is cheap. Show me the code.", "Linus Torvalds"},
            {"Simplicity is the soul of efficiency.", "Austin Freeman"}
    };

    private TextView tvQuote, tvAuthor;
    private final Random random = new Random();
    private int lastIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuote = findViewById(R.id.tvQuote);
        tvAuthor = findViewById(R.id.tvAuthor);
        Button btnNewQuote = findViewById(R.id.btnNewQuote);

        showRandomQuote();
        btnNewQuote.setOnClickListener(v -> showRandomQuote());
    }

    private void showRandomQuote() {
        int index;
        do {
            index = random.nextInt(quotes.length);
        } while (index == lastIndex);
        lastIndex = index;

        tvQuote.setText(quotes[index][0]);
        tvAuthor.setText("— " + quotes[index][1]);

        // Smooth fade-in effect
        tvQuote.setAlpha(0f);
        tvAuthor.setAlpha(0f);
        tvQuote.animate().alpha(1f).setDuration(500).start();
        tvAuthor.animate().alpha(1f).setDuration(500).start();
    }
}