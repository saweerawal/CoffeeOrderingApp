package androidexample.com;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;
    public void submitOrder(View view) {

        display(quantity);
        displayPrice(quantity * 5);
        TextView quantityTextView = (TextView) findViewById(R.id.thank_you_message);
        if(quantity > 1) {
            quantityTextView.setText("Thank you for ordering " + quantity + " cups of coffee:)\n Visit Again");
        } else {
            quantityTextView.setText("Thank you for ordering " + quantity + " cup of coffee:) \n Visit Again" );
        }

    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity * 5);
    }
    public void decrement(View view) {
        if(quantity > 0) {
            quantity = quantity - 1;
        }
        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

